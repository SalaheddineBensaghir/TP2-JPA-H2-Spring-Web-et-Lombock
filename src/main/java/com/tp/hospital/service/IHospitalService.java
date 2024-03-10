package com.tp.hospital.service;

import com.tp.hospital.entite.Consultation;
import com.tp.hospital.entite.Medecin;
import com.tp.hospital.entite.Patient;
import com.tp.hospital.entite.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
