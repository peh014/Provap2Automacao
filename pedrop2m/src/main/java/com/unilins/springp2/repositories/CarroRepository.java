package com.unilins.springp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilins.springp2.entities.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
