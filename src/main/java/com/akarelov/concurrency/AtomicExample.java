package com.akarelov.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicExample implements Runnable {
    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicExample atomicExample = new AtomicExample();
        Thread thread = new Thread(atomicExample);
        Thread thread2 = new Thread(atomicExample);
        Thread thread3 = new Thread(atomicExample);
        Thread thread4 = new Thread(atomicExample);
        Thread thread5 = new Thread(atomicExample);
        Thread thread6 = new Thread(atomicExample);
        Thread thread7 = new Thread(atomicExample);

        thread.start();
        thread.join();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        System.out.println(AtomicExample.count.get());
    }

    @Override
    public void run() {
        while (count.get() < 100_000_000) {
            count.incrementAndGet();
        }

    }

    public AtomicLong getCount() {
        return count;
    }
}