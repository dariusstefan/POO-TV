package Pages;

import Actions.Action;
import Entities.Logger;
import Entities.iLogger;

import java.util.ArrayList;

public abstract class Page {
    private final ArrayList<Page> reachablePages = new ArrayList<>();

    abstract void completeReachable();

    public abstract void makeAction(Action action);

    public abstract void toLogger(String error, iLogger logger);

    public boolean checkReachable(Page page) {
        return this.reachablePages.contains(page);
    }

    public void addReachable(Page page) {
        this.reachablePages.add(page);
    }
}
