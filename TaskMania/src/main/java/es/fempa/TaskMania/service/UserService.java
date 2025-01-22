package es.fempa.TaskMania.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.fempa.TaskMania.model.Usuario;
import es.fempa.TaskMania.repository.UserRepository;

@Service
public class UserService {
	  private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public List<Usuario> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public Usuario saveUser(Usuario usuario) {
	        return userRepository.save(usuario);
	    }
	    
	 // Método para eliminar múltiples tareas
	    public void deleteUser(List<Long> ids) {
	    	userRepository.deleteAllById(ids);   
	    }
	    
	    public void editUser() {}
}
