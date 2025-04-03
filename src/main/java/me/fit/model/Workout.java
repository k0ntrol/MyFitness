package me.fit.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "workouts")
    private Set<Exercise> exercises;

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

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
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

