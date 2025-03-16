package me.fit.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int duration;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercises;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserProgress> userProgressList;

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

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }

    public List<UserProgress> getUserProgressList() {
        return userProgressList;
    }

    public void setUserProgressList(List<UserProgress> userProgressList) {
        this.userProgressList = userProgressList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Workout workout)) return false;
        return duration == workout.duration && Objects.equals(id, workout.id) && Objects.equals(name, workout.name) && Objects.equals(workoutExercises, workout.workoutExercises) && Objects.equals(userProgressList, workout.userProgressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, workoutExercises, userProgressList);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", workoutExercises=" + workoutExercises +
                ", userProgressList=" + userProgressList +
                '}';
    }
}

