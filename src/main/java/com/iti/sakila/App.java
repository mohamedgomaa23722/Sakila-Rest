package com.iti.sakila;

import java.time.Year;

public class App {
    public static void main(String[] args) {
        System.out.println("**************************----------------------Main is running -------------------------********************");
        int year = Year.now().getValue();
    }
}
