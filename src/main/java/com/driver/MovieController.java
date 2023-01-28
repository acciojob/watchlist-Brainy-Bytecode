package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
      String response=movieService.addMovie(movie);
      if(response==null)
          return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String response=movieService.addDirector(director);
        if(response==null)
            return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
        String response= movieService.getMovieByDirector(movieName, directorName);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }


    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<List<String>> getDirectorByName(@PathVariable String name){
        List<String> movies = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }


    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies= movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }


    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> movies= movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
        String response = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirector(){
        String response = movieService.deleteAllDirectors();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
