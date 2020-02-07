package com.akarelov.concurrency.practice;

public class P7 {
    public static void main(String[] args) {
        Player ping = new Player("ping");
        Player pong = new Player("pong");
        ping.setAnotherPlayer(pong);
        ping.setFlag(true);
        pong.setAnotherPlayer(ping);

        Thread thread = new Thread(ping);
        Thread thread2 = new Thread(pong);
        thread.start();
        thread2.start();
    }

    static class Player implements Runnable {
        private final String msg;
        private boolean flag = false;
        private Player anotherPlayer;

        Player(String msg) {
            this.msg = msg;
        }

        void setAnotherPlayer(Player player) {
            this.anotherPlayer = player;
        }
        void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public synchronized void run() {
            while (true) {
                try {
                    if (flag) {
                        System.out.println(msg);
                        flag = !flag;
                        anotherPlayer.flag = !anotherPlayer.flag;
                        Thread.currentThread().sleep(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
