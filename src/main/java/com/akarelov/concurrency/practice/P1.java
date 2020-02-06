package com.akarelov.concurrency.practice;

public class P1 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("is interrupted : " + thread.isInterrupted());
        System.out.println("is alive : " + thread.isAlive());
        System.out.println("is daemon : "  + thread.isDaemon());
        System.out.println("name is " + thread.getName());
        System.out.println( "id is " + thread.getId());
        System.out.println("context : " + thread.getContextClassLoader());
        System.out.println( "priority : " + thread.getPriority());
        System.out.println(thread.getStackTrace());
        System.out.println("state : " + thread.getState());
        System.out.println("thread group : " + thread.getThreadGroup());
    }
}
