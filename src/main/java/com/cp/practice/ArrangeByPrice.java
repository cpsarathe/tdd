package com.cp.practice;

import java.util.List;
import java.util.stream.Collectors;

public class ArrangeByPrice implements Criteria<Book> {
    @Override
    public List<Book> arrange(List<Book> list) {
        return list.stream().sorted((a1,a2)-> a1.getPrice().compareTo(a2.getPrice())).collect(Collectors.toList());
    }
}
