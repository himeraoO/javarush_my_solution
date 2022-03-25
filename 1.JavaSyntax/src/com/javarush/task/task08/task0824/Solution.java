package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        /*
        два дедушки, две бабушки, отец, мать, трое детей
         */

        Human children1 = new Human("children1", false, 5);
        Human children2 = new Human("children2", true, 7);
        Human children3 = new Human("children3", false, 9);

        Human father = new Human("father", true, 35, children1, children2, children3);
        Human mother = new Human("mother", false, 34, children1, children2, children3);

        Human grandFather1 = new Human("grandFather1", true, 63, father);
        Human grandMother1 = new Human("grandMother1", false, 62, father);
        Human grandFather2 = new Human("grandFather2", true, 65, mother);
        Human grandMother2 = new Human("grandMother2", false, 61, mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children ;
        //напишите тут ваш код

        public Human(String name, boolean sex, int age, Human... humans) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = Arrays.asList(humans);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
