package com.javarush.task.task40.task4004;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код

//        if((point != null) && (polygon != null)
//        && (polygon.size() > 0)){
//               for(Point p: polygon){
//                    if((point.x >= 0) && (point.x <= p.x)
//                    && (point.y >= 0) && (point.y <= p.y)){
//                        return true;
//                    }
//                }
//        }
//
//        return false;
        
    //   // if(point.x > polygon.get(0).x && point. > polygon.get(0).x)
        
    //   int c1 = 0;
    // //   int c2 = 0;
       
    //   for(Point p: polygon){
    //       if(p.x > c1){
    //           c1 = p.x;
    //       }
    //     //   if(p.y > c2){
    //     //       c2 = p.y;
    //     //   }
    //   }
       
    //   if(point.x > 0 && point.x < c1 && point.y > 0 && point.y < c1){
    //       return true;
    //   }
    //   return false;

        if(point == null || polygon == null || polygon.size() < 3){
            return false;
        }

        int[] xx = new int[polygon.size()];
        int[] yy = new int[polygon.size()];

        for (int i = 0; i < polygon.size(); i++) {
            Point p = polygon.get(i);
            xx[i] = p.x;
            yy[i] = p.y;
        }

        Polygon polygon1 = new Polygon(xx, yy, polygon.size());
        if (polygon1.contains(point.x, point.y)){
            return true;
        }
        return false;
    }

}

