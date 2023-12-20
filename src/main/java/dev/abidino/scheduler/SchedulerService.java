package dev.abidino.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    private final TaskScheduler taskScheduler;

    public SchedulerService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void addTask(TaskDefinition taskDefinition) {
        MyJob myJob = new MyJob(taskDefinition.getName());
        CronTrigger cronTrigger = new CronTrigger(taskDefinition.getCronExpression());
        taskScheduler.schedule(myJob, cronTrigger);
    }
}
