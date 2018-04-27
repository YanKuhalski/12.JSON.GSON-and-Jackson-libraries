package it.academy.classes.patient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PatientSerializer implements JsonSerializer<Patient> {
    @Override
    public JsonElement serialize(Patient obj, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("name", obj.getName());
        result.addProperty("secondName", obj.getSecondName());
        result.addProperty("birthday", obj.getBirthday());
        result.addProperty("healthy", obj.getHealthy() ? "нездоров" : "здоров");
        return result;
    }
}
