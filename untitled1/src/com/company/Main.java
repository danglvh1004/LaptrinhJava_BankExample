package com.company;

import java.util.Scanner;

public class Main {

    static final int ACCOUNTS = 3;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 1200;

    public static void main(String[] args) {

        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < ACCOUNTS; i++) {

            int fromAccount = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        int toAccount = (int) (ACCOUNTS * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                    }
                }
            };
            Thread t = new Thread(runnable);
            t.start();
        }

        int x = new Scanner(System.in).nextInt();
    }
}
