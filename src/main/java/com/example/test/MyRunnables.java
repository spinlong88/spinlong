package com.example.test;


/**
 * @author Wgs
 * @version 1.0
 * @create：2017/11/27
 */


 class MyRunnables implements Runnable {

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }

}

