package com.asirem.Asirem.repositories;

import com.asirem.Asirem.models.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Integer>{

}
