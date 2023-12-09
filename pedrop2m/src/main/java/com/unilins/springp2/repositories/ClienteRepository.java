package com.unilins.springp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilins.springp2.entities.Cliente;

public interface  ClienteRepository extends JpaRepository<Cliente, Long>{

}
