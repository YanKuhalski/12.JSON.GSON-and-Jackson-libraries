package it.academy.classes.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.academy.classes.Hospital;
import it.academy.classes.patient.Patient;
import it.academy.classes.patient.GsonPatientDeserializer;
import it.academy.classes.patient.PatientSerializer;
import it.academy.interfaces.InfoBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class OfflineBase implements InfoBase {
    private String baseName;
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Patient.class, new PatientSerializer())
            .registerTypeAdapter(Patient.class, new GsonPatientDeserializer())
            .create();

    public OfflineBase(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public List<Patient> getAllInfo() {
        List<Patient> listOfPatient = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(baseName))) {
            Hospital hospital = gson.fromJson(br, Hospital.class);
            listOfPatient.addAll(hospital.getHospital());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
        }
        return listOfPatient;
    }

    public void upload(Set<Patient> allPatients) {
        addToBase(allPatients, this.baseName);
    }

    private void addToBase(Collection<Patient> patientCollection, String baseName) {
        Hospital hospital = new Hospital(patientCollection);
        try (Writer fl = new FileWriter(baseName)) {
            gson.toJson(hospital, Hospital.class, fl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
