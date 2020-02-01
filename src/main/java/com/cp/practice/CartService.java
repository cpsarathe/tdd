package com.cp.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    List<Book> books = new ArrayList<>();
    private BigDecimal salesTax = new BigDecimal("12.5");

    public List<Book> getCartItems() {
        return books;
    }

    public void add(Book awsCertifiedBook , int qty) {
        for(int x=0;x<qty;x++) {
            this.books.add(awsCertifiedBook);
        }
    }

    public BigDecimal getTotalPrice(){
        BigDecimal total = new BigDecimal("0");
        for(Book book : books){
            total = total.add(book.getPrice());
        }
        return total;
    }

    public BigDecimal getSalesTax(BigDecimal totalPrice) {
        return (totalPrice.multiply(salesTax)).divide(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_UP);
    }

    public BigDecimal getTotalPriceWithSalesTax() {
        BigDecimal totalPrice = this.getTotalPrice();
        BigDecimal salesTaxe =  this.getSalesTax(totalPrice);
        BigDecimal cartTotal =   totalPrice.add(salesTaxe).setScale(2,BigDecimal.ROUND_UP);
        return cartTotal;
    }
}
