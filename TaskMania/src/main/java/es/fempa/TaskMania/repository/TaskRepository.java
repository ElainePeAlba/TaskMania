package es.fempa.TaskMania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fempa.TaskMania.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
