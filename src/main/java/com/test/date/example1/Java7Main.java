package com.test.date.example1;


import com.test.date.Print;
import com.test.date.PrintDoc;
import org.joda.time.LocalDate;


@PrintDoc("Example 1 - How to get today's date in Java 7")
public class Java7Main {
    public static void main(String[] args) {
        Print.me(Java7Main.class);

        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);
    }
}
