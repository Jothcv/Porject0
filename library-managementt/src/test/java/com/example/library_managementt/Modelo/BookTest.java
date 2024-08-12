package com.example.library_managementt.Modelo;


import com.example.library_managementt.model.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void equals_ShouldReturnTrueForSameIsbn() {
        Book book1 = new Book();
        Book book2 = new Book();

        assertEquals(book1, book2);
    }
}