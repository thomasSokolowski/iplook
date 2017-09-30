package com.iie.repository;

import com.iie.model.Dump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dev on 8/4/2014.
 */
@Repository
public interface DumpRepository extends JpaRepository<Dump, Long> {
}
