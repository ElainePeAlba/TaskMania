package es.fempa.TaskMania.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.fempa.TaskMania.model.Project;
import es.fempa.TaskMania.repository.ProjectRepository;

@Service
public class ProjectService {
	  private final ProjectRepository projectRepository;

	    public ProjectService(ProjectRepository projectRepository) {
	        this.projectRepository = projectRepository;
	    }

	    public List<Project> getAllProject() {
	        return projectRepository.findAll();
	    }

	    public Project saveProject(Project project) {
	        return projectRepository.save(project);
	    }
	    
	 // Método para eliminar múltiples tareas
	    public void deleteProject(List<Long> ids) {
	        projectRepository.deleteAllById(ids);
	        
	    }
}
