package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.User;

@Dependent
public class UserService {

    @Inject
    EntityManager em;

    @Transactional
    public User addUser (User user) {
        return em.merge(user);
    }
}
