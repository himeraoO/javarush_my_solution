package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        My1Thread thread1 = new My1Thread();
        My2Thread thread2 = new My2Thread();
        My3Thread thread3 = new My3Thread();
        My4Thread thread4 = new My4Thread();
        My5Thread thread5 = new My5Thread();

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);

    }

    public static void main(String[] args) {
    }

    public static class My1Thread extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }
    public static class My2Thread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }
    public static class My3Thread extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                   break;
                }
            }

        }
    }
    public static class My4Thread extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        @Override
        public void showWarning() {
            if(isAlive()){
                interrupt();
            }
        }
    }
    public static class My5Thread extends Thread{
        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int p = 0;
            String s;
            try {
                while (!(s = bufferedReader.readLine()).equals("N")){
                    p += Integer.parseInt(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(p);

        }
    }
}