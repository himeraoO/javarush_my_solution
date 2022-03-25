package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/


import java.util.*;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        public String getCompanyName() {
            return this.data.getCompany();
        }

        public String getCountryName() {
            String s = this.data.getCountryCode();
            return countries.get(s);
        }

        public String getName() {
            String s = this.data.getContactLastName() + ", " + this.data.getContactFirstName();
            return s;
        }

        public String getPhoneNumber() {

            //For example: 38 int getCountryPhoneCode(); 2
            //For example: 501234567 int getPhoneNumber(); 9
            //Дополнить телефонный номер нулями до 10 цифр при необходимости
            //For example: +38(050)123-45-67 String getPhoneNumber(); 18

//                     int num = this.data.getPhoneNumber();
//
//
//                     char[] nums = String.valueOf(num).toCharArray();
//                     if(nums.length < 10){
//                         char[] newNums = new char[10];
//                         int n = 10 - nums.length;
//                         int i = 0;
//                         for (i = 0; i < n; i++) {
//                             newNums[i] = 0;
//                         }
//                         if (newNums.length - i >= 0){
//                             System.arraycopy(nums, 0, newNums, i + 1, newNums.length - i + 1);
//                         }
//                         nums = new char[10];
//                     }
//                     StringBuilder newNumber = new StringBuilder();
//                     newNumber.append(nums);
//                     newNumber.insert(0, "(").insert(4, ")").insert(8, "-").insert(11, "-");
//


//                     int[]digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
//                     List list = Arrays.asList(digits);
            //         if(digits.length < 10){
            //           for (int i = 0; i < 10 - digits.length; i++)
            // {                list.add(i, 0);
            // }
            // }

            // String s2 = "(" + list.get(0) + list.get(1) + list.get(2) + ")" +
            // list.get(3) + list.get(4) + list.get(5) + "-" +
            // list.get(6) + list.get(7) + "-" +
            // list.get(8) + list.get(9);

            StringBuilder sb = new StringBuilder(String.format("%010d", data.getPhoneNumber()));
            sb.insert(0, "(").insert(4, ")").insert(8, "-").insert(11, "-");

            String s = "+" + this.data.getCountryPhoneCode() + sb;
            return s;
        }

    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}