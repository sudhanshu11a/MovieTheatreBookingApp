package org.sapient.test.xyz.repository;

import org.sapient.test.xyz.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, UUID> {

    Theatre findByName(String name);
}
