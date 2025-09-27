package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Rating;
import org.example.model.RatingRequest;
import org.example.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ratings")
@Slf4j
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{name}")
    public ResponseEntity<Rating> getRating(@PathVariable String name){
        Rating rating=ratingService.fetchRating(name);
        log.info("Returing rating for movie:{}", name);
        return ResponseEntity.ok(rating);

    }
    @PostMapping
    public ResponseEntity<Rating> updateRating(@RequestBody RatingRequest request) {
        Rating rating = ratingService.updateAverage(request.getName(), request.getStars());
        log.info("return new average for movie: {}", request.getName());
        return ResponseEntity.ok(rating);
    }
}
