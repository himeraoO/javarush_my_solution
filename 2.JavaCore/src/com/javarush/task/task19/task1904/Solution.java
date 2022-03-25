package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        @Override
        public Person read() throws IOException {
            Person p = null;

                String s = fileScanner.nextLine();
                String[] sP = s.split(" ");
                //Иванов Иван Иванович 31 12 1950
                String birthDate = sP[3] + " " + sP[4] + " " + sP[5];
                SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                Date date = null;
                try {
                    date = formatter.parse(birthDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                p = new Person(sP[1], sP[2], sP[0], date);

            return p;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }
    }
}
