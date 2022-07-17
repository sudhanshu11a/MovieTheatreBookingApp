package org.sapient.test.xyz.controller;

import org.sapient.test.xyz.entity.Show;
import org.sapient.test.xyz.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@RestController
@RequestMapping("/api/v1/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Show> saveShow(@RequestBody Show show) throws Exception {
        return ResponseEntity.ok().body(showService.saveShow(show));
    }

    @PutMapping(value = "/{theatreId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Show> updateShow(@PathVariable String showId, @RequestBody Show show) throws Exception {
        return ResponseEntity.ok().body(showService.updateShow(showId, show));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Show>> getAllShow() throws Exception {
        return ResponseEntity.ok().body(showService.getAllShow());
    }

    @GetMapping(value = "/{theatreId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Show> getShow(@PathVariable String showId) throws Exception {
        return ResponseEntity.ok().body(showService.getShow(showId));
    }

    @DeleteMapping(value = "/{showId}")
    public ResponseEntity<Boolean> deleteShow(@PathVariable String showId) throws Exception {
        return ResponseEntity.ok().body(showService.deleteShow(showId));
    }
}
