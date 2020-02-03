package com.akarelov.concurrency;

public class Application {
    public static void main(String[] args) {
        HelloThread thread = new HelloThread();
        HelloThread thread2 = new HelloThread();

        thread.start();
        thread2.start();

    }
}
