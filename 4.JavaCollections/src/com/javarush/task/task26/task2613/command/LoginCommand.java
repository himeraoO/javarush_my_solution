package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

//    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"login");
//    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".resources.verifiedCards");
//
//    @Override
//    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage(res.getString("before"));
////        long numbercard = 123456789012L;
////        int pin = 1234;
//
//        while (true){
//            ConsoleHelper.writeMessage(res.getString("specify.data"));
//            long l = 0;
//            int i = 0;
//
//                //ConsoleHelper.writeMessage("Введите номер карты. 12 цифр.");
//
//
//            String card = ConsoleHelper.readString();
//                if (card.length() != 12){
////                    ConsoleHelper.writeMessage("Введены неверные данные. повторите.");
//                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
//                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//                    continue;
//                }
//            //ConsoleHelper.writeMessage("Введите пин-код карты. 4 цифры.");
//            String pinCode = ConsoleHelper.readString();
//            if (pinCode.length() != 4){
////                ConsoleHelper.writeMessage("Введены неверные данные. повторите.");
//                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
//                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//                continue;
//            }
//            try {
//                l = Long.parseLong(card);
//
//                i = Integer.parseInt(pinCode);
//            } catch (NumberFormatException e) {
////                ConsoleHelper.writeMessage("Введены неверные данные. повторите.");
//                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
//                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//                continue;
//            }
//
////            if((l == numbercard) &&(i == pin) ){
////                    ConsoleHelper.writeMessage("Верификация прошла успешно!");
////                    break;
////                }else {
////                ConsoleHelper.writeMessage("Введены неверные данные. повторите.");
////            }
//            if(validCreditCards.containsKey(card) && validCreditCards.getString(card).equals(pinCode)){
////                    ConsoleHelper.writeMessage("Верификация прошла успешно!");
//                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), card));
//                    break;
//                }else {
////                ConsoleHelper.writeMessage("Введены неверные данные. повторите.");
//                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), card));
//                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//            }
//            }
//    }
private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String creditCardNumber = ConsoleHelper.readString();
            String pinStr = ConsoleHelper.readString();
            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                    pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                try {
                    if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
        }

    }
}
