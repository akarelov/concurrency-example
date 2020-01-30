package com.akarelov.concurrency;

public class HelloThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello from HelloThread object!!! " + Thread.currentThread());

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}