package com.example.library_managementt.service;

import com.example.library_managementt.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

//para el metodo deleteBook nfnbawfj
@SpringBootTest
public class BookServiceJUnitTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testDeleteBookWithJUnit(){
        Long bookId=1L;

        doNothing().when(bookRepository).deleteById(bookId);

        assertDoesNotThrow(()->bookService.deleteBook(bookId));

        verify(bookRepository,times(1)).deleteById(bookId);
    }
}
