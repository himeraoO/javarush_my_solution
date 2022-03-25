package com.javarush.task.task28.task2810;
import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.*;


public class Controller {
    
//    private Provider [] providers;
    private Model model;
    
//    public Controller (Provider... providers) throws IllegalArgumentException{
//        if (providers.length != 0){
//        this.providers = Arrays.copyOfRange(providers, 0, providers.length);
//        } else{
//            throw new IllegalArgumentException();
//        }
//    }

    public Controller(Model model) {
        if(model == null){
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }

//    @Override
//    public String toString() {
//        return "Controller{" +
//                "providers=" + Arrays.toString(providers) +
//                '}';
//    }

//    public void scan() {
//        List<Vacancy> vacancies = new ArrayList<>();
//        for (Provider provider : providers) {
//            vacancies.addAll(provider.getJavaVacancies("MyTown"));
//        }
//        System.out.println(vacancies.size());
//    }
}