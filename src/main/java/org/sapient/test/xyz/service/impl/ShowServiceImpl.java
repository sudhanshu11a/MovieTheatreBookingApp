package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.Show;
import org.sapient.test.xyz.repository.ShowRepository;
import org.sapient.test.xyz.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;
    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Show> getAllShow() throws Exception {
        return showRepository.findAll();
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Show getShow(String id) throws Exception {
        return showRepository.getById(UUID.fromString(id));
    }

    /**
     * @param show
     * @return
     * @throws Exception
     */
    @Override
    public Show saveShow(Show show) throws Exception {
        return showRepository.save(show);
    }

    /**
     * @param showId
     * @param show
     * @return
     * @throws Exception
     */
    @Override
    public Show updateShow(String showId, Show show) throws Exception {
        Show showEntity = showRepository.getById(UUID.fromString(showId));
        if (showEntity != null) {
            showEntity.setTheatreId(show.getTheatreId());
            showEntity.setMovieId(show.getMovieId());
            showEntity.setScreenNumber(show.getScreenNumber());
            showEntity.setSeatCategoryId(show.getSeatCategoryId());
            showEntity.setShowStartTime(show.getShowStartTime());
            showEntity.setShowEndTime(show.getShowEndTime());
        }
        return showRepository.save(showEntity);
    }

    /**
     * @param showId
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteShow(String showId) throws Exception {
        Show showEntity = showRepository.getById(UUID.fromString(showId));
        if (showEntity != null) {
            showRepository.delete(showEntity);
            return true;
        }
        return false;
    }
}
