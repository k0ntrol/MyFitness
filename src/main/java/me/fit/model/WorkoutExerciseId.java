package me.fit.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WorkoutExerciseId implements Serializable {
    private Long workoutId;
    private Long exerciseId;


    public WorkoutExerciseId() {
    }

    public WorkoutExerciseId(Long workoutId, Long exerciseId) {
        this.workoutId = workoutId;
        this.exerciseId = exerciseId;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutExerciseId that = (WorkoutExerciseId) o;
        return Objects.equals(workoutId, that.workoutId) &&
                Objects.equals(exerciseId, that.exerciseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, exerciseId);
    }
}


