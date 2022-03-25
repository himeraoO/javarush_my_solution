package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Helper {
    public static String generateRandomString(){
//        SecureRandom secureRandom = new SecureRandom();
//        BigInteger ss =  new BigInteger(130, secureRandom);
//        return generateString(new SecureRandom(new BigInteger()), );
        return new BigInteger(130, new SecureRandom()).toString(36);
    }
//
//    public static String generateString(Random rng, String characters, int length){
//        char[] text = new char[length];
//        for (int i = 0; i < length; i++){
//            text[i] = characters.charAt(rng.nextInt(characters.length()));
//        }
//        return new String(text);
//    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}

