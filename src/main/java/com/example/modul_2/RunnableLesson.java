package com.example.modul_2;

public class RunnableLesson {

    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] Starting...");
        MyCarTask task = new MyCarTask();
        Thread t0 = new Thread(task);
        t0.start();
        Thread t1 = new Thread(task);
        t1.start();
        Thread t2 = new Thread(task);
        t2.start();
        System.out.println(Thread.currentThread().getName() + " = Done");
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("[" + Thread.currentThread().getName() + "] I am running in a Runnable");
        }
    }

    static abstract class Car {
        public String drive() {
            return "brum... brum";
        }
    }

    static class MyCarTask extends Car implements Runnable {
        int counter = 0;

        @Override
        public void run() {
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + "] " + super.drive() + " - rally: " + counter);
        }
    }

    static class MyDrivingCarThread extends Thread {
        int counter = 0;
        @Override
        public void run() {
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + "] I am running in a MyTaskThread - rally: " + counter);
        }
    }
}
