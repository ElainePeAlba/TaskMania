package es.fempa.TaskMania.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "La categoría es obligatoria")
    private String category;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private Status status;

    private String dueDate; // Opcional

    public Task() {}

    public Task(long id, String name, String category, Status status, String dueDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.dueDate = dueDate;
    }

    // Getters y Setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
