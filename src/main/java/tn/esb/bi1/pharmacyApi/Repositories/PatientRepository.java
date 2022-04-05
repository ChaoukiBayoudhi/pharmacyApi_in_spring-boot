package tn.esb.bi1.pharmacyApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi1.pharmacyApi.Domains.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
    //L'interface JpaRepository<S,T> est predefinie dans la dependance Maven spring-data-jpa
    //avec dans ce repository S<-->Patient et T<-->Long
    //Cette interface presente des methodes comme

    //List<Patient> findAll() : permet de retourner tous les patients

    //Optional<Patient> findById(Long id):retourne le patient à partir de la BD ayant comme id
    //celui fourni en paramètre ou bien elle ne retourne rien.
    //Optional peut contenir seulement un seul element ou bien zero element
    //Optional<Patient> res=patientRepos.findById(5);
    //if(res.isPresent()) ou if(res.isEmpty()
    //recuperer le patient dans Optional s'il existe : Patient p=res.get();

    //Patient save(Patient p): joue double role :
    //->la création (Ajout)
    //->la mise à jour

    //Suppression : void deleteById(Long id)
}
