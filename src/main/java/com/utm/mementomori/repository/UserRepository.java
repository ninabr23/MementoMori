package com.utm.mementomori.repository;

import org.springframework.data.repository.CrudRepository;

import com.utm.mementomori.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}