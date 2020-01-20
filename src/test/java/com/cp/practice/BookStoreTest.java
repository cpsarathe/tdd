package com.cp.practice;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book Store Under Test")
class BookStoreTest {
    private BookStore bookStore;

    @Test
    @Disabled
    void testShouldFail(){
        fail(()-> "Failed test case");
    }

    @BeforeEach
    public void setup(){
        bookStore = new BookStore();
    }

    @Test
    @DisplayName("Empty Book Store when No Books Added")
    void shouldHaveEmptyBookStoreIfNoBookAdded(){
        assertTrue(bookStore.books().size()==0);
    }

    @Test
    @DisplayName("Add 2 Books to Book Store")
    void shouldContain2BookWhen2BooksAdded(){
        bookStore.add("Effective Java" , "AWS Certified Solutions Architect");
        List<String> books = bookStore.books();
        assertTrue(books.contains("Effective Java") , ()-> "Effective Java should exist in book store");
        assertTrue(books.contains("AWS Certified Solutions Architect") , ()-> "AWS Certified Solutions Architect should exist in bookstore");
        assertTrue(books.size() == 2 , () -> "Book store do not have 2 books in shelf");
    }

//    As a user, I should be able to arrange my bookshelf based on certain
//    criteria

    @Test
    @DisplayName("Arrange Books By Name Lexicographically")
    void shouldArrangeBooksByNameAndOrder(){
        bookStore.add("Effective Java" , "AWS Certified Solutions Architect" , "Spring In Action" , "How to Win Friends");
        List<String> books = bookStore.arrange();
        List<String> expected = Arrays.asList( "AWS Certified Solutions Architect" , "Effective Java", "Spring In Action" , "How to Win Friends").stream().sorted().collect(Collectors.toList());
        assertEquals(expected,books);
    }
}
