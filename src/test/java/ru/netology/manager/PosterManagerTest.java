package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    private PosterManager posterManager = new PosterManager();
    PosterItem first = new PosterItem(1, 1, "first", "genre");
    PosterItem second = new PosterItem(2, 2, "second", "genre");
    PosterItem third = new PosterItem(3, 3, "third", "genre");
    PosterItem fourth = new PosterItem(4, 4, "fourth", "genre");
    PosterItem fifth = new PosterItem(5, 5, "fifth", "genre");
    PosterItem sixth = new PosterItem(6, 6, "sixth", "genre");
    PosterItem seventh = new PosterItem(7, 7, "seventh", "genre");
    PosterItem eighth = new PosterItem(8, 8, "eighth", "genre");
    PosterItem ninth = new PosterItem(9, 9, "ninth", "genre");
    PosterItem tenth = new PosterItem(10, 10, "tenth", "genre");
    PosterItem eleventh = new PosterItem(11, 11, "eleventh", "genre");


    @Test
    void GetAllLessLimit() {
        posterManager.add(first);
        posterManager.add(second);
        posterManager.add(third);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{third, second, first};

        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllEqualsLimit() {
        posterManager.add(first);
        posterManager.add(second);
        posterManager.add(third);
        posterManager.add(fourth);
        posterManager.add(fifth);
        posterManager.add(sixth);
        posterManager.add(seventh);
        posterManager.add(eighth);
        posterManager.add(ninth);
        posterManager.add(tenth);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllOverLimit() {
        posterManager.add(first);
        posterManager.add(second);
        posterManager.add(third);
        posterManager.add(fourth);
        posterManager.add(fifth);
        posterManager.add(sixth);
        posterManager.add(seventh);
        posterManager.add(eighth);
        posterManager.add(ninth);
        posterManager.add(tenth);
        posterManager.add(eleventh);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }

}
