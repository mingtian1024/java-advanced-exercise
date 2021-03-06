package com.sky.week04thread;

import com.sky.util.MathUtil;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + " fibo(" + 10 + ")=" + MathUtil.fibo(10) + " 使用时间：" + (System.currentTimeMillis() - start) + " ms");
            }
        });
        t1.start();
        System.out.println("等待子线程执行完毕...");
        Thread.sleep(1000);
        System.out.println("继续执行主线程");
    }
}
