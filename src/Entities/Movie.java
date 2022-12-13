package Entities;

import Input.MovieInput;

import java.util.ArrayList;

public class Movie {
    private final String name;
    private final String year;
    private final int duration;
    private final ArrayList<String> genres;
    private final ArrayList<String> actors;
    private final ArrayList<String> countriesBanned;
    private double rating;
    private int numLikes;
    private int numRatings;
    private ArrayList<Integer> ratings;

    public Movie(MovieInput movieInput) {
        this.name = movieInput.getName();
        this.year = movieInput.getYear();
        this.duration = movieInput.getDuration();
        this.genres = movieInput.getGenres();
        this.actors = movieInput.getActors();
        this.countriesBanned = movieInput.getCountriesBanned();
        this.rating = 0;
        this.numLikes = 0;
        this.numRatings = 0;
    }

    public Movie(Movie movie) {
        this.name = movie.getName();
        this.year = movie.getYear();
        this.duration = movie.getDuration();
        this.genres = movie.getGenres();
        this.actors = movie.getActors();
        this.countriesBanned = movie.getCountriesBanned();
        this.rating = movie.rating;
        this.numLikes = movie.numLikes;
        this.numRatings = movie.numRatings;
    }

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
        return rating;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void addRating(Integer rating) {
        this.ratings.add(rating);
        incNumRatings();
        recalculateRating();
    }

    public void incNumLikes() {
        this.numLikes++;
    }

    public void incNumRatings() {
        this.numRatings++;
    }

    public void recalculateRating() {
        double sum = 0;
        for (Integer i : this.ratings) {
            sum += i;
        }
        this.rating = sum / numRatings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "\nname='" + name + '\'' +
                "\nyear='" + year + '\'' +
                "\nduration=" + duration +
                "\ngenres=" + genres +
                "\nactors=" + actors +
                "\ncountriesBanned=" + countriesBanned +
                "\nrating=" + rating +
                "\nnumLikes=" + numLikes +
                "\nnumRatings=" + numRatings +
                "\nratings=" + ratings +
                "\n";
    }
}
