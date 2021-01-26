package com.company;

import java.util.Arrays;
import java.util.concurrent.locks.*;

public class Bank {

    public double[] accounts;

    Bank(int n, double initMoney) {
        accounts = new double[n];
        Arrays.fill(accounts, initMoney);
    }

    public synchronized void transfer(int from, int to, double amount) {
        System.out.print(Thread.currentThread().getName());
        while (accounts[from] < amount) {
            System.out.printf(" Not enough: %.2f \n", amount);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        accounts[from] -= amount;
        System.out.printf(" %10.2f form %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f\n", getTotalBank()); //10 khoảng trắng và 2 số đằng sau
        notifyAll();
    }

    public double getTotalBank() {
        double sum = 0;
        for (double a : accounts) {
            sum = sum + a;
        }
        return sum;
    }
}
