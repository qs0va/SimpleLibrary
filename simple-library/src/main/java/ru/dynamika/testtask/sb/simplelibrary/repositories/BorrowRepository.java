/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dynamika.testtask.sb.simplelibrary.models.Borrow;

/**
 *
 * @author qs0va_
 */
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long>{

}
