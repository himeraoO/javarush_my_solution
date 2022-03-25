package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private String name;
        private String lastName;
        private int weigth;
        private int height;
        private boolean sex;
        // Напишите тут ваши переменные и конструкторы

        public Human() {
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(int age, String name, String lastName) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
        }

        public Human(int age, String name, String lastName, int weigth) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.weigth = weigth;
        }

        public Human(int age, String name, String lastName, int weigth, int height) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.weigth = weigth;
            this.height = height;
        }

        public Human(String lastName, int weigth, boolean sex) {
            this.lastName = lastName;
            this.weigth = weigth;
            this.sex = sex;
        }

        public Human(int age, String lastName, int height, boolean sex) {
            this.age = age;
            this.lastName = lastName;
            this.height = height;
            this.sex = sex;
        }

        public Human(int age, String name, String lastName, int height, boolean sex) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.height = height;
            this.sex = sex;
        }

        public Human(String lastName) {
            this.lastName = lastName;
        }

        public Human(int age, String name, String lastName, int weigth, int height, boolean sex) {
            this.age = age;
            this.name = name;
            this.lastName = lastName;
            this.weigth = weigth;
            this.height = height;
            this.sex = sex;
        }
    }
}
