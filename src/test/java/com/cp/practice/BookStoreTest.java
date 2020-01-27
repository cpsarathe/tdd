package com.cp.practice;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book Store Under Test")
class BookStoreTest {
    private BookStore bookStore;
    private Book awsCertified;
    private Book springInAction;
    private Book effectiveJava;

    @Test
    @Disabled
    void testShouldFail(){
        fail(()-> "Failed test case");
    }

    @BeforeEach
    public void setup(){
        awsCertified = new Book("AWS Certified Solutions Architect" ,
                LocalDate.of(2015, 02, 20)
                 , "CP" , new BigDecimal("112"));
        springInAction = new Book("Spring In Action" ,
                LocalDate.of(2014, 07, 11)
                , "Amol", new BigDecimal("97")) ;
        effectiveJava = new Book("Effective Java 2nd Edition" ,
                LocalDate.of(2011, 01, 21)
                , "Manjit" , new BigDecimal("108.99"));
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
        bookStore.add(effectiveJava,springInAction);
        List<Book> books = bookStore.books();
        assertTrue(books.contains(effectiveJava) , ()-> "Effective Java should exist in book store");
        assertTrue(books.contains(springInAction) , ()-> "AWS Certified Solutions Architect should exist in bookstore");
        assertTrue(books.size() == 2 , () -> "Book store do not have 2 books in shelf");
    }

//    As a user, I should be able to arrange my bookshelf based on certain
//    criteria

    @Test
    @DisplayName("Arrange Books By Name Lexicographically")
    void shouldArrangeBooksByNameAndOrder(){
        bookStore.add(awsCertified,effectiveJava,springInAction);
        Criteria<Book> criteria = new ArrangeByName();
        List<Book> expected = new ArrayList<>();
        expected.add(awsCertified);
        expected.add(effectiveJava);
        expected.add(springInAction);
        List<Book> actual = bookStore.arrange(criteria);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Arrange Books By Published Date")
    void shouldArrangeBooksByPublishedDate(){
        bookStore.add(awsCertified,effectiveJava,springInAction);
        Criteria<Book> criteria = new ArrangeByPublishedDate();
        List<Book> expected = new ArrayList<>();
        expected.add(effectiveJava);
        expected.add(springInAction);
        expected.add(awsCertified);
        List<Book> actual = bookStore.arrange(criteria);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Arrange Books By Price")
    void shouldArrangeBooksByPrice(){
        bookStore.add(awsCertified,effectiveJava,springInAction);
        Criteria<Book> criteria = new ArrangeByPrice();
        List<Book> expected = new ArrayList<>();
        expected.add(springInAction);
        expected.add(effectiveJava);
        expected.add(awsCertified);
        List<Book> actual = bookStore.arrange(criteria);
        assertEquals(expected,actual);
    }
}
