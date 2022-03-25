package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = 10;
    }
    public Circle(double x) {
        this.x = x;
        this.y = 2;
        this.radius = 5;
    }
//напишите тут ваш код

    public static void main(String[] args) {

    }
}