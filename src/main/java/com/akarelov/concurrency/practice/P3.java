package com.akarelov.concurrency.practice;

public class P3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("started main thread");

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();

        System.out.println("Finished main thread");
    }

    static class Thread1 extends Thread {
        @Override
        public synchronized void run() {
            try {
                Thread1.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("start " + Thread.currentThread());
        }
    }

    static class Thread2 extends Thread {
        @Override
        public synchronized void run() {
            System.out.println("start " + Thread.currentThread());
        }
    }

    static class Thread3 extends Thread {
        @Override
        public synchronized void run() {
            System.out.println("start " + Thread.currentThread());
        }
    }
}
