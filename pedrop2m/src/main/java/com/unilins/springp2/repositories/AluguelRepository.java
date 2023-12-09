package com.unilins.springp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilins.springp2.entities.Aluguel;
import com.unilins.springp2.entities.pk.AluguelPK;

public interface AluguelRepository extends JpaRepository<Aluguel, AluguelPK> {

}
