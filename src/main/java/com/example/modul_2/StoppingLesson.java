package com.example.modul_2;

public class StoppingLesson {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting...");
        Telemetric telemetric = new Telemetric();

        Thread t0 = new Thread(telemetric);
        t0.start();
        Thread.sleep(5_000);
        System.out.println("Done");
        telemetric.stopTask();
        t0.join();
        System.out.println("Thread t0 state is: " + t0.getState());
    }

    static class Telemetric implements Runnable {
        private volatile boolean isRunning = false;

        @Override
        public void run() {
            System.out.println("Before start");
            isRunning = true;
            System.out.println("About to start...");
            while (isRunning) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    System.out.println("Free memory is: " + (runtime.freeMemory()) / 1024 + " KB ...");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        public void stopTask(){
            isRunning = false;
        }
    }
}
