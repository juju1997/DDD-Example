package com.example.ddd.infrastructure;

import com.example.ddd.domain.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RootRepository extends JpaRepository<Root, Long> {

    Optional<Root> findByToken(String rootToken);
}
