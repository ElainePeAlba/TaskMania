package es.fempa.TaskMania.service;

import org.springframework.stereotype.Service;

import es.fempa.TaskMania.model.Task;
import es.fempa.TaskMania.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    
 // Método para eliminar múltiples tareas
    public void deleteTasks(List<Long> ids) {
        taskRepository.deleteAllById(ids);
        
    }
}

