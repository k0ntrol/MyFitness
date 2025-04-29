package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.User;
import me.fit.model.UserProgress;
import me.fit.exception.UserException;
import java.util.HashSet;
import java.util.List;
import java.util.List;
import java.util.Set;

@Dependent
public class UserRepository {

    @Inject
    EntityManager em;

    @Transactional
    public User addUser (User user) {
        return em.merge(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> users = em.createNamedQuery(User.GET_ALL_USERS, User.class)
                .getResultList();

        for (User user : users) {
            List<UserProgress> progressList = em.createNamedQuery(UserProgress.GET_PROGRESS_FOR_USER, UserProgress.class)
                            .setParameter("userId", user.getId()).getResultList();
            user.setProgressList(new HashSet<>(progressList));
        }

        return users;
    }

    public List<User> getAllUsersByName (String name) throws UserException{
        List<User> users = em.createNamedQuery(User.GET_ALL_USERS_BY_NAME, User.class).setParameter("name", name).getResultList();

        if(users.size() == 0) {
            throw new UserException("Ne postoje korisnici");
        }

        return users;
    }
}
