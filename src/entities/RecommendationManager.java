package entities;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Comparator;
import java.util.List;

public final class RecommendationManager {
    private RecommendationManager() { }

    /**This method is used to search a movie to make a recommendation for a premium user.**/
    public static void makeRecommendation() {
        HashMap<String, Integer> hashMap = POOTVCore.getInstance()
                .getCurrentUser().getGenresLiked();

        ArrayList<Movie> unsortedMovies = POOTVCore.getInstance().getMovies();
        ArrayList<Movie> sortedMovies = new ArrayList<>(unsortedMovies);
        sortedMovies.sort(Comparator.comparingInt(Movie::getNumLikes).reversed());

        boolean foundFlag = false;
        Movie recommendMovie = null;

        List<Map.Entry<String, Integer>> list = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();

        for (Map.Entry<String, Integer> entry : list) {
            for (Movie movie : sortedMovies) {
                if (movie.getGenres().contains(entry.getKey())) {
                    if (!POOTVCore.getInstance().getCurrentUser()
                            .getWatchedMovies().contains(movie)) {
                        foundFlag = true;
                        recommendMovie = movie;
                        break;
                    }
                }
            }
        }

        if (!foundFlag) {
            POOTVCore.getInstance().getCurrentUser().getNotifications()
                    .add(new Notification("No recommendation", "Recommendation"));
        } else {
            POOTVCore.getInstance().getCurrentUser().getNotifications()
                    .add(new Notification(recommendMovie.getName(), "Recommendation"));
        }
        Logger.getInstance().printRecommendation();
    }
}
