package es.fempa.TaskMania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fempa.TaskMania.model.Usuario;
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
}