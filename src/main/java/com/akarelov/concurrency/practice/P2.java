package com.akarelov.concurrency.practice;

public class P2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("sub thread"));
        thread.start();
        thread.join();
        System.out.println("sub thread is finished: "  + thread.isAlive());
    }
}
