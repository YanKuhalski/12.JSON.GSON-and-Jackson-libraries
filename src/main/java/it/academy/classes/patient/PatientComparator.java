package it.academy.classes.patient;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        if (o1.getName().equals(o2.getName()) && o1.getSecondName().equals(o2.getSecondName()) && o1.getBirthday().equals(o2.getBirthday()))
            return 0;
        else return 1;
    }
}
