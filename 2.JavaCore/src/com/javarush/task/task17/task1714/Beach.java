package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
    
    public synchronized int compareTo(Beach b){
        Float f1 = new Float(this.distance);
        Float f2 = new Float(b.distance);
        Integer i1 = new Integer(this.quality);
        Integer i2 = new Integer(b.quality);
       
      //  int result = this.name.compareTo(b.name);
        
      //  if (result == 0) {
           int result1 = f1.compareTo(f2);
           int result2 = i1.compareTo(i2);
         int  result = result2 - result1;
      //   }
        return result;
    }

    public static void main(String[] args) {

    }
}
