package me.fit.model;


import java.util.List;
import java.util.Objects;

public class Workout {
    private Long id;
    private String name;
    private int duration;
    private List<Exercise> exercises;

    public Workout() {
    }

    public Workout(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Workout workout)) return false;
        return duration == workout.duration && Objects.equals(id, workout.id) && Objects.equals(name, workout.name) && Objects.equals(exercises, workout.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, exercises);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", Exercises=" + exercises +
                '}';
    }
}

