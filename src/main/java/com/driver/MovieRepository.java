package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private Map<String, Movie> movieDB;
    private Map<String, Director> directorDB;
    private Map<String, List<String>> movieDirectorDB;

    public MovieRepository() {// initializing the HashMaps
        this.movieDB = new HashMap<String, Movie>();
        this.directorDB = new HashMap<String, Director>();
        this.movieDirectorDB= new HashMap<String, List<String>>();
    }

    // Add a movie
    public String addMovie(Movie movie){
        if(movieDB.containsKey(movie.getName())){
            return null;
        }
        movieDB.put(movie.getName(),movie);//adding (name-movie object) as key-value pair
        return "A new Movie has been added successfully";
    }


    // Add a director
    public String addDirector(Director director){
        if(directorDB.containsKey(director.getName())){
            return null;
        }
        directorDB.put(director.getName(),director);//adding (name-director object) as key-value pair
        return "A new Director has been added successfully";
    }


    // Pair an existing movie and director
    public String addMovieDirectorPair(String movieName, String directorName){
        if(!movieDirectorDB.containsKey(directorName))
            movieDirectorDB.put(directorName, new ArrayList<String>());

        movieDirectorDB.get(directorName).add(movieName);
        return "New movie-director pair added successfully";
    }


    // Get Movie by movie name
    public Movie getMovie(String name){
        return movieDB.get(name);
    }


    // Get Director by director name
    public Director getDirector(String name){
        return directorDB.get(name);
    }


    // Get List of movies name for a given director name
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> moviesList = new ArrayList<>();
        if(movieDirectorDB.containsKey(directorName)) {
            moviesList = movieDirectorDB.get(directorName);
        }
        return moviesList;
    }


    // Get List of all movies added
    public List<String> findAllMovies(){
        return new ArrayList<>(movieDB.keySet());// storing all the movie names in an ArrayList
    }


    // Delete a director and its movies from the records
    public String deleteDirectorByName(String directorName){
        List<String> moviesList = movieDirectorDB.get(directorName);

        for(String movie: moviesList){// iterating over ArrayList -> moviesList
             movieDB.remove(movie);
        }

        movieDirectorDB.remove(directorName);
        return "director an its movies has been successfully deleted";
    }

    // Delete all directors and all movies by them from the records
    public String deleteAllDirectors(){
        HashSet<String> movieSet = new HashSet<>();// ArrayList could also have been taken

        for(String director: movieDirectorDB.keySet()){// iterating over HashMap
            movieSet.addAll(movieDirectorDB.get(director));
        }

        for(String movie: movieSet) {// iterating over HashSet
            movieDB.remove(movie);
        }

        return "All directors and all movies by them have been successfully deleted";
    }
}
