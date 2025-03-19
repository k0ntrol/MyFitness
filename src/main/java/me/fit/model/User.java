package me.fit.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Date birthDate;
    private List<UserProgress> progressList;

    public User() {}

    public User(String firstName, String lastName, String username, String email, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<UserProgress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<UserProgress> progressList) {
        this.progressList = progressList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate) && Objects.equals(progressList, user.progressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, email, birthDate, progressList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", progressList=" + progressList +
                '}';
    }
}
