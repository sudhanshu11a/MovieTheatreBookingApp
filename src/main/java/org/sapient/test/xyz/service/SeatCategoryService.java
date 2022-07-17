package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.SeatCategory;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 18-07-2022
 */
public interface SeatCategoryService {

    List<SeatCategory> getAllSeatCategory() throws Exception;

    SeatCategory getSeatCategory(String name) throws Exception;

    SeatCategory saveSeatCategory(SeatCategory seatCategory) throws Exception;

    SeatCategory updateSeatCategory(String seatCategoryId, SeatCategory seatCategory) throws Exception;

    boolean deleteSeatCategory(String seatCategoryId) throws Exception;
}
