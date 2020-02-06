package com.akarelov.concurrency.Lock;

public class DeadLockExample implements Runnable {
    Object object1 = new Object();
    Object object2 = new Object();

    void sout() {
        while (true) {
            synchronized (object1) {
                synchronized (object2) {
                    System.out.println("block from object 1 " + Thread.currentThread());
                }
            }
            synchronized (object2) {
                synchronized (object1) {
                    System.out.println("block from object 2 " + Thread.currentThread());
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
        Thread thread1 = new Thread(deadLockExample);
        Thread thread2 = new Thread(deadLockExample);
        Thread thread3 = new Thread(deadLockExample);
        thread1.start();thread2.start();thread3.start();
    }

    @Override
    public void run() {
        sout();

    }
}
