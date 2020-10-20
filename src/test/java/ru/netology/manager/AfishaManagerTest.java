package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    private AfishaManager afishaManager = new AfishaManager();
    AfishaItem first = new AfishaItem(1, 1, "first", "genre");
    AfishaItem second = new AfishaItem(2, 2, "second", "genre");
    AfishaItem third = new AfishaItem(3, 3, "third", "genre");
    AfishaItem fourth = new AfishaItem(4, 4, "fourth", "genre");



    @Test
    void GetAllLessLimit() {
        afishaManager.add(first);
        afishaManager.add(second);
        AfishaItem[] actual = afishaManager.getAll();
        AfishaItem[] expected = new AfishaItem[]{second, first};

        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllEqualsLimit() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);

        AfishaItem[] actual = afishaManager.getAll();
        AfishaItem[] expected = new AfishaItem[]{third, second, first};
        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllOverLimit() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
        afishaManager.add(fourth);

        AfishaItem[] actual = afishaManager.getAll();
        AfishaItem[] expected = new AfishaItem[]{fourth, third, second};
        assertArrayEquals(actual, expected);
    }

}
