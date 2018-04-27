package it.academy.classes.operations.registration;

import it.academy.classes.base.OfflineBase;
import it.academy.classes.menu.Menu;
import it.academy.classes.patient.Patient;
import it.academy.classes.patient.PatientComparator;
import it.academy.interfaces.Operation;

import java.util.Set;
import java.util.TreeSet;


public class Registration implements Operation {
    private Menu menu;

    public Registration(Menu menu) {
        this.menu = menu;
    }

    public String name() {
        return "Register new patients.";
    }

    @Override
    public void run() {
        OfflineBase offlineBase = new OfflineBase("OfflineBase.json");
        Set<Patient> allPatients = new TreeSet<>(new PatientComparator());
        allPatients.addAll(offlineBase.getAllInfo());
        Registrator registrator = new Registrator();
        allPatients.addAll(registrator.getNewPatient());
        offlineBase.upload(allPatients);
        menu.choice();
    }
}
