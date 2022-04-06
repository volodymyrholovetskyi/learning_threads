package com.example.modul_2;

public class JoinLesson {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread() + " = Starting...");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " = I am running in a thread...");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e){
                    throw new IllegalStateException(e);
                }
            }
        };

        Thread t0 = new Thread(task);
        t0.start();
        t0.join(5_000);// program po 5-czu minutach zatrzyma sie i wykona wątek main
        //swoja operacje a dalej znowu zaczne działać wotek t0

        System.out.println(Thread.currentThread().getName() + " = Done");
    }
}
