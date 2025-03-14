package me.fit.model;


import jakarta.persistence.*;

import java.lang.annotation.Inherited;

@Entity
@Table(name = "workout_exercise")
public class WorkoutExercise {
    @EmbeddedId
    private WorkoutExerciseId id;

    @ManyToOne
    @MapsId("workoutId")
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;


    public WorkoutExercise() {
    }

    public WorkoutExercise(Workout workout, Exercise exercise) {
        this.workout = workout;
        this.exercise = exercise;
        this.id = new WorkoutExerciseId(workout.getId(), exercise.getId());
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
