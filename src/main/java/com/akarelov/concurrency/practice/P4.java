package com.akarelov.concurrency.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P4 {
    private static int SIZE = 10_000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread thread = new Thread(new A(list));
        Thread thread2 = new Thread(new B(list));
        thread.start();
        thread2.start();
    }

    static class A implements Runnable {
        private final List<Integer> list;
        private Random random = new Random();
        private int count = 0;

        A(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (count < SIZE) {
                synchronized (list) {
                    count++;
                    list.add(random.nextInt(100000));
                    System.out.println(list.size());

                }
            }
        }
    }

    static class B implements Runnable {
        private final List<Integer> list;
        private Random random = new Random();
        private int count = 0;

        B(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (count < SIZE) {
                synchronized (list) {
                    if (!list.isEmpty()) {
                        count++;
                        list.remove(random.nextInt(list.size()));
                        System.out.println(list.size());
                    }
                }
            }
        }
    }
}
