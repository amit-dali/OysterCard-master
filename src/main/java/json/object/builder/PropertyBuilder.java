package json.object.builder;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.ApplicationException;
import objectmodel.Property;

public enum PropertyBuilder {
    INSTANCE;

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public Property[] build() throws ApplicationException {
        try {
            return OBJECT_MAPPER.readValue(new File(getClass().getClassLoader().getResource("config.json").getFile()), Property[].class);
        } catch (IOException excep) {
            throw new ApplicationException(excep.getLocalizedMessage());
        }

    }

}
