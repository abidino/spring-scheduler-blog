package dev.abidino.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Service
public class SchedulerService {

    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> tasksMap = new ConcurrentHashMap<>();

    public SchedulerService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void addTask(TaskDefinition taskDefinition) {
        taskDefinition.initialize();
        MyJob myJob = new MyJob(taskDefinition.getId());
        CronTrigger cronTrigger = new CronTrigger(taskDefinition.getCronExpression());
        ScheduledFuture<?> schedule = taskScheduler.schedule(myJob, cronTrigger);
        tasksMap.put(taskDefinition.getId(), schedule);
    }

    public void cancelTask(String taskId) {
        ScheduledFuture<?> scheduledFuture = tasksMap.get(taskId);
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
        }
    }

    public void updateTask(String taskId, TaskDefinition taskDefinition) {
        ScheduledFuture<?> scheduledFuture = tasksMap.get(taskId);
        if (Objects.nonNull(scheduledFuture)) {
            scheduledFuture.cancel(true);
            addTask(taskDefinition);
            return;
        }
        throw new IllegalArgumentException("Task not found with this id : " + taskId);
    }
}
