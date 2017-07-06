import org.junit.Assert;
import org.junit.Test;

import exceptions.ApplicationException;
import json.object.builder.FareBuilder;
import json.object.builder.PropertyBuilder;
import json.object.builder.StationBuilder;
import objectmodel.Fare;
import objectmodel.Property;
import objectmodel.Station;

public class JsonObjectBuilderTest {

    @Test
    public void fareBuilderBuild() throws ApplicationException {
        Fare[] fares = FareBuilder.INSTANCE.build();
        Assert.assertNotNull(fares);
    }

    @Test
    public void propertyBuilderBuild() throws ApplicationException {
        Property[] properties = PropertyBuilder.INSTANCE.build();
        Assert.assertNotNull(properties);
    }

    @Test
    public void stationBuilderBuild() throws ApplicationException {
        Station[] stations = StationBuilder.INSTANCE.build();
        Assert.assertNotNull(stations);
    }

}
