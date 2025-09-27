package org.example.service;

import org.example.exception.NotFoundException;
import org.example.model.Rating;
import org.example.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    RatingRepo ratingRepo;

    public Rating updateAverage(String name, double stars){
        Rating rating= ratingRepo.findByName(name);

        if(rating==null){
            rating= new Rating();
            rating.setName(name);
            rating.setAvgRating(stars);
            rating.setCount(1);
           //throw new NotFoundException("Movie not found with name: "+ name);
        }
        else {
            int count = rating.getCount();
            double newAverage = (rating.getAvgRating() * ratingRepo.count() + stars) / (count + 1);

            rating.setAvgRating(newAverage);
            rating.setCount(++count);
        }
        return ratingRepo.save(rating);

    }

    public Rating fetchRating(String name){
        Rating rating= ratingRepo.findByName(name);

        if(rating==null){
            throw new NotFoundException("movie not found with name" +name);
        }
        return ratingRepo.findByName(name);
    }
}
