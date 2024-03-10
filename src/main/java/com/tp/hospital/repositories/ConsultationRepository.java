package com.tp.hospital.repositories;

import com.tp.hospital.entite.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
