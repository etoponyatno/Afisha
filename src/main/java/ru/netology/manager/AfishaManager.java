package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
public class AfishaManager {
    private int limitOfPosters = 3;
    private AfishaRepository repository;


    public AfishaManager(int limitOfPosters, AfishaRepository repository) {
        this.limitOfPosters = limitOfPosters;
        this.repository = repository;
    }



    public void add(AfishaItem item) {
        repository.save(item);
    }

    public AfishaItem[] getAll() {
        AfishaItem[] items = repository.findAll();
        int resultLength = items.length;
        if (resultLength >= limitOfPosters) resultLength = limitOfPosters;
        AfishaItem[] result = new AfishaItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
}
}
