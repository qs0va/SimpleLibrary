/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import ru.dynamika.testtask.sb.simplelibrary.models.Borrow;

/**
 *
 * @author qs0va_
 */
@JsonPropertyOrder({"clientName", "clientBirthDate", "bookName", "bookAuthor", "bookCode", "borrowDate"})
public class BorrowDTO {

    String clientName;

    Date clientBirthDate;

    String bookName;

    String bookAuthor;

    String bookCode;

    Date borrowDate;

    public BorrowDTO() {
    }

    public BorrowDTO(String clientName, Date clientBirthDate, String bookName, String bookAuthor, String bookCode, Date borrowDate) {
        this.clientName = clientName;
        this.clientBirthDate = clientBirthDate;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCode = bookCode;
        this.borrowDate = borrowDate;
    }

    public BorrowDTO(Borrow borrow) {
        this.clientName = borrow.getClient().getName();
        this.clientBirthDate = borrow.getClient().getBirthDate();
        this.bookName = borrow.getBook().getName();
        this.bookAuthor = borrow.getBook().getAuthor();
        this.bookCode = borrow.getBook().getCode();
        this.borrowDate = borrow.getBorrowDate();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(Date clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
