package com.utm.mementomori.repository;

import com.utm.mementomori.models.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Accounts, Integer> {
}
