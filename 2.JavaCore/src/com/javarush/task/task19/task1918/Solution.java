package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {
//    public static void main(String[] args) {
////        String tag = args[0];
//
//        ///////////////////
//        String tag = "span";
//        ///////////////////
//
////        String file = "";
////        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
////            file = bufferedReader.readLine();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
////        StringBuilder sb = new StringBuilder();
////        try (FileReader fileReader = new FileReader(file)) {
////            while (fileReader.ready()) {
////                sb.append(fileReader.read());
////            }
////            parse(sb.toString(), tag);
//            //////////////////////////////////////////////
//        String test = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\n" +
//                "</span></b></span><span>Super</span><span>girl</span>";
//            parse(test, tag);
//            //////////////////////////////////////////////
//        for (String s:arrayList) {
//            System.out.println(s);
//        }
//
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//    }
//
//    private static ArrayList<String> arrayList = new ArrayList<>();
//
//
//
//    public static void parse(String s, String tag) {
//        boolean start = false;
//        StringBuilder str = new StringBuilder();
//
//        char[] chars = s.toCharArray();
////        char[] tags = tag.toCharArray();
//        int count = 0;
//        int recur = 0;
//        for (int i = 0; i < s.length(); i++) {
////////////////////////////////////////////////////////
//            if (start) {
//                str.append(chars[i]);
//            }
////            if ((chars[i] == '<') && start) {
////                str.append(chars[i]);
////            }
//
//
//            if ((chars[i] == '<')&& count == 0) {
//                if ((i + tag.length()) < s.length()) {
//                    StringBuilder temp = new StringBuilder();
//                    for (int j = 0; j < tag.length(); j++) {
//                        temp.append(chars[i + 1 + j]);
//                    }
//                    if (temp.toString().equals(tag)) {
//                        start = true;
//                        count++;
//                        recur++;
//                        str.append(chars[i]);
//                        temp.setLength(0);
//                    }
//                }
//            }
////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////
//            if ((chars[i] == '/')&& count > 0) {
//                if ((i + tag.length()) < s.length()) {
//                    StringBuilder temp = new StringBuilder();
//                    for (int j = 0; j < tag.length(); j++) {
//                        temp.append(chars[i + 1 + j]);
//                    }
//                    if (temp.toString().equals(tag)) {
//                        count--;
//                        if (count == 0) {
//                            str.append(temp).append('>');
//                            temp.setLength(0);
//                            start = false;
//                            arrayList.add(str.toString());
////                            System.out.println(arrayList);
//                            if(recur > 0) {
//                                parse(str.toString().substring(4, str.length()-6), tag);
//                            }
//                            str.setLength(0);
//                            continue;
//                        }else {
//                            str.append(chars[i]);
//
//                        }
//                    }
//                }
//                str.append(chars[i]);
//            }
////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////
//        }
//    }

    public static void main(String[] args) {

        String fileName = null;

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
            /*NOP*/
        }

        StringBuilder readFileContent = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent = readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
            /*NOP*/
        }

        String fileContent = readFileContent.toString().replaceAll("\r\n", "");

        String openTag = "<" + args[0];
        String closingTag = "</" + args[0];
        int tagLength = args[0].length();
        int startTagIndex = 0;
        int endTagIndex = 0;

        ArrayList<String> tags = new ArrayList<>();

        while ((startTagIndex != -1) && (startTagIndex < fileContent.length())) {
            startTagIndex = fileContent.indexOf(openTag, startTagIndex);
            endTagIndex = fileContent.indexOf(closingTag, startTagIndex + tagLength);

            int indexInTag = startTagIndex + tagLength;
            if (endTagIndex != -1) {
                while (fileContent.substring(indexInTag, endTagIndex).contains(openTag)) {
                    indexInTag = endTagIndex + tagLength;
                    endTagIndex = fileContent.indexOf(closingTag, indexInTag);
                }
            }
            if (startTagIndex != -1 && endTagIndex != -1) {
                tags.add(fileContent.substring(startTagIndex, endTagIndex + tagLength + 3));
                startTagIndex += tagLength;
            }
        }

        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}
