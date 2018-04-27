package it.academy.classes.operations.registration;

import it.academy.classes.patient.ConsolePatientImput;
import it.academy.classes.patient.Patient;
import it.academy.interfaces.PatientImput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registrator {
    private List<Patient> newPatientList = new ArrayList<>();

    public void getNewInfo() {
        PatientImput patientImput = new ConsolePatientImput();
        newPatientList.add(patientImput.input());
    }

    public List<Patient> getNewPatient() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество новых пациентов");
        int quantity = in.nextInt();
        for (int i = 0; i < quantity; i++) {
            getNewInfo();
        }
        return newPatientList;
    }
}
