/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dynamika.testtask.sb.simplelibrary.models.Book;
import ru.dynamika.testtask.sb.simplelibrary.services.BookService;

/**
 *
 * @author qs0va_
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String booksPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/index";
    }

    @GetMapping("/new")
    public String newBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String editBookPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findBook(id));
        return "books/edit";
    }

    @PostMapping("")
    public String newBook(@ModelAttribute("book") Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/edit")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }
}
