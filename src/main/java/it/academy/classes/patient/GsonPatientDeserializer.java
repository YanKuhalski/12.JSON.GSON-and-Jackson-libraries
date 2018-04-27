package it.academy.classes.patient;

import com.google.gson.*;
import it.academy.exeptions.WrongValueOfHealthExeption;

import java.lang.reflect.Type;
import java.text.ParseException;

public class GsonPatientDeserializer implements JsonDeserializer<Patient> {
    @Override
    public Patient deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Patient patient = null;
        try {
            JsonObject jsonObject = json.getAsJsonObject();
            patient = new Patient();
            patient.setName(jsonObject.get("name").getAsString())
                    .setSecondName(jsonObject.get("secondName").getAsString())
                    .setBirthday(jsonObject.get("birthday").getAsString())
                    .setHealthy(jsonObject.get("healthy").getAsString())
                    .create();
        } catch (ParseException | WrongValueOfHealthExeption e) {
            e.printStackTrace();
        }
        return patient;
    }
}
