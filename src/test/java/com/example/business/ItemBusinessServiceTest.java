package com.example.business;

import com.example.data.ItemRepository;
import com.example.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService business;

    @Mock
    ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll())
                .thenReturn(Arrays
                        .asList(new Item(2, "Item2", 20,20),
                new Item(3, "Item3", 30,30)));
        List<Item> items = business.retrieveAllItems();
        assertEquals(400, items.get(0).getValue());
        assertEquals(900, items.get(1).getValue());
    }
}