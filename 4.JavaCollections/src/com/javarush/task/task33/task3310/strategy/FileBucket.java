package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            String prefix = "temp";
            Random random = new Random();
            int i = random.nextInt();
            String name = prefix + i;
            path = Files.createTempFile(name,null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
     //       e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
//        return path.toFile().length();
        long l = 0;
        try {
            l = Files.size(path);
        } catch (IOException e) {
     //       e.printStackTrace();
        }
        return l;
    }

    public void putEntry(Entry entry){
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(entry);
            out.close();
            outputStream.close();
        } catch (IOException e) {
     //       e.printStackTrace();
        }
    }

    public Entry getEntry(){
        Entry entry = null;
        if(getFileSize() > 0) {
            try {
                InputStream inputStream = Files.newInputStream(path);
                ObjectInputStream in = new ObjectInputStream(inputStream);
                entry = (Entry) in.readObject();
                in.close();
                inputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
          //  e.printStackTrace();
        }
    }

}
