package com.asseco.see.mk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asseco.see.mk.model.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findAll();
}
