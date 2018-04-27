package it.academy.classes;

import it.academy.classes.patient.Patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hospital {
    private List<Patient> hospital = new ArrayList<>();

    public Hospital(Collection<Patient> patientCollection) {
        this.hospital.addAll(patientCollection);
    }

    public Hospital() {
    }

    public void addPatient(Patient patient) {
        hospital.add(patient);
    }

    public List<Patient> getHospital() {
        return hospital;
    }
}
