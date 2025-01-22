package es.fempa.TaskMania.controller;
import jakarta.validation.Valid;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.fempa.TaskMania.model.Status;
import es.fempa.TaskMania.model.Task;
import es.fempa.TaskMania.service.TaskService;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/add-task")
    public String showAddEventForm(Model model) {
    	 model.addAttribute("task", new Task());
    	    model.addAttribute("statuses", Arrays.asList(Status.values()));
    	    return "add-task";
    }

    @PostMapping("/add-task")
    public String addTask(@Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-task";
        }
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/delete-multiple")
    public String deleteMultipleTasks(@RequestParam(required = false) List<Long> ids, RedirectAttributes redirectAttributes) {
        if (ids == null || ids.isEmpty()) {
            // Mensaje de error si no se seleccionaron tareas
            redirectAttributes.addFlashAttribute("error", "Por favor selecciona al menos una tarea para eliminar.");
            return "redirect:/tasks";
        }
        taskService.deleteTasks(ids);
        redirectAttributes.addFlashAttribute("success", "Tareas eliminadas correctamente.");
        return "redirect:/tasks";
    }


}
