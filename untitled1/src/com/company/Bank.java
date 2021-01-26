package com.company;

import java.util.Arrays;
import java.util.concurrent.locks.*;

public class Bank {

    Lock lock;

    private Condition condition;

    public double[] accounts;

    Bank(int n, double initMoney) {
        accounts = new double[n];
        Arrays.fill(accounts, initMoney);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void transfer(int from, int to, double amount) {
        lock.lock();
        try {
            System.out.print(Thread.currentThread().getName());

            while (accounts[from] < amount) {
                System.out.printf(" Not enough: %.2f \n", amount);
                try {
                    condition.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            accounts[from] -= amount;
            System.out.printf(" %10.2f form %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f\n", getTotalBank()); //10 khoảng trắng và 2 số đằng sau
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public double getTotalBank() {
        double sum = 0;
        for (double a : accounts) {
            sum = sum + a;
        }
        return sum;
    }
}
