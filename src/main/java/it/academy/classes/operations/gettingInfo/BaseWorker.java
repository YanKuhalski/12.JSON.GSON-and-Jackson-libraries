package it.academy.classes.operations.gettingInfo;

import it.academy.classes.base.OfflineBase;
import it.academy.classes.base.OnlineBase;
import it.academy.classes.patient.Patient;
import it.academy.interfaces.InfoBase;
import it.academy.classes.patient.PatientComparator;

import java.util.Set;
import java.util.TreeSet;

public class BaseWorker {
    private InfoBase offlineBase;
    private InfoBase onlineBase;

    public BaseWorker(String offlineBase, String onlineBase) {
        this.onlineBase = new OnlineBase(onlineBase);
        this.offlineBase = new OfflineBase(offlineBase);
    }

    private Set<Patient> getAllInfo() {
        Set<Patient> patients = new TreeSet<>(new PatientComparator());
        patients.addAll(offlineBase.getAllInfo());
        patients.addAll(onlineBase.getAllInfo());
        return patients;
    }

    public void showAllInfo() {
        for (Patient patient : getAllInfo()) {
            System.out.println(patient);
        }
    }
}
