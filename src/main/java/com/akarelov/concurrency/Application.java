package com.akarelov.concurrency;

public class Application {
    public static void main(String[] args) {
        HelloRunnable helloRunnable = new HelloRunnable();
        helloRunnable.run();
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId());
    }
}
