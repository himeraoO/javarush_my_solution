package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String text = bis.readLine();
            if ("exit".equals(text.toLowerCase())) {
                throw new InterruptOperationException();
            }

            return text;
        } catch (IOException ignored) { //suppose it will never occur
        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
            String currencyCode = ConsoleHelper.readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String s = ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        ConsoleHelper.writeMessage(res.getString("invalid.data"));
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                    continue;
                }
                return split;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage("\t 1 - " + res.getString("operation.INFO"));
            ConsoleHelper.writeMessage("\t 2 - " + res.getString("operation.DEPOSIT"));
            ConsoleHelper.writeMessage("\t 3 - " + res.getString("operation.WITHDRAW"));
            ConsoleHelper.writeMessage("\t 4 - " + res.getString("operation.EXIT"));
            Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
            try {
                return Operation.getAllowableOperationByOrdinal(i);
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
//
//    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");
//    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void writeMessage(String message) {
//        System.out.println(message);
//    }
//
//    public static String readString() throws InterruptOperationException {
//        try {
//            String text = bis.readLine();
//            if ("exit".equals(text.toLowerCase())) {
//                throw new InterruptOperationException();
//            }
//
//            return text;
//        } catch (IOException ignored) { //suppose it will never occur
//        }
//        return null;
//    }
//
//    public static String askCurrencyCode() throws InterruptOperationException{
////        writeMessage("Введите код валюты. 3 символа. пример: USD");
//        writeMessage(res.getString("choose.currency.code"));
//        while (true) {
//            String s = readString();
//            if (s == null || s.length() != 3) {
////                writeMessage("Введен не верный код. Повторите. " +
////                        "\n" + "Введите код валюты. 3 символа. пример: USD");
//                writeMessage(res.getString("invalid.data"));
//                writeMessage(res.getString("choose.currency.code"));
//                continue;
//            }
//            return s.toUpperCase();
//        }
//    }
//
//    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
////        while (true) {
////
////                writeMessage("Введите номинал и через пробел введите количество банкнот");
////                String n = readString();
////                if (n == null){
////                    writeMessage("Введены не корректные данные. Повторите.");
////                    continue;
////                }
////                String[] strings = n.split(" ");
////                if (strings.length != 2){
////                    writeMessage("Введены не корректные данные. Повторите.");
////                    continue;
////                }
////                try {
////                    int nn = Integer.parseInt(strings[0]);
////                    int ss = Integer.parseInt(strings[1]);
////                    if((nn <= 0) && (ss <= 0)){
////                        writeMessage("Введены не корректные данные. Повторите.");
////                        continue;
////                    }
////                }catch (Exception e){
////                    writeMessage("Введены не корректные данные. Повторите.");
////                    continue;
////                }
////                return strings;
////
//        while (true) {
////            ConsoleHelper.writeMessage(String.format("Please specify integer denomination and integer count. For example '10 3' means 30 %s", currencyCode));
//            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
//            String s = readString();
//            String[] split = null;
//            if (s == null || (split = s.split(" ")).length != 2) {
////                ConsoleHelper.writeMessage("Please specify valid data.");
//                writeMessage(res.getString("invalid.data"));
//            } else {
//                try {
//                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
////                        ConsoleHelper.writeMessage("Please specify valid data.");
//                        writeMessage(res.getString("invalid.data"));
//                } catch (NumberFormatException e) {
////                    ConsoleHelper.writeMessage("Please specify valid data.");
//                    writeMessage(res.getString("invalid.data"));
//                    continue;
//                }
//                return split;
//            }
//        }
//    }
//
//    public static Operation askOperation()throws InterruptOperationException{
//        while (true) {
//            writeMessage(res.getString("choose.operation"));
////            ConsoleHelper.writeMessage("Выберите операцию: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
//            writeMessage("1 - " + res.getString("operation.INFO") +
//                    ", 2 - " + res.getString("operation.DEPOSIT") +
//                    ", 3 - " + res.getString("operation.WITHDRAW") +
//                    ", 4 - " + res.getString("operation.EXIT"));
//            String s = readString();
//
//            try {
//                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
//            } catch (Exception ignored) {
////                ConsoleHelper.writeMessage("Пожалуйста! Выберите правильную операцию.......");
//                writeMessage(res.getString("invalid.data"));
////                writeMessage("1 - " + res.getString("operation.INFO") +
////                        ", 2 - " + res.getString("operation.DEPOSIT") +
////                        ", 3 - " + res.getString("operation.WITHDRAW") +
////                        ", 4 - " + res.getString("operation.EXIT"));
//            }
//
//        }
//    }
//
//    public static void printExitMessage(){
//        ConsoleHelper.writeMessage(res.getString("the.end"));
//    }

}
