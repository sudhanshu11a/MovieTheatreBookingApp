package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.Show;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public interface ShowService {

    List<Show> getAllShow() throws Exception;

    Show getShow(String name) throws Exception;

    Show saveShow(Show show) throws Exception;

    Show updateShow(String showId, Show show) throws Exception;

    boolean deleteShow(String showId) throws Exception;
}
