package com.example.library_managementt.repository;


import com.example.library_managementt.model.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
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

    @Test
    void save_ShouldReturnSavedBook(){
        Book book=new Book();
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook=bookRepository.save(book);

        assertNotNull(savedBook);
        assertEquals(book,savedBook);
        verify(bookRepository).save(book);
    }

    @Test
    void deleteById_ShouldRemoveBook() {
       bookRepository.deleteById(2L);

       verify(bookRepository).deleteById(2L);
    }

    @Test
    void count_ShouldReturnNumberOfBooks() {
        // Simular el conteo de libros
        when(bookRepository.count()).thenReturn(5L);

        // Verificar el número de libros
        long count = bookRepository.count();

        assertEquals(5L, count);
        verify(bookRepository).count();
    }


    @Test
    void findAll_ShouldReturnListOfBooks() {
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> books = Arrays.asList(book1, book2);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookRepository.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        verify(bookRepository).findAll();
    }

}
