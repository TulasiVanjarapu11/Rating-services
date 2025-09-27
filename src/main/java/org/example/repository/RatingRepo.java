package org.example.repository;

import org.example.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Long> {

     Rating findByName(String name);

    // List<Rating> findAllAvgRatingBetween(double min, double max);

}
