package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    AfishaItem first = new AfishaItem(1, 1, "first", "genre");
    AfishaItem second = new AfishaItem(2, 2, "second", "genre");
    AfishaItem third = new AfishaItem(3, 3, "third", "genre");
    AfishaItem fourth = new AfishaItem(4, 4, "fourth", "genre");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }


    @Test
    void shouldSaveAndFindAll() {
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        int id = 2;
        AfishaItem actual = repository.findById(id);
        AfishaItem expected = second;
        assertEquals(expected, actual);

    }

    @Test
    void shouldFindByNonExistId() {
        int id = 5;
        AfishaItem actual = repository.findById(id);
        AfishaItem expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int id = 2;
        repository.removeById(id);
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{};
        assertArrayEquals(actual, expected);
    }
}
