package tn.esb.bi1.pharmacyApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bi1.pharmacyApi.Domains.Patient;
import tn.esb.bi1.pharmacyApi.Services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
//ulr de parientController => http://localhost:9592/patients
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientServ;

    @GetMapping("/all")
    //L'url de cette methode =>http://localhost:9592/patients/all
    public List<Patient> getAllPatients()
    {
        return patientServ.getAll();
    }
    @PostMapping("/add")
    //L'url de cette methode =>http://localhost:9592/patients/add
    public Patient addNewPatient(Patient patient)
    {
        return patientServ.addPatient(patient);
    }
    @GetMapping("/{numss}")
    public Optional<Patient> getPatient(Long numss)
    {
        return patientServ.getPatientById(numss);
    }
}
