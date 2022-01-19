package demo.feature.admin;

import demo.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqiang
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @GetMapping
    public Task get() {
        return new Task(1L, "任务1");
    }
}
