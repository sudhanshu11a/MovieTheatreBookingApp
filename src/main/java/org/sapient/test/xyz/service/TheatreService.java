package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.Theatre;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public interface TheatreService {
    List<Theatre> getAllTheatre() throws Exception;

    Theatre getTheatre(String name) throws Exception;

    Theatre saveTheatre(Theatre theatre) throws Exception;

    Theatre updateTheatre(String theatreId, Theatre theatre) throws Exception;

    boolean deleteTheatre(String theatreId) throws Exception;
}
