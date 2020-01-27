package com.cp.practice;

import java.math.BigDecimal;
import java.time.LocalDate;
public class Book {
    private String name;
    private LocalDate publishedDate;
    private String author;
    private BigDecimal price;

    public Book(String name , LocalDate publishedDate , String author , BigDecimal price){
        this.name = name;
        this.publishedDate = publishedDate;
        this.author = author;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public LocalDate getPublishedDate() {
        return publishedDate;
    }
    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return "{" + this.author + ":" + this.publishedDate + ":" + this.name + ":"+ this.price + "}";
    }
}
