package com.dft.dao;

import com.dft.entity.Book;

public interface BookRepository {

    Book getBookByIsbn(String isbn);
}
