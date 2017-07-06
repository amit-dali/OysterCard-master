import constants.JourneyStatus;
import constants.JourneyType;
import constants.Swipe;
import objectmodel.Card;
import objectmodel.Journey;

public enum TestHelper {

    INSTANCE;

    public Card formOysterCard(String oysterCardNumber, String startingPoint, JourneyType journeyType, JourneyStatus journeyStatus) {
        Card oysterCard = new Card();
        oysterCard.setId(oysterCardNumber);
        Journey journey = new Journey();
        journey.setSource(startingPoint);
        journey.setJourneyType(journeyType);
        journey.setSwipe(Swipe.IN);
        journey.setJourneyStatus(journeyStatus);
        oysterCard.setJourney(journey);
        return oysterCard;
    }

    public Card updateOysterCard(Card oysterCard, String destination) {
        oysterCard.getJourney().setDestination(destination);
        oysterCard.getJourney().setSwipe(Swipe.OUT);
        return oysterCard;
    }

}
