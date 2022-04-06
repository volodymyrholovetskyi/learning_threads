package com.example.modul_2;

public class TestThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " - Hello word!");

        Thread thread = new Thread("Working thread"){
            @Override
            public void run() {
                super.run();
                System.out.println(Thread.currentThread().getName() + " - I am running in a thread");
            }
        };
        thread.start();
        System.out.println(Thread.currentThread().getName() + " - Done");
    }
}
