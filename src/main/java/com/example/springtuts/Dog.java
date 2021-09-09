package com.example.springtuts;

public class Dog {
    @Timed @Logged
    public void bark() {

        System.out.println("bark!");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}