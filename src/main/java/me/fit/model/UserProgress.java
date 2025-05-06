package me.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_progress")
@NamedQueries({
        @NamedQuery(name = UserProgress.GET_PROGRESS_FOR_USER, query = "Select up from UserProgress up where up.user.id = :userId")
})
public class UserProgress {

    public static final String GET_PROGRESS_FOR_USER = "UserProgress.getProgressForUser";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double userWeight;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int reps;
    private int sets;
    private double weight;
    @ManyToOne
    private User user;
    @ManyToOne
    private Exercise exercise;

    public UserProgress() {
    }

    public UserProgress(double userWeight, Date date, int reps, int sets, double weight, User user,Exercise exercise) {
        this.userWeight = userWeight;
        this.date = date;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.user = user;

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

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        long temp;
        temp = Double.doubleToLongBits(userWeight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + reps;
        result = prime * result + sets;
        temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserProgress other = (UserProgress) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Double.doubleToLongBits(userWeight) != Double.doubleToLongBits(other.userWeight))
            return false;
        if (reps != other.reps)
            return false;
        if (sets != other.sets)
            return false;
        if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProgress [id=" + id + ", userWeight=" + userWeight + ", date=" + date +
                ", reps=" + reps + ", sets=" + sets + ", weight=" + weight + "]";
    }
}

