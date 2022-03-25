package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        /*
        -c name sex bd
        -u id name sex bd
        -d id
        -i id
3. При запуске программы с параметром -с
программа должна добавлять человека с заданными параметрами
в конец списка allPeople, и выводить id (index) на экран.

4. При запуске программы с параметром -u
программа должна обновлять данные человека с заданным id в списке allPeople.

5. При запуске программы с параметром -d
программа должна логически удалять человека с заданным id в списке allPeople.

6. При запуске программы с параметром -i
программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
        */
        Person person = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        switch (args[0]){
            case "-c":
                try {
                    date = formatter.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (args[2].equals("м"))
                    person = Person.createMale(args[1], date);
                else
                    person = Person.createFemale(args[1], date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;
            case "-u":
                Person personTemp = allPeople.get(Integer.parseInt(args[1]));
                personTemp.setName(args[2]);
                if (args[2].equals("м"))
                    personTemp.setSex(Sex.MALE);
                else
                    personTemp.setSex(Sex.FEMALE);
                try {
                    date = formatter.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                personTemp.setBirthDate(date);
                break;
            case "-d":
                Person personDelete = allPeople.get(Integer.parseInt(args[1]));
                personDelete.setName(null);
                personDelete.setSex(null);
                personDelete.setBirthDate(null);
                break;
            case "-i":
                Person personShow = allPeople.get(Integer.parseInt(args[1]));
                String sex = null;
                if(personShow.getSex() == Sex.MALE)
                    sex = "м";
                else
                    sex = "ж";
                SimpleDateFormat formatterShow = new SimpleDateFormat("dd-MMM-yyyy");
                System.out.println(personShow.getName() + " " + sex + " " + formatterShow.format(personShow.getBirthDate()));
                break;
        }
    }
}
