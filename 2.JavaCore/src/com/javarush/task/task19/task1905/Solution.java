package com.javarush.task.task19.task1905;


import java.util.*;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            String s = this.customer.getCountryName();
            String s1 = "";
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(s)) {
                    s1 = entry.getKey();
                }
            }
            return s1;
        }

        public String getCompany() {
            return this.customer.getCompanyName();

        }

        public String getContactFirstName() {
            String[] str = this.contact.getName().split(",");
            String s = str[1];
            return s.trim();

        }

        public String getContactLastName() {
            String[] str = this.contact.getName().split(",");
            String s = str[0];
            return s.trim();

        }

        public String getDialString() {
            String s = this.contact.getPhoneNumber();
            String s2 = s.replaceAll("[^0-9]+", "").trim();
            //String s3 = s2.substring(0, 12);
            return "callto://+" + s2;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}