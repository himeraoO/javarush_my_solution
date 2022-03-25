package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = bufferedReader.readLine();
            String file2 = bufferedReader.readLine();

            FileReader fileReader1 = new FileReader(file1);
            FileReader fileReader2 = new FileReader(file2);

            ArrayList<String> file1S = new ArrayList<>();
            ArrayList<String> file2S = new ArrayList<>();

//            StringBuilder sb1 = new StringBuilder();
//            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

//            while (fileReader1.ready() || fileReader2.ready()) {
//                if (fileReader1.ready()) {
//                    sb1.append(fileReader1.read());
//                }
//                if (fileReader2.ready()) {
//                    sb2.append(fileReader2.read());
//                }
//            }

            while (bufferedReader1.ready()) {
                file1S.add(bufferedReader1.readLine());
            }
            while (bufferedReader2.ready()) {
                file2S.add(bufferedReader2.readLine());
            }

            bufferedReader1.close();
            fileReader1.close();
            bufferedReader2.close();
            fileReader2.close();

//            file1S.addAll(Arrays.asList(sb1.toString().split("\\n")));
//            file2S.addAll(Arrays.asList(sb2.toString().split("\\n")));

            int c1 = 0;
            int c2 = 0;
//            String s1 = "";
//            String s2 = "";
            while (c1 < file1S.size() || c2 < file2S.size()) {

//                if (c1 >= file1S.size()) {
//                    s1 = "";
//                } else {
//                    s1 = file1S.get(c1);
//                }
//
//                if (c2 >= file2S.size()) {
//                    s2 = "";
//                } else {
//                    s2 = file2S.get(c2);
//                }

//                String temp1 = "";
//                String temp2 = "";
//
//                if ((c1 + 1) >= file1S.size()) {
//                    temp1 = "";
//                } else {
//                    temp1 = file1S.get(c1 + 1);
//                }
//
//                if ((c2 + 1) >= file2S.size()) {
//                    temp2 = "";
//                } else {
//                    temp2 = file2S.get(c2 + 1);
//                }

//                if (s1.equals("")) {
                if (c1 == file1S.size()) {
//                    lines.add(new LineItem(Type.ADDED, s2));
                    lines.add(new LineItem(Type.ADDED, file2S.get(c2)));
                    break;

//                } else if (s2.equals("")) {
                }
                if (c2 == file2S.size()) {
//                    lines.add(new LineItem(Type.REMOVED, s1));
                    lines.add(new LineItem(Type.REMOVED, file1S.get(c1)));
                    break;

                }

//                if (s1.equals(s2)) {
                if (file1S.get(c1).equals(file2S.get(c2))) {
                    lines.add(new LineItem(Type.SAME, file1S.get(c1)));
                    c1++;
                    c2++;

//                } else if (s1.equals(temp2)) {
                } else if (file1S.get(c1+1).equals(file2S.get(c2))) {
//                        lines.add(new LineItem(Type.REMOVED, s1));
                    lines.add(new LineItem(Type.REMOVED, file1S.get(c1)));
                    c1++;
                }else if (file1S.get(c1).equals(file2S.get(c2 + 1))) {
//                        lines.add(new LineItem(Type.ADDED, s2));
                        lines.add(new LineItem(Type.ADDED, file2S.get(c2)));
                        c2++;
//                }else if (s2.equals(temp1)) {
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
