package com.tp.hospital.repositories;

import com.tp.hospital.entite.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    Medecin findByNom(String name);

}
