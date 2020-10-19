package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    private PosterManager posterManager = new PosterManager();
    PosterItem first = new PosterItem(1, 1, "first", "genre");
    PosterItem second = new PosterItem(1, 1, "second", "genre");
    PosterItem third = new PosterItem(1, 1, "third", "genre");
    PosterItem fourth = new PosterItem(1, 1, "fourth", "genre");
    PosterItem fifth = new PosterItem(1, 1, "fifth", "genre");
    PosterItem sixth = new PosterItem(1, 1, "sixth", "genre");
    PosterItem seventh = new PosterItem(1, 1, "seventh", "genre");
    PosterItem eighth = new PosterItem(1, 1, "eighth", "genre");
    PosterItem nineth = new PosterItem(1, 1, "nineth", "genre");
    PosterItem tenth = new PosterItem(1, 1, "tenth", "genre");
    PosterItem eleventh = new PosterItem(1, 1, "eleventh", "genre");


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
        posterManager.add(nineth);
        posterManager.add(tenth);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{tenth, nineth, eighth, seventh, sixth, fifth, fourth, third, second, first};
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
        posterManager.add(nineth);
        posterManager.add(tenth);
        posterManager.add(eleventh);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{eleventh, tenth, nineth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }

}