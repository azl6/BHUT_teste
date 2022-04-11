package com.azold.bhut_app.repositories;

import com.azold.bhut_app.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}
