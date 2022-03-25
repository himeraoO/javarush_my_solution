package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

//        args = new String[] {"-c", "Василий", "м", "15/04/1990", "Алена", "ж", "08/05/1996"};
//      args = new String[] {"-u", "0", "Александр", "м", "21/07/1987", "1", "Елена", "ж", "08/09/1993"};
//     args = new String[] {"-d", "0", "1"};
//     args = new String[] {"-i", "0", "1"};

        //start here - начни тут
        /*
        -c name1 sex1 bd1 name2 sex2 bd2 ...
        -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
        -d id1 id2 id3 id4 ...
        -i id1 id2 id3 id4 ...
         */

        Person person = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        int count = 0;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    count = (args.length - 1) / 3;
                    for (int i = 0; i < count * 3; i += 3) {
                        try {
                            date = formatter.parse(args[3 + i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (args[2 + i].equals("м"))
                            person = Person.createMale(args[1 + i], date);
                        else
                            person = Person.createFemale(args[1 + i], date);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
//                    System.out.println(allPeople.get(0).getName() + " " + allPeople.get(0).getSex() + " " + allPeople.get(0).getBirthDate() + " " + allPeople.get(1).getName() + " " + allPeople.get(1).getSex() + " " + allPeople.get(1).getBirthDate());

                    count = (args.length - 1) / 4;
                    for (int i = 0; i < count * 4; i += 4) {
                        Person personTemp = allPeople.get(Integer.parseInt(args[1 + i]));
                        personTemp.setName(args[2 + i]);
                        if (args[3 + i].equals("м"))
                            personTemp.setSex(Sex.MALE);
                        else
                            personTemp.setSex(Sex.FEMALE);
                        try {
                            date = formatter.parse(args[4 + i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        personTemp.setBirthDate(date);
                    }
//                    System.out.println(allPeople.get(0).getName() + " " + allPeople.get(0).getSex() + " " + allPeople.get(0).getBirthDate() + " " + allPeople.get(1).getName() + " " + allPeople.get(1).getSex() + " " + allPeople.get(1).getBirthDate());
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    count = args.length - 1;
                    for (int i = 0; i < count; i++) {
                        Person personDelete = allPeople.get(Integer.parseInt(args[1 + i]));
                        personDelete.setName(null);
                        personDelete.setSex(null);
                        personDelete.setBirthDate(null);
                    }
                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    count = args.length - 1;
                    for (int i = 0; i < count; i++) {
                        Person personShow = allPeople.get(Integer.parseInt(args[1 + i]));
                        String sex = null;
                        if (personShow.getSex() == Sex.MALE)
                            sex = "м";
                        else
                            sex = "ж";
                        SimpleDateFormat formatterShow = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(personShow.getName() + " " + sex + " " + formatterShow.format(personShow.getBirthDate()));
                    }
                    break;
                }
        }
    }
}
