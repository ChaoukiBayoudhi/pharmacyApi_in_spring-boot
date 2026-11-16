# Pharmacy API in Spring Boot

A REST API built with Spring Boot around 8 JPA entities, using PostgreSQL.

## Tech stack

- Java 17, built with Maven
- Spring Boot 2.6.3
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`pharmacydb1` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Drug` | code, name, price, fabricationDate, expirationDate, description, stock, image, drugLaboratory, prescriptions |
| `Laboratory` | id, name, email, phoneNumber, siteUrl, salesManagerName, laboratoryAddress, drugs |
| `Doctor` | id, firstName, lastName, email, phoneNumber, speciality |
| `Pharmacist` | cin, firstName, lastName, birthDate, startTime, pharmacistPrescriptionSet |
| `Prescription` | id, visitDate, treatmentDuration, amount, purchaseDate, drugs, pharmacistPrescriptionSet |
| `Patient` | numSS, firstName, lastName, birthDate, email, phoneNumber |
| `PharmacistPrescription` | id, date, amount, pharmacist, prescription |
| `Address` | id, number, street, city, postalCode, lab |

## REST endpoints

Found in the controllers (`PatientController`):

| Method | Path |
|---|---|
| GET | `/patients/all` |
| POST | `/patients/add` |
| GET | `/patients/{numss}` |

## Project structure

- `tn.esb.bi1.pharmacyApi`: PharmacyApiApplication
- `tn.esb.bi1.pharmacyApi.Domains`: Address, Doctor, Drug, Laboratory, Patient, Pharmacist, PharmacistPrescription, PharmacistPrescriptionId, Prescription
- `tn.esb.bi1.pharmacyApi.Enumerations`: DoctorSpeciality
- `tn.esb.bi1.pharmacyApi.Repositories`: AddressRepository, DoctorRepository, DrugRepository, LaboratoryRepository, PatientRepository, PharmacistPrescriptionRepository, PharmacistRepository, PresecriptionRepository
- `tn.esb.bi1.pharmacyApi.Services`: AddressService, DoctorService, DrugService, LaboratoryService, PatientService, PharmacistService, PrescriptionService
- `tn.esb.bi1.pharmacyApi.Web`: AddressController, DoctorController, DrugController, LaboratoryController, PatientController, PharmacistController, PrescriptionController
- Tests: 1 test class

## How to run

Requirements: a JDK 17+ and Maven (or the included Maven wrapper).
Create the `pharmacydb1` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:9592`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
