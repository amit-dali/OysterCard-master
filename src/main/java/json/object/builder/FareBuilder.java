package json.object.builder;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.ApplicationException;
import objectmodel.Fare;

public enum FareBuilder {

    INSTANCE;
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public Fare[] build() throws ApplicationException {
        try {
            return OBJECT_MAPPER.readValue(new File(getClass().getClassLoader().getResource("fares.json").getFile()), Fare[].class);
        } catch (IOException excep) {
            throw new ApplicationException(excep.getLocalizedMessage());
        }
    }

}
