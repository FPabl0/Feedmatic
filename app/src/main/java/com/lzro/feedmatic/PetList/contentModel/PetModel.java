package com.lzro.feedmatic.PetList.contentModel;

/**
 * Created by pablofuentes on 2/6/17.
 */

public class PetModel {
    String name;
    String lastFeed;
    String nextFeed;
    boolean online;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastFeed() {
        return lastFeed;
    }

    public void setLastFeed(String lastFeed) {
        this.lastFeed = lastFeed;
    }

    public String getNextFeed() {
        return nextFeed;
    }

    public void setNextFeed(String nextFeed) {
        this.nextFeed = nextFeed;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
