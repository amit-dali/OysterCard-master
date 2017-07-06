import org.junit.Assert;
import org.junit.Test;

import application.OysterCardApplication;
import constants.JourneyStatus;
import constants.JourneyType;
import constants.Swipe;
import exceptions.ApplicationException;
import helpers.CardHelper;
import objectmodel.Card;

public class OysterCardTest {
    OysterCardApplication oysterCardApp = new OysterCardApplication();

    @Test
    public void anywhereinZone1() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Holborn", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        Card journeyLeg1Completed = oysterCardApp
                .endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Earl's Court"));
        Assert.assertEquals(27.5f, journeyLeg1Completed.getBalance(), 0);
    }

    @Test
    public void anyOneZoneOutSideZone1() throws ApplicationException {
        Card oysterCardBus = TestHelper.INSTANCE.formOysterCard("1", "Wimbledon", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg2 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCardBus));
        Card journeyLeg2Completed = oysterCardApp.endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg2, "Wimbledon"));
        Assert.assertEquals(28.0f, journeyLeg2Completed.getBalance(), 0);
    }

    @Test
    public void anyTwoZonesIncludingZone1() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Holborn", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        Card journeyLeg1Completed = oysterCardApp
                .endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Hammersmith"));
        Assert.assertEquals(27.0f, journeyLeg1Completed.getBalance(), 0);
    }

    @Test
    public void anyTwoZonesExcludingZone1() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Hammersmith", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        Card journeyLeg1Completed = oysterCardApp.endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Wimbledon"));
        Assert.assertEquals(27.75f, journeyLeg1Completed.getBalance(), 0);
    }

    @Test
    public void anyBusJourney() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Hammersmith", JourneyType.BUS, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        Card journeyLeg1Completed = oysterCardApp.endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Wimbledon"));
        Assert.assertEquals(28.2f, journeyLeg1Completed.getBalance(), 0);
    }

    @Test
    public void anyBusJourneyNoSwipe() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Hammersmith", JourneyType.BUS, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        oysterCardAfterJourneyLeg1 = TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Wimbledon");
        oysterCardAfterJourneyLeg1.getJourney().setSwipe(Swipe.IN);
        Card journeyLeg1Completed = oysterCardApp.endJourney(oysterCardAfterJourneyLeg1);
        Assert.assertEquals(26.8f, journeyLeg1Completed.getBalance(), 0);
    }

    @Test
    public void tubeJourneyNoSwipe() throws ApplicationException {
        Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Hammersmith", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
        Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));
        oysterCardAfterJourneyLeg1 = TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Wimbledon");
        oysterCardAfterJourneyLeg1.getJourney().setSwipe(Swipe.IN);
        Card journeyLeg1Completed = oysterCardApp.endJourney(oysterCardAfterJourneyLeg1);
        Assert.assertEquals(26.8f, journeyLeg1Completed.getBalance(), 0);
    }


}
