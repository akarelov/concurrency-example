package com.akarelov.concurrency;

import java.util.concurrent.Executor;

public class HelloRunnable implements Runnable {
    private int count;

    public HelloRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        inc();
    }

    synchronized void inc() {
        while (true) {
            ++count;
            System.out.println(Thread.currentThread() + "||count: " + count);
            Thread.currentThread().interrupt();
        }
    }
}

class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}

class DirectExecutor implements Executor {
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}