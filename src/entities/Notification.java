package entities;

public final class Notification {
    private final String movieName;
    private final String message;

    public Notification(final String movieName, final String message) {
        this.movieName = movieName;
        this.message = message;
    }

    public Notification(final Notification notification) {
        this.movieName = notification.movieName;
        this.message = notification.message;
    }

    public Notification copyNotification() {
        return new Notification(this);
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMessage() {
        return message;
    }
}
