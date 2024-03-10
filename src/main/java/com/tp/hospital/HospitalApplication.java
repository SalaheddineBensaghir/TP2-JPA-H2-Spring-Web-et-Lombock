package com.tp.hospital;

import com.tp.hospital.entite.*;
import com.tp.hospital.repositories.ConsultationRepository;
import com.tp.hospital.repositories.MedecinRepository;
import com.tp.hospital.repositories.PatientRepository;
import com.tp.hospital.repositories.RendezVousRepository;
import com.tp.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);

    }
/*    @Bean
CommandLineRunner start(PatientRepository patientRepository,
                        MedecinRepository medecinRepository,
                        RendezVousRepository rendezVousRepository,
                        ConsultationRepository consultationRepository){
     return args -> {
         Stream.of("Ahmad","Mounir","Hamza").forEach(
                 name -> {
                     Patient patient=new Patient();
                     patient.setNom(name);
                     patient.setDateNaissance(new Date());
                     patient.setRendezVous(null);
                     patient.setMalade(false);
                     patientRepository.save(patient);
                 }
         );
         Stream.of("Youness","Yassine","Amine").forEach(
                 name -> {
                     Medecin medecin=new Medecin();
                     medecin.setNom(name);
                     medecin.setEmail(name+"@gmail.com");
                     medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                     medecinRepository.save(medecin);


                 }
         );
         Patient patient=patientRepository.findById(1L).orElse(null);
         Patient patient1=patientRepository.findByNom("Ahmad");

         Medecin medecin=medecinRepository.findByNom("Yassine");


         RendezVous rendezVous=new RendezVous();
         rendezVous.setDate(new Date());
         rendezVous.setStatus(StatusRDV.PENDING);
         rendezVous.setMedecin(medecin);
         rendezVous.setPatient(patient);
rendezVousRepository.save(rendezVous);

RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
         Consultation consultation=new Consultation();
         consultation.setDateConsultation(new Date());
         consultation.setRendezVous(rendezVous1);
         consultation.setRapport("Rapport 1");
         consultationRepository.save(consultation);

     };
}*/
@Bean
CommandLineRunner start(IHospitalService iHospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository){
    return args -> {
        Stream.of("Ahmad","Mounir","Hamza").forEach(
                name -> {
                    Patient patient=new Patient();
                    patient.setNom(name);
                    patient.setDateNaissance(new Date());
                    patient.setRendezVous(null);
                    patient.setMalade(false);
                    iHospitalService.savePatient(patient);
                }
        );
        Stream.of("Youness","Yassine","Amine").forEach(
                name -> {
                    Medecin medecin=new Medecin();
                    medecin.setNom(name);
                    medecin.setEmail(name+"@gmail.com");
                    medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                    iHospitalService.saveMedecin(medecin);


                }
        );
        Patient patient=patientRepository.findById(1L).orElse(null);
        Patient patient1=patientRepository.findByNom("Ahmad");

        Medecin medecin=medecinRepository.findByNom("Yassine");


        RendezVous rendezVous=new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        iHospitalService.saveRendezVous(rendezVous);

        RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
        Consultation consultation=new Consultation();
        consultation.setDateConsultation(new Date());
        consultation.setRendezVous(rendezVous1);
        consultation.setRapport("Rapport 1");
        iHospitalService.saveConsultation(consultation);

    };
}


}
