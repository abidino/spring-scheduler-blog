package dev.abidino.scheduler;

public class TaskDefinition {
    private String cronExpression;
    private String name;

    public String getCronExpression() {
        return cronExpression;
    }

    public String getName() {
        return name;
    }
}
