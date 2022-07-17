package org.sapient.test.xyz.repository;

import org.sapient.test.xyz.entity.SeatCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 18-07-2022
 */
@Repository
public interface SeatCategoryRepository extends JpaRepository<SeatCategory, UUID> {
}
