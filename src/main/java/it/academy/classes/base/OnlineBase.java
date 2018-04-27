package it.academy.classes.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import it.academy.classes.Hospital;
import it.academy.classes.patient.JacksonPatientDeserializer;
import it.academy.classes.patient.Patient;
import it.academy.interfaces.InfoBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class OnlineBase implements InfoBase {
    private String baseName;

    public OnlineBase(String onlineBase) {
        this.baseName = onlineBase;
    }

    @Override
    public List<Patient> getAllInfo() {
        List<Patient> listOfPatient = null;
        try {
            URL url = new URL(baseName);
            URLConnection urlConnection = (URLConnection) url.openConnection();
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule sm = new SimpleModule();
            sm.addDeserializer(Patient.class, new JacksonPatientDeserializer());
            mapper.registerModule(sm);
            Hospital hospital = mapper.readValue(url, Hospital.class);
            listOfPatient = hospital.getHospital();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPatient;
    }
}
