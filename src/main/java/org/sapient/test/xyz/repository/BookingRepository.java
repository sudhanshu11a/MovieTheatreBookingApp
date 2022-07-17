package org.sapient.test.xyz.repository;

import org.sapient.test.xyz.entity.BookTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Repository
public interface BookingRepository extends JpaRepository<BookTicket, UUID> {
    List<BookTicket> findByUserId(String userId);
}
