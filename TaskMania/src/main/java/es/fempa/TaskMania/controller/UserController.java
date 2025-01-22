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

import es.fempa.TaskMania.model.Usuario;
import es.fempa.TaskMania.service.UserService;
import jakarta.validation.Valid;

@Controller
public class UserController {

	 private final UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	  

	    @GetMapping("/users")
	    public String listUser(Model model) {
	        model.addAttribute("users", userService.getAllUsers());
	        return "users";
	    }

	    @GetMapping("/add-user")
	    public String showAddUserForm(Model model) {
	    	 model.addAttribute("usuario", new Usuario());
	    	    return "add-user";
	    }

	    @PostMapping("/add-user")
	    public String addUser(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-user";
	        }
	        userService.saveUser(usuario);
	        return "redirect:/users";
	    }

	    @PostMapping("/users/delete-multiple")
	    public String deleteMultipleUser(@RequestParam(required = false) List<Long> ids, RedirectAttributes redirectAttributes) {
	        if (ids == null || ids.isEmpty()) {
	            // Mensaje de error si no se seleccionaron tareas
	            redirectAttributes.addFlashAttribute("error", "Por favor selecciona al menos un usuario para eliminar.");
	            return "redirect:/users";
	        }
	        userService.deleteUser(ids);
	        redirectAttributes.addFlashAttribute("success", "Usuario eliminadas correctamente.");
	        return "redirect:/users";
	    }

}
