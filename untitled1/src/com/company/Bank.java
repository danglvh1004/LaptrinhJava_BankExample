package com.company;

import java.util.Arrays;

public class Bank {

    public double[] accounts;

    Bank(int n, double initMoney) {
        accounts = new double[n];
        Arrays.fill(accounts, initMoney);
    }

    public void transfer(int from, int to, double amount) {
        System.out.print(Thread.currentThread().getName());
        accounts[from] -= amount;
        System.out.printf(" %10.2f form %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f\n", getTotalBank()); //10 khoảng trắng và 2 số đằng sau
    }

    public double getTotalBank() {
        double sum = 0;
        for (double a : accounts) {
            sum = sum + a;
        }
        return sum;
    }
}
