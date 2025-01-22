package es.fempa.TaskMania.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Tag {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    
    public Tag() {}


	public Tag(long id, @NotBlank(message = "El nombre es obligatorio") String name) {
		super();
		this.id = id;
		this.name = name;
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
    
   
}
