package com.cp.practice;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookStoreTest {

    @Test
    public void storeIsEmptyWhenNoBookAdded(){
        BookStore bookStore = new BookStore();
        List<String> books = bookStore.books();
        assertTrue(books.isEmpty(),()-> "Book store should be empty");
    }
}
