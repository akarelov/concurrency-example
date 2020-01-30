package com.akarelov.concurrency;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello from HelloRunnable object!!! " + Thread.currentThread());

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
