/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dynamika.testtask.sb.simplelibrary.dto.BorrowDTO;
import ru.dynamika.testtask.sb.simplelibrary.services.BookService;
import ru.dynamika.testtask.sb.simplelibrary.services.BorrowService;
import ru.dynamika.testtask.sb.simplelibrary.services.ClientService;

/**
 *
 * @author qs0va_
 */
@Controller
@RequestMapping("borrow")
public class BorrowController {

    private final BookService bookService;
    private final ClientService clientService;
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BookService bookService, ClientService clientService, BorrowService borrowService) {
        this.bookService = bookService;
        this.clientService = clientService;
        this.borrowService = borrowService;
    }

    @GetMapping("/client/{id}")
    public String clientBorrowPage(@PathVariable("id") Long clientId, Model model) {
        model.addAttribute("clientId", clientId);
        model.addAttribute("allBooks", bookService.getAllBooks());
        return "borrow/books";
    }

    @GetMapping("/book/{id}")
    public String bookBorrowPage(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("allClients", clientService.getAllClients());
        return "borrow/clients";
    }

    @PostMapping("")
    public String borrow(@RequestParam("clientId") Long clientId, @RequestParam("bookId") Long bookId, Model model) {
        try {
            model.addAttribute("clientId", clientId);
            model.addAttribute("bookId", bookId);
            borrowService.borrow(clientId, bookId);
            return "borrow/success";
        } catch (Exception e) {
            model.addAttribute("reason", e.toString());
            return "borrow/fail";
        }
    }

    @ResponseBody
    @GetMapping("/all")
    public List<BorrowDTO> allBorrows() {
        return borrowService.getAllBorrows();
    }
}
