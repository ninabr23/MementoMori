package com.utm.progress;

import org.springframework.data.repository.CrudRepository;

import com.utm.progress.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}