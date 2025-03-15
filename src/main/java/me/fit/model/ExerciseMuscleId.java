package me.fit.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExerciseMuscleId implements Serializable {
    private Long exerciseId;
    private Long muscleId;

    public ExerciseMuscleId() {
    }

    public ExerciseMuscleId(Long exerciseId, Long muscleId) {
        this.exerciseId = exerciseId;
        this.muscleId = muscleId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Long muscleId) {
        this.muscleId = muscleId;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseMuscleId that = (ExerciseMuscleId) o;
        return Objects.equals(exerciseId, that.exerciseId) &&
                Objects.equals(muscleId, that.muscleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, muscleId);
    }
}
