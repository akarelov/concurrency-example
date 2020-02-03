package com.akarelov.concurrency;

public class HelloThread extends Thread {
    private static volatile int count = 0;

    @Override
    public void run() {
        inc();
    }

    synchronized void inc() {
        count++;
        System.out.println(Thread.currentThread() + "||count: " + count);
        run();
    }
}