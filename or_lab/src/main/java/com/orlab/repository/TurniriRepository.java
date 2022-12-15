package com.orlab.repository;

import com.orlab.model.Turniri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TurniriRepository extends JpaRepository<Turniri, String> {
    Turniri findByIdTurnir(Integer IdTurnir);

    List<Turniri> findByTip(String tip);

    List<Turniri> findBySerija(String serija);

    List<Turniri> findByLokacija(String lokacija);

}