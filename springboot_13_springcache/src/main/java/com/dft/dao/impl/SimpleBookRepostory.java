package com.dft.dao.impl;

import com.dft.dao.BookRepository;
import com.dft.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepostory implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getBookByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some Book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
