package com.example.modul_2;

public class PrioritiesLesson {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " = Starting...");
        Thread t0 = new Thread(new Task("Running in a MAX priority"));
        t0.setPriority(Thread.MAX_PRIORITY);
        t0.start();
        Thread t1 = new Thread(new Task("Running in a MIN priority"));
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        System.out.println(Thread.currentThread().getName() + " = Done");
    }

    static class Task implements Runnable {
        private String message;

        public Task(String message){
            this.message = message;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + message);
                    Thread.sleep(1_00);
                }
            } catch (InterruptedException e){
                throw new IllegalStateException(e);
            }
        }
    }
}
