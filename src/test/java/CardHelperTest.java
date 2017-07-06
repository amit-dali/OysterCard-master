import org.junit.Assert;
import org.junit.Test;

import constants.JourneyStatus;
import constants.JourneyType;
import exceptions.ApplicationException;
import helpers.CardHelper;
import helpers.PropertyHelper;
import objectmodel.Card;

public class CardHelperTest {

    @Test
    public void topUpOysterCard() throws ApplicationException {
        Card card = CardHelper.INSTANCE
                .topUpOysterCard(TestHelper.INSTANCE.formOysterCard("1", "Hammersmith", JourneyType.TUBE, JourneyStatus.INCOMPLETE));
        Assert.assertEquals(PropertyHelper.INSTANCE.getTopUpAmout(), card.getBalance(), 0);
    }


}
