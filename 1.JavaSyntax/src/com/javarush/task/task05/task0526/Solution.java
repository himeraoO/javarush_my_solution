package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("asdfasdf", 21, "adsfasdf");
        Man man2 = new Man("asd333fasdf", 214, "adsf333asdf");
        Woman woman1 = new Woman("asdfa444sdf", 231, "adsf444asdf");
        Woman woman2 = new Woman("asdfa555sdf", 211, "adsfa555sdf");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }
    public static class Man{
        String name;
        int age;
        String address;

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman{
        String name;
        int age;
        String address;
        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }


    //напишите тут ваш код
}
