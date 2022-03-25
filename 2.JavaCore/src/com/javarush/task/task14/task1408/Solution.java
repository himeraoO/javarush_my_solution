package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if(country == "Russia"){
                hen = new RussianHen();
            }
            if(country == "Ukraine"){
                hen = new UkrainianHen();
            }if(country == "Moldova"){
                hen = new MoldovanHen();
            }if(country == "Belarus"){
                hen = new BelarusianHen();
            }
            return hen;
        }
    }
    
  
}
