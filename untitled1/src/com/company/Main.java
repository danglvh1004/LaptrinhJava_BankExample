package com.company;

import java.util.Scanner;

public class Main {

    static final int ACCOUNTS = 3;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 500;

    public static void main(String[] args) {

        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int fromAccount = (int) (ACCOUNTS * Math.random());
                    int toAccount = (int) (ACCOUNTS * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(fromAccount, toAccount, amount);
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        Thread t2 = new Thread(runnable);
        t2.start();

        int x = new Scanner(System.in).nextInt();
    }
}
