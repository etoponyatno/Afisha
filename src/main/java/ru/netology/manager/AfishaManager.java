package ru.netology.manager;

import ru.netology.domain.AfishaItem;

public class AfishaManager {
    private AfishaItem[] items = new AfishaItem[0];
    private int limitOfPosters = 3;


    public void add(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem[] getAll() {
        AfishaItem[] result = new AfishaItem[items.length];
        AfishaItem[] limitOfPosters = new AfishaItem[this.limitOfPosters];
        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        if (items.length >= this.limitOfPosters) {
            for (int i = 0; i < this.limitOfPosters; i++) {
                limitOfPosters[i] = result[i];
            }
            return limitOfPosters;
        } else {
            return result;
        }
    }
}
