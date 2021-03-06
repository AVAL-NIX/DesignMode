package com.boot.test;

public class AccountingSync2 implements Runnable {
    //共享资源(临界资源)
    static int i = 0;
    AccountingSync instance = new AccountingSync();
    /**
     * synchronized 修饰实例方法
     */
    public  void increase() {
        synchronized (this){
            i++;
        }
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountingSync2 instance = new AccountingSync2();
        //new新实例
//        Thread t1=new Thread(new AccountingSync2());
        Thread t1=new Thread(instance);
        //new新实例
//        Thread t2=new Thread(new AccountingSync2());
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 2000000
     */
}
