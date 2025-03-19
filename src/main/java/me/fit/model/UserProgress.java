package me.fit.model;

import java.util.Date;
import java.util.Objects;

public class UserProgress {
    private Long id;
    private double userWeight;
    private Date date;
    private int reps;
    private int sets;
    private double weight;
    private User user;
    private Workout workout;
    private Exercise exercise;

    public UserProgress() {
    }

    public UserProgress(double userWeight, Date date, int reps, int sets, double weight, User user, Workout workout, Exercise exercise) {
        this.userWeight = userWeight;
        this.date = date;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.user = user;
        this.workout = workout;
        this.exercise = exercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserProgress that)) return false;
        return Double.compare(userWeight, that.userWeight) == 0 && reps == that.reps && sets == that.sets && Double.compare(weight, that.weight) == 0 && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(user, that.user) && Objects.equals(workout, that.workout) && Objects.equals(exercise, that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userWeight, date, reps, sets, weight, user, workout, exercise);
    }

    @Override
    public String toString() {
        return "UserProgress{" +
                "id=" + id +
                ", userWeight=" + userWeight +
                ", date=" + date +
                ", reps=" + reps +
                ", sets=" + sets +
                ", weight=" + weight +
                ", user=" + user +
                ", workout=" + workout +
                ", exercise=" + exercise +
                '}';
    }
}

