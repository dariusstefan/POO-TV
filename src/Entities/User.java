package Entities;

import Input.CredentialsInput;
import Input.UserInput;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;

    public User(UserInput userInput) {
        this.credentials = new Credentials(userInput.getCredentials());
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
    }

    public User(User user) {
        this.credentials = user.credentials.pojoCopy();
        this.tokensCount = user.tokensCount;
        this.numFreePremiumMovies = user.numFreePremiumMovies;
        this.watchedMovies = copyMoviesArray(user.watchedMovies);
        this.purchasedMovies = copyMoviesArray(user.purchasedMovies);
        this.likedMovies = copyMoviesArray(user.likedMovies);
        this.ratedMovies = copyMoviesArray(user.ratedMovies);
    }

    public User(Credentials credentials) {
        this.credentials = new Credentials(credentials);
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
    }

    public User pojoCopy() {
        return new User(this);
    }

    private ArrayList<Movie> copyMoviesArray(ArrayList<Movie> movies) {
        ArrayList<Movie> copy = new ArrayList<>();
        for (Movie movie : movies) {
            copy.add(movie.pojoCopy());
        }
        return copy;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void incTokens(int amount) {
        this.tokensCount += amount;
    }

    public void decTokens(int amount) {
        this.tokensCount -= amount;
    }

    public int buyTokens(int amount) {
        int balance = Integer.parseInt(this.credentials.getBalance());
        if (balance >= amount) {
            this.credentials.decBalance(amount);
            this.incTokens(amount);
            return 0;
        } else {
            return -1;
        }
    }

    public void setNumFreePremiumMovies() {
        this.numFreePremiumMovies = 15;
    }

    public void decNumFreePremiumMovies() {
        this.numFreePremiumMovies--;
    }

    public int upgradeAccount() {
        if (!this.credentials.getAccountType().equals("standard"))
            return -1;
        if (this.tokensCount < 10)
            return -1;
        this.decTokens(10);
        this.credentials.upgradeAccount();
        return 0;
    }

    public int purchaseMovie(Movie movie) {
        if (this.purchasedMovies.contains(movie))
            return -1;
        if (this.credentials.getAccountType().equals("premium"))
            if (this.numFreePremiumMovies > 0) {
                decNumFreePremiumMovies();
                this.purchasedMovies.add(movie);
                return 0;
            }
        if (this.getTokensCount() < 2)
            return -1;
        this.purchasedMovies.add(movie);
        this.decTokens(2);
        return 0;
    }

    public int watchMovie(Movie movie) {
        if (this.watchedMovies.contains(movie))
            return -1;
        if (!this.purchasedMovies.contains(movie))
            return -1;
        this.watchedMovies.add(movie);
        return 0;
    }

    public int likeMovie(Movie movie) {
        if (this.likedMovies.contains(movie))
            return -1;
        if (!this.watchedMovies.contains(movie))
            return -1;
        this.likedMovies.add(movie);
        movie.incNumLikes();
        return 0;
    }

    public int rateMovie(Movie movie, int rating) {
        if (this.ratedMovies.contains(movie))
            return -1;
        if (!this.watchedMovies.contains(movie))
            return -1;
        if (rating < 0 || rating > 5)
            return -1;
        this.ratedMovies.add(movie);
        movie.addRating(rating);
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "\ncredentials=" + credentials +
                "\ntokensCount=" + tokensCount +
                "\nnumFreePremiumMovies=" + numFreePremiumMovies +
                "\npurchasedMovies=" + purchasedMovies +
                "\nwatchedMovies=" + watchedMovies +
                "\nlikedMovies=" + likedMovies +
                "\nratedMovies=" + ratedMovies +
                "\n}";
    }
}
