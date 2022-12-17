package pages;

import actions.Action;
import entities.ILogger;

import java.util.ArrayList;

public abstract class Page {
    private final ArrayList<Page> reachablePages = new ArrayList<>();

    /**Abstract method that completes the arraylist with reachable pages for a page.**/
    public abstract void completeReachable();

    /**Abstract method that must accept an action.**/
    public abstract void makeAction(Action action);

    /**Abstract method that must use the Logger to print an output.**/
    public abstract void toLogger(ILogger logger);

    /**Abstract method that will do something when a page will be set as current page.**/
    public abstract void auto();

    /**This method checks if a page is reachable from this page.**/
    public final boolean checkReachable(final Page page) {
        return this.reachablePages.contains(page);
    }

    /**This method is used to add a  page to the reachable pages arraylist.
     * It is used when initialize the pages.**/
    public final void addReachable(final Page page) {
        this.reachablePages.add(page);
    }
}
