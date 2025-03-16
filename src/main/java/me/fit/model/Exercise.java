package me.fit.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseMuscle> exerciseMuscles;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercises;

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

    public List<ExerciseMuscle> getExerciseMuscles() {
        return exerciseMuscles;
    }

    public void setExerciseMuscles(List<ExerciseMuscle> exerciseMuscles) {
        this.exerciseMuscles = exerciseMuscles;
    }

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exerciseMuscles=" + exerciseMuscles +
                ", workoutExercises=" + workoutExercises +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Exercise exercise)) return false;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(exerciseMuscles, exercise.exerciseMuscles) && Objects.equals(workoutExercises, exercise.workoutExercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, exerciseMuscles, workoutExercises);
    }
}

