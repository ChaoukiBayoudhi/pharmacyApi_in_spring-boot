package tn.esb.bi1.pharmacyApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi1.pharmacyApi.Domains.Pharmacist;
@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist,Long> {
}
