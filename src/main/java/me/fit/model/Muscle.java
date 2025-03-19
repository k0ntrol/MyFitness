package me.fit.model;

import java.util.List;
import java.util.Objects;

public class Muscle {
    private Long id;
    private String name;
    private MuscleGroup muscleGroup;
    private List<Exercise> exercises;

    public Muscle() {
    }

    public Muscle(String name, MuscleGroup muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
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

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Muscle muscle)) return false;
        return Objects.equals(id, muscle.id) && Objects.equals(name, muscle.name) && Objects.equals(muscleGroup, muscle.muscleGroup) && Objects.equals(exercises, muscle.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, muscleGroup, exercises);
    }

    @Override
    public String toString() {
        return "Muscle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleGroup=" + muscleGroup +
                ", exercises=" + exercises +
                '}';
    }
}


