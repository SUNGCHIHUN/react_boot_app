package com.packt.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false) // 엔드포인트 비활성화
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
