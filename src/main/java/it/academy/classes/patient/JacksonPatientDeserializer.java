package it.academy.classes.patient;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import it.academy.exeptions.WrongValueOfHealthExeption;

import java.io.IOException;
import java.text.ParseException;

public class JacksonPatientDeserializer extends StdDeserializer<Patient> {
    public JacksonPatientDeserializer() {
        this(null);
    }
    protected JacksonPatientDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Patient deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Patient patient = null;
        try {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            patient = new Patient();
            patient.setName( node.get("name").asText())
                    .setSecondName(node.get("secondName").asText())
                    .setBirthday(node.get("birthday").asText())
                    .setHealthy(node.get("healthy").asText())
                    .create();
        } catch (WrongValueOfHealthExeption | ParseException e) {
            e.printStackTrace();
        }
        return patient;
    }
}
