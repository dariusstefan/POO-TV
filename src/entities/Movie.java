package entities;

import input.MovieInput;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;

public final class Movie {
    private final String name;
    private final String year;
    private final int duration;
    private final ArrayList<String> genres;
    private final ArrayList<String> actors;
    private final ArrayList<String> countriesBanned;
    private double avgRating;
    private int numLikes;
    private int numRatings;

    @JsonIgnore
    private HashMap<User, Integer> ratings;

    public Movie(final MovieInput movieInput) {
        this.name = movieInput.getName();
        this.year = movieInput.getYear();
        this.duration = movieInput.getDuration();
        this.genres = movieInput.getGenres();
        this.actors = movieInput.getActors();
        this.countriesBanned = movieInput.getCountriesBanned();
        this.ratings = new HashMap<>();
        this.avgRating = 0;
        this.numLikes = 0;
        this.numRatings = 0;
    }

    public Movie(final Movie movie) {
        this.name = movie.getName();
        this.year = movie.getYear();
        this.duration = movie.getDuration();
        this.genres = movie.getGenres();
        this.actors = movie.getActors();
        this.countriesBanned = movie.getCountriesBanned();
        this.ratings = movie.getRatings();
        this.avgRating = movie.avgRating;
        this.numLikes = movie.numLikes;
        this.numRatings = movie.numRatings;
    }

    /**This method returns a deep-copied object of this class.
     * It is used for JSON method putPOJO.**/
    public Movie pojoCopy() {
        return new Movie(this);
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public double getRating() {
        return avgRating;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public HashMap<User, Integer> getRatings() {
        return ratings;
    }

    /**This method adds a rating to a movie. It also recalculates the average rating.**/
    public void addRating(final User user, final Integer rating) {
        this.ratings.put(user, rating);
        incNumRatings();
        recalculateRating();
    }

    /**This method changes a rating.**/
    public void changeRating(final User user, final Integer newRating) {
        this.ratings.replace(user, newRating);
        recalculateRating();
    }

    /**This method increases number of likes for a movie.**/
    public void incNumLikes() {
        this.numLikes++;
    }

    /**This method increases number of ratings for a movie.**/
    public void incNumRatings() {
        this.numRatings++;
    }

    /**This method recalculates average rating for a movie.**/
    public void recalculateRating() {
        double sum = 0;
        for (Integer i : this.ratings.values()) {
            sum += i;
        }
        this.avgRating = sum / numRatings;
    }
}
