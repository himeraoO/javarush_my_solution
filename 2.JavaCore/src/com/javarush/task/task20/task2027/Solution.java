package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");

        for (Word w:detectAllWords(crossword, "home", "same")) {
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> result = new ArrayList<>();
        int hor = crossword[0].length;
        int ver = crossword.length;

        outer:
        for (String s : words) {
            //по горизонтали
            for (int i = 0; i < ver; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hor; j++)
                    sb.append((char) crossword[i][j]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(horLine.indexOf(s), i);
                    word.setEndPoint(horLine.indexOf(s) + s.length() - 1, i);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(hor - horReverse.indexOf(s) - 1, i);
                    word.setEndPoint(hor - horReverse.indexOf(s) - s.length(), i);

                    result.add(word);
                    continue outer;
                }
            }
            //по вертикали
            for (int i = 0; i < hor; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] aCrossword : crossword)
                    sb.append((char) aCrossword[i]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, horLine.indexOf(s));
                    word.setEndPoint(i, horLine.indexOf(s) + s.length() - 1);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, ver - horReverse.indexOf(s) - 1);
                    word.setEndPoint(i, ver - s.length() - horReverse.indexOf(s));

                    result.add(word);
                    continue outer;
                }
            }

            //по диагонали вправо
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp < hor) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp++;
                    }
                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j + horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j + horLine.indexOf(s) + s.length() - 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp - 1 - horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp - horReverse.indexOf(s) - s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }

            //по диагонали влево
            for (int i = 0; i < ver; i++) {
                for (int j = hor - 1; j >= 0; j--) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp >= 0) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp--;
                    }

                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j - horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j - horLine.indexOf(s) - s.length() + 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp + 1 + horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }
        }

        System.out.println(result);

        return result;
    }


//    public static int[] isNextChar(int[][] crossword, char[] c, int n, int x, int y){
////        if (n == c.length-1){
////            return new int[]{x, y};
////        }else {
//            char chNew = c[n];
//            int[] xx = {0, 1, 1, 1, 0, -1, -1, -1};
//            int[] yy = {-1, -1, 0, 1, 1, 1, 0, -1};
//            for (int i = 0; i < 8; i++) {
//                int yyy = yy[i];
//                int xxx = xx[i];
//
//                int xkoor = xxx + x;
//                int ykoor = yyy + y;
//                while ((ykoor >= 0) && (ykoor < crossword.length) && (xkoor >= 0) && (xkoor < crossword[0].length))
////                    if ((chNew == crossword[ykoor][xkoor])&&(n == c.length-1)) {
////                        return new int[]{xkoor, ykoor};
////                    }
//                    if (chNew == crossword[ykoor][xkoor]) {
//                        if (chNew == c[c.length-1]){
//                            int[] in = new int[2];
//                            in[0] = xkoor;
//                            in[1] = ykoor;
//                            return in;
//                        }
////                        isNextChar(crossword, c, n + 1, yyy + y, xxx + x);
//                        for (int j = 2; j < c.length; j++) {
//                            xkoor += xx[i];
//                            ykoor += yy[i];
//                            chNew = c[++n];
//                        }
//                    }else {
//                        break;
//                    }
//
//
////            }
//        }
//        return null;
//    }
//
//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        ArrayList<Word> arrayList = new ArrayList<>();
//        outer:
//        for (String w:words) {
//            char[] strings = w.toCharArray();
//            int n = 0;
//            for (int i = 0; i < crossword.length; i++) {
//                for (int j = 0; j < crossword[i].length; j++) {
//                    if (crossword[i][j] == strings[n]){
//                        int[] fin = isNextChar(crossword, strings, n+1, j , i);
//                        if (fin != null){
//                            Word word = new Word(w);
//                            word.setStartPoint(j, i);
//                            word.setEndPoint(fin[0], fin[1] );
//                            arrayList.add(word);
////                            break;
//                            continue outer;
//                        }
//                    }
//                }
//            }
//
//        }
////        int count = 0;
////        for(int i = 0; i < a.length; i++){
////            for (int j = 0; j < a.length; j++){
////                 if (a[i][j] == 1){
////                  try{
////                       if((a[i][j+1] == 0 && a[i+1][j] == 0))
////
////                  count++;
////
////                } catch (ArrayIndexOutOfBoundsException e) {
////		            count++;
////	                }
////                 }
////            }
////        }
////        return count;
//        return arrayList;
//    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
