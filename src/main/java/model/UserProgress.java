package model;

import java.util.Date;

public class UserProgress {
    private int id;
    private double userWeight;
    private Date date;
    private int reps;
    private int sets;
    private double weight;
    private User user;
    private Workout workout;
    private Exercise exercise;

    public UserProgress() {}

    public UserProgress(int id, double userWeight, Date date, int reps, int sets, double weight, User user, Workout workout, Exercise exercise) {
        this.id = id;
        this.userWeight = userWeight;
        this.date = date;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.user = user;
        this.workout = workout;
        this.exercise = exercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

