package me.fit.model;

import jakarta.persistence.*;

@Entity
public class ExerciseMuscle {
    @EmbeddedId
    private ExerciseMuscleId id;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @MapsId("muscleId")
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    public ExerciseMuscle() {
    }

    public ExerciseMuscle(Exercise exercise, Muscle muscle) {
        this.exercise = exercise;
        this.muscle = muscle;
        this.id = new ExerciseMuscleId(exercise.getId(), muscle.getId());
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
        this.muscle = muscle;
    }
}
