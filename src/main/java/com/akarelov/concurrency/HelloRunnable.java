package com.akarelov.concurrency;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello from HelloRunnable object!!!");
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                            }
            count++;
            if (count > 10) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
