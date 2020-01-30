package com.akarelov.concurrency;

public class Application {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        HelloRunnable helloRunnable = new HelloRunnable();
        new Thread(helloRunnable).start();
        helloRunnable.run();
    }
}
