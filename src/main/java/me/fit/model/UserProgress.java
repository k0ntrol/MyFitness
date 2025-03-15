package me.fit.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double userWeight;
    private Date date;
    private int reps;
    private int sets;
    private double weight;
    @ManyToOne
    private User user;
    @ManyToOne
    private Workout workout;
    @ManyToOne
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
}

