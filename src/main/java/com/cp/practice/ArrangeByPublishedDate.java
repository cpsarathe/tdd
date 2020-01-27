package com.cp.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangeByPublishedDate implements Criteria<Book> {

    @Override
    public List<Book> arrange(List<Book> list) {
        return list.stream().sorted(Comparator.comparing(Book::getPublishedDate)).collect(Collectors.toList());
    }
}
