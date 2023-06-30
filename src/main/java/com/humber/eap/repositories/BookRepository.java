package com.humber.eap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humber.eap.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
