package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.SeatCategory;
import org.sapient.test.xyz.repository.SeatCategoryRepository;
import org.sapient.test.xyz.service.SeatCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 18-07-2022
 */
@Service
public class SeatCategoryServiceImpl implements SeatCategoryService {

    @Autowired
    private SeatCategoryRepository seatCategoryRepository;
    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<SeatCategory> getAllSeatCategory() throws Exception {
        return seatCategoryRepository.findAll();
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SeatCategory getSeatCategory(String id) throws Exception {
        return seatCategoryRepository.getById(UUID.fromString(id));
    }

    /**
     * @param seatCategory
     * @return
     * @throws Exception
     */
    @Override
    public SeatCategory saveSeatCategory(SeatCategory seatCategory) throws Exception {
        return seatCategoryRepository.save(seatCategory);
    }

    /**
     * @param seatCategoryId
     * @param seatCategory
     * @return
     * @throws Exception
     */
    @Override
    public SeatCategory updateSeatCategory(String seatCategoryId, SeatCategory seatCategory) throws Exception {
        SeatCategory seatCategoryEntity = seatCategoryRepository.getById(UUID.fromString(seatCategoryId));
        if (seatCategoryEntity != null) {
            seatCategoryEntity.setCategory(seatCategory.getCategory());
            seatCategoryEntity.setTheatreId(seatCategory.getTheatreId());
            seatCategoryEntity.setCost(seatCategory.getCost());
            seatCategoryEntity.setTotalSeats(seatCategory.getTotalSeats());
            seatCategoryEntity.setAvailableSeats(seatCategory.getAvailableSeats());
            seatCategoryEntity.setSeats(seatCategory.getSeats());
        }
        return seatCategoryRepository.save(seatCategoryEntity);
    }

    /**
     * @param seatCategoryId
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteSeatCategory(String seatCategoryId) throws Exception {
        SeatCategory seatCategory = seatCategoryRepository.getById(UUID.fromString(seatCategoryId));
        if (seatCategory != null) {
            seatCategoryRepository.delete(seatCategory);
            return true;
        }
        return false;
    }
}
