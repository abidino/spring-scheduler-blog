package dev.abidino.scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyJob implements Runnable {

    private final String id;

    public MyJob(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " ==> " + id + " running");
    }

}
