package com.akarelov.concurrency.Lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private AtomicLong count = new AtomicLong(0);
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        Impl impl = new Impl();
        Thread thread1 = new Thread(impl);
        Thread thread2 = new Thread(impl);
        Thread thread3 = new Thread(impl);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void incr() {
        writeLock.lock();
        try {
            count.incrementAndGet();
        } finally {
            writeLock.unlock();
        }
    }

    public long getCount() {
        readLock.lock();
        long tmp = count.get();
        try {

        } finally {
            readLock.unlock();
        }
        return tmp;
    }

    private static class Impl implements Runnable {
        ReentrantReadWriteLockExample instance = new ReentrantReadWriteLockExample();

        @Override
        public void run() {
            Thread thread = new Thread(
                    () -> {
                        while (true) {
                            instance.incr();
                            System.out.println(Thread.currentThread().getName() + " " + instance.getCount());
                        }

                    });
            Thread thread2 = new Thread(
                    () -> {
                        while (true) {
                            while (true) {
                                System.out.println(Thread.currentThread().getName() + " " + instance.getCount());
                            }
                        }
                    });
            thread.start();
            thread2.start();
        }
    }
}
