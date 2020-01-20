package com.cp.practice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Book Store Under Test")
class BookStoreTest {

    @Test
    @DisplayName("Store is Empty When No Book Added")
    void storeIsEmptyWhenNoBookAdded(){
        BookStore bookStore = new BookStore();
        List<String> books = bookStore.books();
        assertTrue(books.isEmpty(),()-> "Book store should be empty");
    }

    @Test
    @DisplayName("Should check even numbers")
    @RepeatedTest(5)
    void shouldCheckForEvenNumber(){
        int num = new Random(1).nextInt();
        assertTrue(()-> num%2==0,num + " is not an even number");
    }
}
