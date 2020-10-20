package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {

    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager afishaManager;

    AfishaItem first = new AfishaItem(1, 1, "first", "genre");
    AfishaItem second = new AfishaItem(2, 2, "second", "genre");
    AfishaItem third = new AfishaItem(3, 3, "third", "genre");
    AfishaItem fourth = new AfishaItem(4, 4, "fourth", "genre");


    @Test
    void GetAllLessLimit() {
        afishaManager.add(first);
        afishaManager.add(second);
        AfishaItem[] returned = new AfishaItem[]{first, second};
        doReturn(returned).when(repository).findAll();
        AfishaItem[] actual = afishaManager.getAll();
        AfishaItem[] expected = new AfishaItem[]{second, first};

        assertArrayEquals(actual, expected);

    }

    @Test
    void getAllEqualsLimit() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
        AfishaItem[] returned = new AfishaItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();

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
        AfishaItem[] returned = new AfishaItem[]{second, third, fourth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] actual = afishaManager.getAll();
        AfishaItem[] expected = new AfishaItem[]{fourth, third, second};
        assertArrayEquals(actual, expected);
    }

}
