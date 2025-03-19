package me.fit.model;

import java.util.List;
import java.util.Objects;

public class Exercise {
    private Long id;
    private String name;
    private String description;
    private List<Muscle> muscles;
    private List<Workout> exercises;

    public Exercise() {
    }

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    public List<Workout> getExercises() {
        return exercises;
    }

    public void setExercises(List<Workout> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Exercise exercise)) return false;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(muscles, exercise.muscles) && Objects.equals(exercises, exercise.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, muscles, exercises);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", muscles=" + muscles +
                ", exercises=" + exercises +
                '}';
    }
}



