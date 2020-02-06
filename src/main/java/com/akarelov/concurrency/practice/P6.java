package com.akarelov.concurrency.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class P6 {
    public static void main(String[] args) {
        List<Integer> asynList = new ArrayList<>();
        Random random = new Random();
        List<Integer> list = Collections.synchronizedList(asynList);
        A a = new A(list, random);
        a.run();
    }

    static class A {
        private final List<Integer> list;
        private final int SIZE = 10_000;
        private final Random random;

        A(List<Integer> list, Random random) {
            this.list = list;
            this.random = random;
        }

        public void run() {
            Thread thread = new Thread(() -> {
                int count = 0;
                while (count < SIZE) {
                    add(random.nextInt(SIZE));
                    count++;
                }
            });
            Thread thread2 = new Thread(() -> {
                int count = 0;
                while (count < SIZE) {
                    if (!list.isEmpty()) {
                        remove(random.nextInt(list.size()));
                        count++;
                    }
                }
            });
            thread.start();
            thread2.start();
        }

        void add(int value) {
            list.add(value);
        }

        void remove(int index) {
            list.remove(index);
        }
    }
}
