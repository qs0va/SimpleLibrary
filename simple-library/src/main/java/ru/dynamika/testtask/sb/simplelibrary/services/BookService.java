/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dynamika.testtask.sb.simplelibrary.models.Book;
import ru.dynamika.testtask.sb.simplelibrary.repositories.BookRepository;

/**
 *
 * @author qs0va_
 */
@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository repo) {
        this.bookRepo = repo;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book findBook(Long id) {
        return bookRepo.findById(id).get();
    }

    @Transactional
    public Long createBook(Book book) {
        bookRepo.save(book);
        return book.getId();
    }

    @Transactional
    public void updateBook(Long id, Book book) {
        book.setId(id);
        bookRepo.save(book);
    }
}
