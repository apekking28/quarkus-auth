package com.king.repository;

import com.king.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NamedQuery;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
