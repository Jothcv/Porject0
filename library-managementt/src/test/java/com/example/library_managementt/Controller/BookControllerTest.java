package com.example.library_managementt.Controller;

import com.example.library_managementt.controller.BookController;
import com.example.library_managementt.model.entity.Book;
import com.example.library_managementt.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    void getAllBooks_ShouldReturnListOfBooks() {

        Book book1 = new Book();
        Book book2 = new Book();
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));


        List<Book> result = bookController.getAllBooks();


        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        verify(bookService).getAllBooks();
    }

    @Test
    void getBookById_ShouldReturnBook() {

        Book book = new Book();
        when(bookService.getBookById(anyLong())).thenReturn(Optional.of(book));


        ResponseEntity<Book> response = bookController.getBookById(1L);


        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(book, response.getBody());
        verify(bookService).getBookById(1L);
    }

    @Test
    void createBook_ShouldReturnCreatedBook() {

        Book book = new Book();
        when(bookService.saveBook(any(Book.class))).thenReturn(book);


        Book result = bookController.createBook(book);


        assertNotNull(result);
        assertEquals(book, result);
        verify(bookService).saveBook(book);
    }

    @Test
    void updateBook_ShouldReturnUpdatedBook() {

        Book existingBook = new Book();
        Book updatedBook = new Book();
        when(bookService.getBookById(anyLong())).thenReturn(Optional.of(existingBook));
        when(bookService.saveBook(any(Book.class))).thenReturn(updatedBook);


        ResponseEntity<Book> response = bookController.updateBook(1L, updatedBook);


        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(updatedBook, response.getBody());
        verify(bookService).getBookById(1L);
        verify(bookService).saveBook(updatedBook);
    }

    @Test
    void deleteBook_ShouldReturnOk() {

        when(bookService.getBookById(anyLong())).thenReturn(Optional.of(new Book()));


        ResponseEntity<Void> response = bookController.deleteBook(1L);


        assertEquals(200, response.getStatusCodeValue());
        verify(bookService).getBookById(1L);
        verify(bookService).deleteBook(1L);
    }

    @Test
    void getBookById_ShouldReturnNotFound() {

        when(bookService.getBookById(anyLong())).thenReturn(Optional.empty());


        ResponseEntity<Book> response = bookController.getBookById(1L);


        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
        verify(bookService).getBookById(1L);
    }
}
