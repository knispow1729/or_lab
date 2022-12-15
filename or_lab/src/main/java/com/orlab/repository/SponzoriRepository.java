package com.orlab.repository;

import com.orlab.model.Sponzori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponzoriRepository extends JpaRepository<Sponzori, Integer> {

    Sponzori findByIdSponzor(Integer IdSponzor);
}