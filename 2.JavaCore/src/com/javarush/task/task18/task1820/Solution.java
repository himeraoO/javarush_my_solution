package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            FileReader fileReader = new FileReader(s1);
            FileWriter fileWriter = new FileWriter(s2);
            Scanner scanner = new Scanner(fileReader);
/*3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4

 */

            double d = 0.00;
            int result = 0;
            while (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                result = (int)Math.round(d);
                fileWriter.write(String.valueOf(result));
                fileWriter.write(" ");
            }


            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





//            String regexPlus = "^\\d+\\D5";
//            String regexNegative = "^\\D\\d+\\D51";
//            String regexIf = "^\\D";
//            double d = 0.00;
//            int result = 0;
//            while (scanner.hasNextDouble()){
//                d = scanner.nextDouble();
//                if(String.valueOf(d).matches(regexIf)){
//                    if(String.valueOf(d).matches(regexNegative)){
//                        result = (int) d - 1;
//                    }else {
//                        result = (int) d;
//                    }
//                } else {
//                    if (String.valueOf(d).matches(regexPlus)) {
//                        result = (int) d + 1;
//                    } else {
//                        result = (int) d;
//                    }
//                }
//                fileWriter.write(String.valueOf(result));
//                fileWriter.write(" ");
//            }
//            fileReader.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

//class Test {
//    public static void main(String[] args) {
//        double d = -3.51;
//        String regexPlus = "^\\d+\\D5";
//        String regexNegative = "^\\D\\d+\\D5[1-9]";
//        String regexIf = "^\\D";
//        int result = 0;
//        if(String.valueOf(d).matches(regexIf)){
//            if(String.valueOf(d).matches(regexNegative)){
//                result = (int) d - 1;
//            }else {
//                result = (int) d;
//            }
//        } else {
//            if (String.valueOf(d).matches(regexPlus)) {
//                result = (int) d + 1;
//            } else {
//                result = (int) d;
//            }
//        }
//
//
//
//
//        System.out.println(String.valueOf(result));
//    }
//}