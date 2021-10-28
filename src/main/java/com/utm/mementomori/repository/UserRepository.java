package com.utm.mementomori.repository;

import org.springframework.data.repository.CrudRepository;

import com.utm.mementomori.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}