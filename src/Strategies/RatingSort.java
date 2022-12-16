package Strategies;

import Entities.POOTVCore;

public class RatingSort implements FilterStrategy {
    private final String order;

    public RatingSort(String order) {
        this.order = order;
    }

    @Override
    public void filter() {
        if (order == null)
            return;
        if (order.equals("decreasing")) {
            POOTVCore.getInstance().getCurrentMovies().sort((o1, o2) -> {
                if (o2.getRating() - o1.getRating() > 0)
                    return 1;
                if (o2.getRating() - o1.getRating() == 0)
                    return 0;
                return -1;
            });
        } else {
            POOTVCore.getInstance().getCurrentMovies().sort((o1, o2) -> {
                if (o1.getRating() - o2.getRating() > 0)
                    return 1;
                if (o1.getRating() - o2.getRating() == 0)
                    return 0;
                return -1;
            });
        }
    }
}
