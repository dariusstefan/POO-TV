package strategies;

import entities.Movie;
import entities.POOTVCore;

import java.util.Comparator;

public final class DurationSort implements FilterStrategy {
    private final String order;

    public DurationSort(final String order) {
        this.order = order;
    }

    @Override
    public void filter() {
        if (order == null) {
            return;
        }
        if (order.equals("decreasing")) {
            POOTVCore.getInstance().getCurrentMovies()
                    .sort((o1, o2) -> o2.getDuration() - o1.getDuration());
        } else {
            POOTVCore.getInstance().getCurrentMovies()
                    .sort(Comparator.comparingInt(Movie::getDuration));
        }
    }
}
