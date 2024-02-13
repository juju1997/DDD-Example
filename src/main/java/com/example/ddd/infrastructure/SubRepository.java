package com.example.ddd.infrastructure;

import com.example.ddd.domain.Sub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<Sub, Long> {
}
