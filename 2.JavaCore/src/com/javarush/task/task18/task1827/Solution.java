package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {

            if (args[0].equals("-c")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferedReader.readLine();
                bufferedReader.close();
                FileReader reader = new FileReader(s);
                Scanner scanner = new Scanner(reader);
                String str = "";
                int i = 0;
                while (scanner.hasNext()) {
                    str = scanner.nextLine();
                    int j = Integer.parseInt(str.substring(0, 8).trim());
                    if (i < j) {
                        i = j;
                    }
                }
                scanner.close();
                reader.close();
                FileWriter writer = new FileWriter(s, true);
            /*
                -c productName price quantity
                Значения параметров:
                где id - 8 символов.
                productName - название товара, 30 символов.
                price - цена, 8 символов.
                quantity - количество, 4 символа.
                -c - добавляет товар с заданными параметрами в конец файла,
                генерирует id самостоятельно,
                инкрементируя максимальный id, найденный в файле.
                id productName price quantity
                8      30        8      4
            */
                StringBuilder sb = new StringBuilder();
                sb.append("\n");
                int id = i + 1;
                String idString = Integer.toString(id);
                sb.append(idString);
                if (idString.length() < 8) {
                    int l = 8 - idString.length();
                    for (int j = 0; j < l; j++) {
                        sb.append(" ");
                    }
                }
                String productName = args[1];
                sb.append(productName);
                if (productName.length() > 30) {
                    sb.setLength(38);
                } else if (productName.length() < 30) {
                    int l = 30 - productName.length();
                    for (int j = 0; j < l; j++) {
                        sb.append(" ");
                    }
                }
                String price = args[2];
                sb.append(price);
                if (price.length() < 8) {
                    int l = 8 - price.length();
                    for (int j = 0; j < l; j++) {
                        sb.append(" ");
                    }
                }
                String quantity = args[3];
                sb.append(quantity);
                if (quantity.length() < 4) {
                    int l = 4 - quantity.length();
                    for (int j = 0; j < l; j++) {
                        sb.append(" ");
                    }
                }
                writer.write(sb.toString());
                writer.close();
            }
        }
    }
}