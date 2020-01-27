package com.cp.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return this.books;
    }

    public void add(Book book){
        this.books.add(book);
    }
    public void add(Book... books) {
        Arrays.stream(books).forEach(book->this.books.add(book));
    }
    public List<Book> arrange(Criteria<Book> criteria) {
        return criteria.arrange(this.books);
    }
}
