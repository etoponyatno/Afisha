package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int limitOfPosters = 3;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }


    public void add(AfishaItem item) {
        repository.save(item);
    }

    public AfishaItem[] getAll() {
        AfishaItem[] items = repository.findAll();
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
