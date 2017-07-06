package helpers;

import java.util.stream.Stream;

import constants.Constants;
import exceptions.ApplicationException;
import json.object.builder.PropertyBuilder;

public enum PropertyHelper {
    INSTANCE;

    public float getMaxFair() {
        try {
            return Stream.of(PropertyBuilder.INSTANCE.build())
                    .filter(property -> Constants.MAX_FARE_KEY_NAME.equalsIgnoreCase(property.getName()))
                    .map(property -> Float.valueOf(property.getValue())).findFirst().get();
        } catch (ApplicationException appExcep) {
            System.out.println("Error:" + appExcep.getLocalizedMessage());
            return 1;
        }

    }

    public float getTopUpAmout() {
        try {
            return Stream.of(PropertyBuilder.INSTANCE.build())
                    .filter(property -> Constants.TOPUP_AMOUNT_KEY_NAME.equalsIgnoreCase(property.getName()))
                    .map(property -> Float.valueOf(property.getValue())).findFirst().get();
        } catch (ApplicationException appExcep) {
            System.out.println("Error:" + appExcep.getLocalizedMessage());
            return 1;
        }

    }

}
