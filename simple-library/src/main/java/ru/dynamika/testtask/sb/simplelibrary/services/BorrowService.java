/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dynamika.testtask.sb.simplelibrary.dto.BorrowDTO;
import ru.dynamika.testtask.sb.simplelibrary.models.Borrow;
import ru.dynamika.testtask.sb.simplelibrary.repositories.BookRepository;
import ru.dynamika.testtask.sb.simplelibrary.repositories.BorrowRepository;
import ru.dynamika.testtask.sb.simplelibrary.repositories.ClientRepository;

/**
 *
 * @author qs0va_
 */
@Service
@Transactional(readOnly = true)
public class BorrowService {

    private final BookRepository bookRepo;
    private final ClientRepository clientRepo;
    private final BorrowRepository borrowRepo;

    @Autowired
    public BorrowService(BookRepository bookRepo, ClientRepository clientRepo, BorrowRepository borrowRepo) {
        this.bookRepo = bookRepo;
        this.clientRepo = clientRepo;
        this.borrowRepo = borrowRepo;
    }

    @Transactional
    public void borrow(Long clientId, Long bookId) {
        Borrow newBorrow = new Borrow();
        newBorrow.setBook(bookRepo.findById(bookId).get());
        newBorrow.setClient(clientRepo.findById(clientId).get());
        newBorrow.setBorrowDate(new Date());

        borrowRepo.save(newBorrow);
    }

    public List<BorrowDTO> getAllBorrows() {
        List out = new ArrayList<BorrowDTO>();
        for (Borrow borrow : borrowRepo.findAll()) {
            borrow.setBook(borrow.getBook());
            borrow.setClient(borrow.getClient());
            out.add(new BorrowDTO(borrow));
        }
        return out;
    }
}
