package com.akarelov.concurrency;


public class VolatileDisassemblerExample {

    private Object object;
    private volatile int value = 0;

    public void test() {
        value = 3;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "|th1");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "|th2");
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "|th3");
            }
        });
        thread2.start();
        thread2.join();
        thread.start();
        thread3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread());
        }

//        if (Thread.currentThread().isInterrupted()) return;
//        VolatileDisassemblerExample example =
//                new VolatileDisassemblerExample();
//        for (int i = 0; i < 100000; i++) {
//            example.test();
//            System.out.println(example.value);
//        }
    }
}
