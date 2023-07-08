package io.github.mfaisalkhatri.tests;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ThreadLocalExample implements Runnable {

    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    @Override
    public void run() {
        final long startTime = System.currentTimeMillis();
        this.threadLocal.set((int) (Math.random() * 40D));
        try {
            Thread.sleep(2000);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.threadLocal.get());
        final long endTime = System.currentTimeMillis();
        final NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
    }

    public static void main(final String[] args) {
        final ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        final Thread t1 = new Thread(threadLocalExample);
        final Thread t2 = new Thread(threadLocalExample);

        //start time and end time needs to be printed in he console
        t1.start();

        t2.start();

    }

}
