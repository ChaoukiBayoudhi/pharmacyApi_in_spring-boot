package tn.esb.bi1.pharmacyApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi1.pharmacyApi.Domains.Patient;
import tn.esb.bi1.pharmacyApi.Repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepos;
    public List<Patient> getAll()
    {
        return patientRepos.findAll();
    }
    public Patient addPatient(Patient patient)
    {
        return patientRepos.save(patient);
    }
    public Optional<Patient> getPatientById(Long id)
    {
        return patientRepos.findById(id);
    }
}
