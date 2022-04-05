package tn.esb.bi1.pharmacyApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi1.pharmacyApi.Domains.PharmacistPrescription;
import tn.esb.bi1.pharmacyApi.Domains.PharmacistPrescriptionId;
@Repository
public interface PharmacistPrescriptionRepository extends JpaRepository<PharmacistPrescription, PharmacistPrescriptionId> {
        }
