package com.cp.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CartServiceTest {

    @Test
    @DisplayName("Empty Cart When No Book added")
    public void shouldHaveEmptyCartWhenNoBookAdded(){
        CartService cartService = new CartService();
        assertEquals(0,cartService.getCartItems().size());
    }

    @Test
    @DisplayName("Cart has 1 dItem When user adds 1 book with 1 qty")
    public void shouldAddOneBookToCart(){
        CartService cartService = new CartService();
        Book awsCertifiedBook = new Book("AWS Certified Solutions Architect" ,
                LocalDate.of(2015, 02, 20)
                , "CP" , new BigDecimal("112"));
        cartService.add(awsCertifiedBook,1);
        assertEquals(1,cartService.getCartItems().size());
    }

    @Test
    @DisplayName("Cart has item with 5 quantity when user buys 1 book with 5 qty.")
    public void shouldAddOneBookWithFiveQuantity() {
        CartService cartService = new CartService();
        Book awsCertifiedBook = new Book("AWS Certified Solutions Architect" ,
                LocalDate.of(2015, 02, 20)
                , "CP" , new BigDecimal("112"));
        cartService.add(awsCertifiedBook,5);
        assertEquals(5,cartService.getCartItems().size());
        assertEquals(new BigDecimal("560"),cartService.getTotalPrice());
    }

    @Test
    @DisplayName("Cart has 1 item with 8 quantity when user buys 1 book with 5 qty and later adds another 3 qty")
    public void shouldUpdateCartWhenSameItemAddedMoreThanOnce() {
        CartService cartService = new CartService();
        Book awsCertifiedBook = new Book("AWS Certified Solutions Architect" ,
                LocalDate.of(2015, 02, 20)
                , "CP" , new BigDecimal("112"));
        cartService.add(awsCertifiedBook,5);
        cartService.add(awsCertifiedBook,3);
        assertEquals(8,cartService.getCartItems().size());
        assertEquals(new BigDecimal("896"),cartService.getTotalPrice());
    }

    @Test
    @DisplayName("Cart total and taxes are updated when user buys 1 book with 2 qty and another book with 2 qty")
    public void shouldUpdateCartTotalAndTaxesWhenTwoDiffItemsAdded() {
        CartService cartService = new CartService();
        Book awsCertifiedBook = new Book("AWS Certified Solutions Architect" ,
                LocalDate.of(2015, 02, 20)
                , "CP" , new BigDecimal("39.99"));
        Book springInAction = new Book("Spring In Action" ,
                LocalDate.of(2014, 07, 11)
                , "Amol", new BigDecimal("99.99")) ;
        cartService.add(awsCertifiedBook,2);
        cartService.add(springInAction,2);

        BigDecimal total = cartService.getTotalPrice();
        assertEquals(new BigDecimal("35.00"),cartService.getSalesTax(total));
        assertEquals(new BigDecimal("314.96"),cartService.getTotalPriceWithSalesTax());
    }
}
