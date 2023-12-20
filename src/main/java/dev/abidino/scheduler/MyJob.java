package dev.abidino.scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyJob implements Runnable {

    private final String name;

    public MyJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " ==> " + name + " running");
    }

}
