package com.test.date;

public class Print {
    private Class myClass;

    public static void me(Class myClass) {
        new Print(myClass);
    }

    private Print(Class myClass) {
        PrintDoc printDoc = (PrintDoc) myClass.getAnnotations()[0];
        System.out.println(printDoc.value());
    }
}
