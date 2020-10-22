package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerCustomTest {

    private PosterManager posterManager = new PosterManager(5);
    PosterItem first = new PosterItem(1, 1, "first", "genre");
    PosterItem second = new PosterItem(2, 2, "second", "genre");
    PosterItem third = new PosterItem(3, 3, "third", "genre");
    PosterItem fourth = new PosterItem(4, 4, "fourth", "genre");
    PosterItem fifth = new PosterItem(5, 5, "fifth", "genre");
    PosterItem sixth = new PosterItem(6, 6, "sixth", "genre");

    @BeforeEach
    void SetUp(){
        posterManager.add(first);
        posterManager.add(second);
        posterManager.add(third);
    }


    @Test
    void GetAllLessLimit() {
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{third, second, first};

        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllEqualsLimit() {
        posterManager.add(fourth);
        posterManager.add(fifth);
        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllOverLimit() {
        posterManager.add(fourth);
        posterManager.add(fifth);
        posterManager.add(sixth);

        PosterItem[] actual = posterManager.getAll();
        PosterItem[] expected = new PosterItem[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }
}
