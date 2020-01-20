package com.cp.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
    private List<String> books = new ArrayList<>();

    public List<String> books() {
        return this.books;
    }

    public void add(String bookName){
        this.books.add(bookName);
    }
    public void add(String... bookName) {
        Arrays.stream(bookName).forEach(book->books.add(book));
    }

    public List<String> arrange() {
        return this.books.stream().sorted().collect(Collectors.toList());
    }
}
