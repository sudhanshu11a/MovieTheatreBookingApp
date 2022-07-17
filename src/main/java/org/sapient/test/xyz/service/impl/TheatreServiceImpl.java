package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.repository.TheatreRepository;
import org.sapient.test.xyz.entity.Theatre;
import org.sapient.test.xyz.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<Theatre> getAllTheatre() throws Exception {
        return theatreRepository.findAll();
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Theatre getTheatre(String name) throws Exception {
        return theatreRepository.findByName(name);
    }

    /**
     * @param theatre
     * @return
     * @throws Exception
     */
    @Override
    public Theatre saveTheatre(Theatre theatre) throws Exception {
        return theatreRepository.save(theatre);
    }

    /**
     * @param theatreId
     * @param theatre
     * @return
     * @throws Exception
     */
    @Override
    public Theatre updateTheatre(String theatreId, Theatre theatre) throws Exception {
        Theatre theatreEntity = theatreRepository.getById(UUID.fromString(theatreId));
        if(theatreEntity!=null){
            theatreEntity.updateTheatre(theatre);
            theatre = theatreRepository.save(theatreEntity);
        }
        return theatre;
    }

    /**
     * @param theatreId
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteTheatre(String theatreId) throws Exception {
        Theatre theatre = theatreRepository.getById(UUID.fromString(theatreId));
        if(theatre!=null){
            theatreRepository.delete(theatre);
            return true;
        }
        return false;
    }
}
