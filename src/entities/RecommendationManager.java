package entities;

import java.util.TreeMap;

public class RecommendationManager {
    public static void makeRecommendation() {
        TreeMap<String, Integer> sorted = new TreeMap<>();

        sorted.putAll(POOTVCore.getInstance().getCurrentUser().getGenresLiked());


    }
}
