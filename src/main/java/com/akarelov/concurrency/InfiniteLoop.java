package com.akarelov.concurrency;

public class InfiniteLoop implements Runnable {

    private boolean flag = true; // need volatile

    @Override
    public void run() {

        while (flag) {

        }
        System.out.println("finished");

    }

    public static void main(String[] args)
            throws InterruptedException {

        InfiniteLoop loop = new InfiniteLoop();
        Thread t = new Thread(loop);
        t.start();
        Thread.sleep(1000);
        loop.flag = false;
    }
}
