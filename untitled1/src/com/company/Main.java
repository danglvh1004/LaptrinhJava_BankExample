package com.company;

import java.util.Scanner;

public class Main {

    static final int ACCOUNTS = 3;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 500;

    public static void main(String[] args) {

        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);

        while (true) {
            int fromAccount = (int) (ACCOUNTS * Math.random());
            int toAccount = (int) (ACCOUNTS * Math.random());
            double amount = MAX_AMOUNT * Math.random();
            bank.transfer(fromAccount, toAccount, amount);
        }
    }
}
