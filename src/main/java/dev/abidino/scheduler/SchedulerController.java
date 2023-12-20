package dev.abidino.scheduler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping
    void addTask(@RequestBody TaskDefinition taskDefinition) {
        schedulerService.addTask(taskDefinition);
    }

    @DeleteMapping("/{id}")
    void cancelTask(@PathVariable String id) {
        schedulerService.cancelTask(id);
    }

    @PutMapping("/{id}")
    void updateTask(@PathVariable String id, @RequestBody TaskDefinition taskDefinition) {
        schedulerService.updateTask(id, taskDefinition);
    }
}
