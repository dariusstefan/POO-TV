package entities;

import input.UserInput;

import java.util.ArrayList;

public final class User {
    private static final int FREE_PREMIUM_MOVIES = 15;
    private static final int PREMIUM_ACCOUNT_PRICE = 10;
    private static final int MAX_RATING = 5;
    private static final int MIN_RATING = 0;

    private static final int MOVIE_PRICE = 2;
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;
    private ArrayList<Notification> notifications;

    public User(final UserInput userInput) {
        this.credentials = new Credentials(userInput.getCredentials());
        this.tokensCount = 0;
        this.numFreePremiumMovies = User.FREE_PREMIUM_MOVIES;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public User(final User user) {
        this.credentials = user.credentials.pojoCopy();
        this.tokensCount = user.tokensCount;
        this.numFreePremiumMovies = user.numFreePremiumMovies;
        this.watchedMovies = copyMoviesArray(user.watchedMovies);
        this.purchasedMovies = copyMoviesArray(user.purchasedMovies);
        this.likedMovies = copyMoviesArray(user.likedMovies);
        this.ratedMovies = copyMoviesArray(user.ratedMovies);
        this.notifications = copyNotificationsArray(user.notifications);
    }

    public User(final Credentials credentials) {
        this.credentials = new Credentials(credentials);
        this.tokensCount = 0;
        this.numFreePremiumMovies = User.FREE_PREMIUM_MOVIES;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    /**This method returns a deep-copied object of this class.
     * It is used for JSON method putPOJO.**/
    public User pojoCopy() {
        return new User(this);
    }

    private ArrayList<Movie> copyMoviesArray(final ArrayList<Movie> movies) {
        ArrayList<Movie> copy = new ArrayList<>();
        for (Movie movie : movies) {
            copy.add(movie.pojoCopy());
        }
        return copy;
    }

    private ArrayList<Notification> copyNotificationsArray(final ArrayList<Notification> notifs) {
        ArrayList<Notification> copy = new ArrayList<>();
        for (Notification notification : notifs) {
            copy.add(notification.copyNotification());
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

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**This method increases number of tokens for a user.**/
    public void incTokens(final int amount) {
        this.tokensCount += amount;
    }

    /**This method decreases number of tokens for a user.**/
    public void decTokens(final int amount) {
        this.tokensCount -= amount;
    }

    /**This method implements the operation of buying tokens for a user.**/
    public int buyTokens(final int amount) {
        int balance = Integer.parseInt(this.credentials.getBalance());
        if (balance >= amount) {
            this.credentials.decBalance(amount);
            this.incTokens(amount);
            return 0;
        } else {
            return -1;
        }
    }

    /**This method consumes a free movie for a user.**/
    public void decNumFreePremiumMovies() {
        this.numFreePremiumMovies--;
    }

    /**This method implements operation of upgrading the account for a user.**/
    public int upgradeAccount() {
        if (!this.credentials.getAccountType().equals("standard")) {
            return -1;
        }
        if (this.tokensCount < User.PREMIUM_ACCOUNT_PRICE) {
            return -1;
        }
        this.decTokens(User.PREMIUM_ACCOUNT_PRICE);
        this.credentials.upgradeAccount();
        return 0;
    }

    /**This method implements operation of purchasing a movie for a user.**/
    public int purchaseMovie(final Movie movie) {
        if (this.purchasedMovies.contains(movie)) {
            return -1;
        }
        if (this.credentials.getAccountType().equals("premium")) {
            if (this.numFreePremiumMovies > 0) {
                decNumFreePremiumMovies();
                this.purchasedMovies.add(movie);
                return 0;
            }
        }
        if (this.getTokensCount() < User.MOVIE_PRICE) {
            return -1;
        }
        this.purchasedMovies.add(movie);
        this.decTokens(User.MOVIE_PRICE);
        return 0;
    }

    /**This method implements operation of watching a movie for a user.**/
    public int watchMovie(final Movie movie) {
        if (this.watchedMovies.contains(movie)) {
            return -1;
        }
        if (!this.purchasedMovies.contains(movie)) {
            return -1;
        }
        this.watchedMovies.add(movie);
        return 0;
    }

    /**This method implements operation of liking a movie for a user.**/
    public int likeMovie(final Movie movie) {
        if (this.likedMovies.contains(movie)) {
            return -1;
        }
        if (!this.watchedMovies.contains(movie)) {
            return -1;
        }
        this.likedMovies.add(movie);
        movie.incNumLikes();
        return 0;
    }

    /**This method implements operation of rating a movie for a user.**/
    public int rateMovie(final Movie movie, final int rating) {
        if (this.ratedMovies.contains(movie)) {
            return -1;
        }
        if (!this.watchedMovies.contains(movie)) {
            return -1;
        }
        if (rating < User.MIN_RATING || rating > User.MAX_RATING) {
            return -1;
        }
        this.ratedMovies.add(movie);
        movie.addRating(rating);
        return 0;
    }
}
