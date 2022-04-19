package tn.esb.bi1.pharmacyApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi1.pharmacyApi.Domains.Patient;
import tn.esb.bi1.pharmacyApi.Services.PatientService;

import javax.validation.Valid;
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
    public Patient addNewPatient(@Valid @RequestBody Patient patient)
    {
        return patientServ.addPatient(patient);
    }


    @GetMapping("/{numss}")
    public Optional<Patient> getPatient(@PathVariable Long numss)
    {
        return patientServ.getPatientById(numss);
    }
}
