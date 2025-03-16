package me.fit.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name ="exercise_muscle")
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

    @Override
    public String toString() {
        return "ExerciseMuscle{" +
                "id=" + id +
                ", exercise=" + exercise +
                ", muscle=" + muscle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExerciseMuscle that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(exercise, that.exercise) && Objects.equals(muscle, that.muscle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercise, muscle);
    }
}
