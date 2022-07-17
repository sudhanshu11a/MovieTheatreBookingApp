package org.sapient.test.xyz.repository;

import org.sapient.test.xyz.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    Movie findByName(String name);
}
