package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.*;
import org.sapient.test.xyz.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author Sudhanshu Sharma
 * on 17-07-2022
 */
@Service
public class InitialLoadDataImpl implements InitialLoadData, ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitialLoadDataImpl.class);

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private SeatCategoryService seatCategoryService;

    @Autowired
    private ShowService showService;

    @Autowired
    private BookingService bookingService;

    /**
     *
     */
    @Override
    public void loadData() throws Exception {
        createTheatres();
        createMovies();
        List<Show> showList = createShows();
        createBookings(showList);
    }

    private void createBookings(List<Show> showList) throws Exception {
        //Create Bookings
        for (Show show : showList) {
            SeatCategory seatCategory = seatCategoryService.getSeatCategory(show.getSeatCategoryId());
            Optional<List<Seat>> optionalSeatList = seatCategory.bookSeats(5);
            BookTicket bookTicket = new BookTicket();
        }
    }

    private List<Show> createShows() throws Exception {
        //Create Shows
        List<SeatCategory> seatCategoryList = seatCategoryService.getAllSeatCategory();
        List<Movie> movieList = movieService.getAllMovies();
        List<Show> showList = new ArrayList<>(seatCategoryList.size()*movieList.size());
        for (int i = 0; i < seatCategoryList.size(); i++) {
            for (int j = 0; j < movieList.size(); j++) {
                Show show = new Show(seatCategoryList.get(i).getTheatreId(), j, movieList.get(j).getId(), ZonedDateTime.now(), ZonedDateTime.now().plusHours(3), seatCategoryList.get(i).getId());
                showList.add(showService.saveShow(show));
            }
        }
        return showList;
    }

    private void createMovies() throws Exception {

        //Create Movies
        Movie movie1 = new Movie("Khuda Haafiz", "Sameer, a young man, leads a content life with Nargis, his wife. However, when she is kidnapped by human traffickers, he must rescue her before it is too late.", Date.from(LocalDate.of(2020, Month.AUGUST, 14).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        Movie movie2 = new Movie("Shabaash Mithu", "Shabaash Mithu is a 2022 Indian Hindi-language biographical sports drama film directed by Srijit Mukherji and produced by Viacom18 Studios. The film based on the life of former Test and ODI captain of the India women's national cricket team, Mithali Raj, stars Taapsee Pannu in titular role.", Date.from(LocalDate.of(2022, Month.JULY, 15).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        Movie movie3 = new Movie("Rocketry: The Nambi Effect", "Rocketry: The Nambi Effect is a 2022 Indian biographical drama film based on the life of Nambi Narayanan, a former scientist and aerospace engineer of the Indian Space Research Organisation, who was accused in the ISRO espionage case and later exonerated.", Date.from(LocalDate.of(2022, Month.JULY, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        Movie movie4 = new Movie("Thor: Love and Thunder", "Thor embarks on a journey unlike anything he's ever faced -- a quest for inner peace. However, his retirement gets interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods.", Date.from(LocalDate.of(2022, Month.JULY, 7).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        movieService.saveMovie(movie1);
        movieService.saveMovie(movie2);
        movieService.saveMovie(movie3);
        movieService.saveMovie(movie4);

    }

    /**
     * Create Theatres
     *
     * @throws Exception
     */
    private void createTheatres() throws Exception {
        Address address1 = new Address("New Delhi", "J22H+8V Delhi");
        Address address2 = new Address("Gurgaon", "F3GV+66 Gurugram, Haryana");
        Address address3 = new Address("Pune", "GVGH+Q3 Pune, Maharashtra");
        Address address4 = new Address("Bengaluru", "WJR9+FJ Bengaluru, Karnataka");

        Theatre theatre1 = new Theatre("PVR Vegas Kotak IMAX Dwarka", "Dolby Cinemas", 5, "xyz1@xyz.com", address1);
        Theatre theatre2 = new Theatre("PVR Cinemas Pvt Ltd", "IMAX", 3, "xyz2@xyz.com", address2);
        Theatre theatre3 = new Theatre("INOX", "RealD 3D", 4, "xyz3@xyz.com", address3);
        Theatre theatre4 = new Theatre("PVR Cinemas - Koramangala", "Regal RPX", 6, "xyz4@xyz.com", address4);

        List<Theatre> theatreList = new ArrayList<>(4);
        theatreList.add(theatreService.saveTheatre(theatre1));
        theatreList.add(theatreService.saveTheatre(theatre2));
        theatreList.add(theatreService.saveTheatre(theatre3));
        theatreList.add(theatreService.saveTheatre(theatre4));


        // Category
        for (Theatre theatre : theatreList) {
            SeatCategory seatCategory1 = new SeatCategory(theatre.getId(), "PLANETARIUM SEATING", new BigDecimal(1000), 10);
            SeatCategory seatCategory2 = new SeatCategory(theatre.getId(), "VIP CINEMA SEATING", new BigDecimal(2000), 20);
            SeatCategory seatCategory3 = new SeatCategory(theatre.getId(), "FULL ROCKER", new BigDecimal(1500), 30);
            SeatCategory seatCategory4 = new SeatCategory(theatre.getId(), "PREMIUM GLIDER", new BigDecimal(100), 40);
            seatCategoryService.saveSeatCategory(seatCategory1);
            seatCategoryService.saveSeatCategory(seatCategory2);
            seatCategoryService.saveSeatCategory(seatCategory3);
            seatCategoryService.saveSeatCategory(seatCategory4);
        }

    }

    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Application initial Data Loading Started");
        try {
            loadData();
            LOGGER.info("Application initial Data Loaded Successfully");
        } catch (Exception e) {
            LOGGER.error("Loading Initial data failed due to exception : " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
