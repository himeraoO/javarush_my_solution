package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods p;

    public CustomInvocationHandler(SomeInterfaceWithMethods p) {
        this.p = p;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (method.getName().equals("stringMethodWithoutArgs"))
//        {
//            System.out.println("stringMethodWithoutArgs in");
//        }
//
//        if (method.getName().equals("voidMethodWithIntArg"))
//        {
//            System.out.println("voidMethodWithIntArg in");
//        }
//
//        Object o = method.invoke(p, args);
//
//
//
//        if (method.getName().equals("stringMethodWithoutArgs"))
//        {
//            System.out.println("stringMethodWithoutArgs out");
//        }
//
//        if (method.getName().equals("voidMethodWithIntArg"))
//        {
//            System.out.println("voidMethodWithIntArg out");
//        }

        System.out.println(method.getName() + " in");
        Object o = method.invoke(p, args);
        System.out.println(method.getName() + " out");

        return o;
    }
}
