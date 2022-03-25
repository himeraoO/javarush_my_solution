package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fullFileName;
//        private ArrayList<String> arrayList = new ArrayList<>();
private String fin = "";

        public ReadFileThread() {
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < arrayList.size(); i++) {
//                if (i == arrayList.size()-1){
//                    stringBuilder.append(arrayList.get(i));
//                } else {
//                    stringBuilder.append(arrayList.get(i));
//                    stringBuilder.append(" ");
//                }
//            }
//            return stringBuilder.toString();
//            String temp = null;
//            for (String s: arrayList) {
//                temp += s + " ";
//            }
//            return temp;
            return fin;
        }

        @Override
        public void run() {
//            StringBuilder sb = new StringBuilder();
//            if(!fullFileName.equals("") || fullFileName != null) {
//                try {
//                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fullFileName));
//                    while (!bufferedReader.readLine().equals("") || bufferedReader.readLine() == null)
//                        sb.append(bufferedReader.readLine()).append(" ");
//                    bufferedReader.close();
//                    sb.setLength(sb.length() - 1);
//                    fin = sb.toString();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else {
//                fin = null;
//            }
//                try {
////                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fullFileName));
//                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fullFileName))) {
//                        while (!bufferedReader.readLine().equals("") || bufferedReader.readLine() == null)
//                            arrayList.add(bufferedReader.readLine());
////                        bufferedReader.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fullFileName));
                String s = null;
                while ((s = bufferedReader.readLine()) != null){
                    fin += (s + " ");
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //add your code here - добавьте код тут
}
