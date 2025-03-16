package me.fit.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "muscle")
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "muscle_group_id", nullable = false)
    private MuscleGroup muscleGroup;

    @OneToMany(mappedBy = "muscle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseMuscle> exerciseMuscles;

    public Muscle() {
    }

    public Muscle(String name, MuscleGroup muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
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

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public List<ExerciseMuscle> getExerciseMuscles() {
        return exerciseMuscles;
    }

    public void setExerciseMuscles(List<ExerciseMuscle> exerciseMuscles) {
        this.exerciseMuscles = exerciseMuscles;
    }

    @Override
    public String toString() {
        return "Muscle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleGroup=" + muscleGroup +
                ", exerciseMuscles=" + exerciseMuscles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Muscle muscle)) return false;
        return Objects.equals(id, muscle.id) && Objects.equals(name, muscle.name) && Objects.equals(muscleGroup, muscle.muscleGroup) && Objects.equals(exerciseMuscles, muscle.exerciseMuscles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, muscleGroup, exerciseMuscles);
    }
}


