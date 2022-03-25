package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

class WithdrawCommand implements Command{
//    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"withdraw");
//
//    @Override
//    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage(res.getString("before"));
//        String s = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
//        while (true){
////            ConsoleHelper.writeMessage("Введите сумму.");
//            ConsoleHelper.writeMessage(res.getString("specify.amount"));
//         try {
//             int i = Integer.parseInt(ConsoleHelper.readString());
//             if(i > 0){
//                 if(currencyManipulator.isAmountAvailable(i)){
//                     Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
//                     map.putAll(currencyManipulator.withdrawAmount(i));
//                     for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//                         ConsoleHelper.writeMessage("\t" + e.getKey() + " - " + e.getValue());
//                     }
////                     ConsoleHelper.writeMessage("Tranzaction MOLODEC!");
//                     ConsoleHelper.writeMessage(String.format(res.getString("success.format"), i, s));
//                     break;
//                 }else {
//                     ConsoleHelper.writeMessage(res.getString("not.enough.money"));
//                 }
//             }
//         }catch (NumberFormatException e){
////             ConsoleHelper.writeMessage("Введены некорректные данные. Повторите попытку.");
//             ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
//
//         } catch (NotEnoughMoneyException e) {
////             ConsoleHelper.writeMessage("Совсем не хватает банкнот/купюр. Повторите попытку.");
//             ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
//         }
//        }
//
//    }
private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                String s = ConsoleHelper.readString();
                if (s == null) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
                            }

                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                            break;
                        } else {
                            ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        }
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    }
                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}
