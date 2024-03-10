package com.tp.hospital.repositories;

import com.tp.hospital.entite.Medecin;
import com.tp.hospital.entite.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {

    Patient findByNom(String name);

}
