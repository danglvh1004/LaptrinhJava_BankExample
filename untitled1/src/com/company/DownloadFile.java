package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadFile implements Runnable {
    @Override
    public void run() {
        int time = (int) (5000 * Math.random());
        System.out.println(Thread.currentThread().getName() + "Start Download a new file, need " + time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "Download Completed");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            Runnable downloadFile = new DownloadFile();
            executorService.execute(downloadFile);
        }
    }
}
