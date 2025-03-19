package me.fit.model;

import java.util.List;
import java.util.Objects;

public class MuscleGroup {
    private Long id;
    private String name;
    private List<Muscle> muscles;

    public MuscleGroup() {}

    public MuscleGroup( String name) {
        this.name = name;
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

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MuscleGroup that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(muscles, that.muscles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, muscles);
    }

    @Override
    public String toString() {
        return "MuscleGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscles=" + muscles +
                '}';
    }
}
