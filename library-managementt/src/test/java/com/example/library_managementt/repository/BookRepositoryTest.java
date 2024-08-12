package com.example.library_managementt.repository;


import com.example.library_managementt.model.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;


    @Test
    void findById_ShouldReturnBook(){
        Book book=new Book();
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> result=bookRepository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(book,result.get());
        verify(bookRepository).findById(1L);
    }

    void save_ShouldReturnSavedBook(){
        Book book=new Book();
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook=bookRepository.save(book);

        assertNotNull(savedBook);
        assertEquals(book,savedBook);
        verify(bookRepository).save(book);
    }
}
