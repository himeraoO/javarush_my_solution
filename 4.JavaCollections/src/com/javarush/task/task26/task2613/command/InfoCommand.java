package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command{
//    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"info");
//
//    @Override
//    public void execute() {
//        ConsoleHelper.writeMessage(res.getString("before"));
//
////        String s = ConsoleHelper.askCurrencyCode();
////        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
////        ConsoleHelper.writeMessage(String.valueOf(currencyManipulator.getTotalAmount()));
//        boolean hasMoney = false;
//        for (CurrencyManipulator c : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
//            if(c.hasMoney()) {
//                hasMoney = true;
//                ConsoleHelper.writeMessage(String.valueOf(c.getCurrencyCode() + " - " + c.getTotalAmount()));
//            }
//        }
//        if (!hasMoney) {
////            ConsoleHelper.writeMessage("No money available.");
//            ConsoleHelper.writeMessage(res.getString("no.money"));
//        }
//    }
private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
