package me.fit.model.client;

import jakarta.persistence.*;
import me.fit.model.Exercise;
import me.fit.model.Muscle;

import java.util.Objects;

@Entity
public class Exercise_Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (cascade = CascadeType.ALL)
    Exercise exercise;

    @ManyToOne(cascade = CascadeType.ALL)
    Muscle muscle;

    public Exercise_Muscle() {
        super();
    }

    public Exercise_Muscle(Exercise exercise, Muscle muscle) {
        this.exercise = exercise;
        this.muscle = muscle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (!(o instanceof Exercise_Muscle that)) return false;
        return id == that.id && Objects.equals(exercise, that.exercise) && Objects.equals(muscle, that.muscle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercise, muscle);
    }

    @Override
    public String toString() {
        return "Exercise_Muscle{" +
                "id=" + id +
                ", exercise=" + exercise +
                ", muscle=" + muscle +
                '}';
    }
}
