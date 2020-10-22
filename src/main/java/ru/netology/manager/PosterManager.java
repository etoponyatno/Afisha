package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];
    private int limitOfPosters = 10;

    public PosterManager() {
    }

    public PosterManager(int limitOfPosters) {
        this.limitOfPosters = limitOfPosters;
    }


    public void add(PosterItem item) {
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] getAll() {
        int resultLength = items.length;
        if (resultLength >= limitOfPosters) resultLength = limitOfPosters;
        PosterItem[] result = new PosterItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
