package com.chatapp.chatapp.repositories;

import com.chatapp.chatapp.entities.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorityRepository extends CrudRepository<Authority, UUID> {
    public Authority getAuthorityByAuthorityName(String authorityName);
}
