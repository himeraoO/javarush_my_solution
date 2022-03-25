package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {

    public static class Product {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity);
        }

//    public static void main(String[] args) {
//        Product product = new Product(19847, "Шорты пляжные синие","159.00","12");
//        System.out.println(product);
//    }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            ArrayList<Product> arrayList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            bufferedReader.close();

            FileReader reader = new FileReader(s);
            Scanner scanner = new Scanner(reader);
            String str = "";

            while (scanner.hasNext()) {
                str = scanner.nextLine();
                Product product = getProduct(str);
                arrayList.add(product);
            }
            scanner.close();
            reader.close();

           if (args[0].equals("-c")) {
                int i = 0;
                for (Product product : arrayList) {
                    if (i < product.id) {
                        i = product.id;
                    }
                }

             FileWriter writer = new FileWriter(s);
             Product productNew = new Product(i + 1, args[1], args[2], args[3]);
             arrayList.add(productNew);

                for (Product p: arrayList) {
                    writer.write(p.toString());
                    writer.write("\n");
                }
                writer.close();

            } else if (args[0].equals("-u")) {

                for (Product p: arrayList) {
                    if (p.id == Integer.parseInt(args[1])){
                        p.productName = args[2];
                        p.price = args[3];
                        p.quantity = args[4];
                    }
                }
                FileWriter writer = new FileWriter(s);

                for (Product p: arrayList) {
                    writer.write(p.toString());
                    writer.write("\n");
                }
                writer.close();

            }
            else if (args[0].equals("-d")) {
                Product productDelete = null;
                for (Product p: arrayList) {
                    if (p.id == Integer.parseInt(args[1])){
                        productDelete = p;

                    }
                }
                arrayList.remove(productDelete);
                FileWriter writer = new FileWriter(s);

                for (Product p: arrayList) {
                    writer.write(p.toString());
                    writer.write("\n");
                }
                writer.close();
            }
        }
    }
}