package org.sapient.test.xyz.controller;

import org.sapient.test.xyz.entity.Theatre;
import org.sapient.test.xyz.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@RestController
@RequestMapping("/api/v1/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Theatre> saveTheatre(@RequestBody Theatre theatre) throws Exception {
        return ResponseEntity.ok().body(theatreService.saveTheatre(theatre));
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PutMapping(value = "/{theatreId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String theatreId, @RequestBody Theatre theatre) throws Exception {
        return ResponseEntity.ok().body(theatreService.updateTheatre(theatreId, theatre));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Theatre>> getAllTheatre() throws Exception {
        return ResponseEntity.ok().body(theatreService.getAllTheatre());
    }

    @GetMapping(value = "/{theatreId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Theatre> getTheatre(@PathVariable String theatreId) throws Exception {
        return ResponseEntity.ok().body(theatreService.getTheatre(theatreId));
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @DeleteMapping(value = "/{theatreId}")
    public ResponseEntity<Boolean> deleteTheatre(@PathVariable String theatreId) throws Exception {
        return ResponseEntity.ok().body(theatreService.deleteTheatre(theatreId));
    }
}
