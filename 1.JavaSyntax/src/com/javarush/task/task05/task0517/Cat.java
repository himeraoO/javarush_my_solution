package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;
    //имя, но инициализирующий все переменные класса, кроме адреса.
    public Cat(String name){
        this.name = name;
        this.age = 2;
        this.weight = 5;
        this.color = "white";
    }
    //имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "white";
    }
    //имя, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 5;
        this.color = "white";
    }
    //вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
    public Cat(int weight, String color){
        this.age = 1;
        this.weight = weight;
        this.color = color;
    }
    //вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
    public Cat(int weight, String color, String address){
        this.age = 2;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
    public static void main(String[] args) {

    }
}
