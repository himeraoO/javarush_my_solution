package com.javarush.task.task32.task3206;


import java.lang.reflect.Proxy;


/* 
Дженерики для создания прокси-объекта
*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public <T extends Item> T getProxy(Class<T> type, Class<?>...classes){

        ClassLoader classLoader = this.getClass().getClassLoader();
//        Class<?>[] interfaces = type.getClass().getInterfaces();
//        Class<?>[] newInterface = new Class[interfaces.length + classes.length];
//        int j = 0;
//        for (int i = 0; i < interfaces.length; i++) {
//            newInterface[i] = interfaces[i];
//            j = i;
//        }
//        for (int i = j + 1,  n = 0; i < newInterface.length; i++, n ++) {
//            newInterface[i] = classes[n];
//        }
//        ArrayList<Class<?>> arrayList = new ArrayList<>();
//        arrayList.addAll(Arrays.asList((Class<?>) classes), Arrays.asList(interfaces));
//        Collections.addAll(Collections.singleton(arrayList), classes, Arrays.asList(newInterface));

//        Class<?>[] newInterface = new Class[classes.length + 1];
//        for (int i = 0; i < newInterface.length; i++) {
//            newInterface[i] = classes[i];
//            if (i == newInterface.length - 1){
//                newInterface[i] = type;
//            }
//        }
//        return type.cast(Proxy.newProxyInstance(classLoader, classes, new ItemInvocationHandler()));

        Class<?>[] newInterface = new Class[classes.length + 1];
        System.arraycopy(classes, 0, newInterface, 0, classes.length);
        newInterface[newInterface.length - 1] = type;

        return (T) Proxy.newProxyInstance(classLoader, newInterface, new ItemInvocationHandler());
   }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
