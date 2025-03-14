package model;

public class ExerciseMuscle {
    private Exercise exercise;
    private Muscle muscle;

    public ExerciseMuscle() {}

    public ExerciseMuscle(Exercise exercise, Muscle muscle) {
        this.exercise = exercise;
        this.muscle = muscle;
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
