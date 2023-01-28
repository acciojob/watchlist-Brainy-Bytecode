package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    // Add a movie
    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }


    // Add a director
    public String addDirector(Director director){
       return movieRepository.addDirector(director);
    }


    // Pair an existing movie and director
    public String getMovieByDirector(String movieName, String directorName){
       return movieRepository.addMovieDirectorPair(movieName, directorName);
    }


    // Get Movie by movie name
    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }


    // Get Director by director name
    public Director getDirector(String name){
       return movieRepository.getDirector(name);
    }


    // Get List of movies name for a given director name
    public List<String> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }


    // Get List of all movies added
    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }


    // Delete a director and its movies from the records
    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    // Delete all directors and all movies by them from the records
    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }

}
