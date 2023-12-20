package dev.abidino.scheduler;

import java.util.UUID;

public class TaskDefinition {
    private String id;
    private final String cronExpression;
    private final String name;

    public TaskDefinition(String cronExpression, String name) {
        this.cronExpression = cronExpression;
        this.name = name;
    }

    public void initialize() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public String getName() {
        return name;
    }
}
