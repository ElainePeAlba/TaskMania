package es.fempa.TaskMania.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.fempa.TaskMania.model.Project;
import es.fempa.TaskMania.service.ProjectService;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	 private final ProjectService projectService;

	    public ProjectController(ProjectService projectService) {
	        this.projectService = projectService;
	    }


	    @GetMapping("/projects")
	    public String listProject(Model model) {
	        model.addAttribute("projects", projectService.getAllProject());
	        return "projects";
	    }

	    @GetMapping("/add-project")
	    public String showAddProjectForm(Model model) {
	    	 model.addAttribute("project", new Project());
	    	   return "add-project";
	    }

	    @PostMapping("/add-project")
	    public String addProject(@Valid @ModelAttribute Project project, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-project";
	        }
	        projectService.saveProject(project);
	        return "redirect:/projects";
	    }

	    @PostMapping("/projects/delete-multiple")
	    public String deleteMultipleProject(@RequestParam(required = false) List<Long> ids, RedirectAttributes redirectAttributes) {
	        if (ids == null || ids.isEmpty()) {
	            // Mensaje de error si no se seleccionaron tareas
	            redirectAttributes.addFlashAttribute("error", "Por favor selecciona al menos un proyecto para eliminar.");
	            return "redirect:/projects";
	        }
	        projectService.deleteProject(ids);
	        redirectAttributes.addFlashAttribute("success", "Proyectos eliminadas correctamente.");
	        return "redirect:/projects";
	    }

}
