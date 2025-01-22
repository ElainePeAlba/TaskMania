package es.fempa.TaskMania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    private String description;
    
    private long usuario_id;
    
    public Project() {}

	public Project(long id, @NotBlank(message = "El nombre es obligatorio") String name, String description,
			long usuario_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.usuario_id = usuario_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}
    
    
    
}
