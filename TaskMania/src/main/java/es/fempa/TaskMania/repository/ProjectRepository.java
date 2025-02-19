package es.fempa.TaskMania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fempa.TaskMania.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
