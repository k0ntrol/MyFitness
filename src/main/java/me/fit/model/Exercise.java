package me.fit.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = { @JoinColumn(name = "exercise_id")},
            inverseJoinColumns = {@JoinColumn(name = "muscle_id")}
    )
    private Set<Muscle> muscles;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "workout_exercise",
            joinColumns = { @JoinColumn(name = "exercise_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")}

    )
    private Set<Workout> workouts;

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

    public Set<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(Set<Muscle> muscles) {
        this.muscles = muscles;
    }

    public Set<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Exercise exercise)) return false;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(muscles, exercise.muscles) && Objects.equals(workouts, exercise.workouts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, muscles, workouts);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", muscles=" + muscles +
                ", workouts=" + workouts +
                '}';
    }
}



