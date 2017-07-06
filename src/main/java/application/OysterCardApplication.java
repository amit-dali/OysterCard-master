package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import constants.JourneyStatus;
import constants.Swipe;
import exceptions.ApplicationException;
import helpers.CardBalance;
import helpers.PropertyHelper;
import json.object.builder.FareBuilder;
import json.object.builder.StationBuilder;
import objectmodel.Card;
import objectmodel.Journey;

public class OysterCardApplication {

    private final ArrayList<Card> listOfAllJourneys = new ArrayList<>();

    /**
     * @param oysterCard
     * @return
     * @throws ApplicationException
     */
    public Card startJourney(Card oysterCard) throws ApplicationException {
        final String CURRENT_METHOD = "startJourney=";
        System.out.println(CURRENT_METHOD + "input=" + oysterCard);
        Optional<Card> cardFromList = findCard(oysterCard.getId());
        updateBalanceIfCardPresent(cardFromList, oysterCard);
        if (checkOysterCardBalance(oysterCard.getBalance())) {
            persistJourney(oysterCard);
        }
        System.out.println(CURRENT_METHOD + "output=" + oysterCard);
        return oysterCard;
    }

    private void persistJourney(Card oysterCard) throws ApplicationException {
        final String CURRENT_METHOD = "persistJourney=";
        System.out.println(CURRENT_METHOD + "input=" + oysterCard);
        switch (oysterCard.getJourney().getJourneyType()) {
        case TUBE:
            listOfAllJourneys.add(oysterCard);
            break;
        case BUS:
            listOfAllJourneys.add(oysterCard);
            break;
        default:
            throw new ApplicationException("Error: No journey type specified");
        }
        System.out.println(CURRENT_METHOD + "persisted card");
    }

    private void updateBalanceIfCardPresent(Optional<Card> card, Card oysterCard) {
        final String CURRENT_METHOD = "updateBalanceIfCardPresent=";
        System.out.println(CURRENT_METHOD + "card-" + card + ",oysterCard-" + oysterCard);
        if (card.isPresent()) {
            oysterCard.setBalance(card.get().getBalance());
            System.out.println(CURRENT_METHOD + ",oysterCard-" + oysterCard);
        }
    }

    private Optional<Card> findCard(String cardId) {
        return listOfAllJourneys.stream().filter(card -> card.getId().equals(cardId)).findFirst();
    }

    private boolean checkOysterCardBalance(float balance) {
        CardBalance cardBalance = (amout -> {
            return amout > PropertyHelper.INSTANCE.getMaxFair();
        });
        return cardBalance.checkCardBalance(balance);
    }

    /**
     * @param oysterCardAfterJourneyLeg1
     * @return
     * @throws ApplicationException
     */
    public Card endJourney(Card oysterCardAfterJourneyLeg1) throws ApplicationException {
        Optional<Card> cardFound = findCard(oysterCardAfterJourneyLeg1.getId());
        persistJourney(cardFound.get());
        return calculateJourneyFare(cardFound.get());
    }

    private Card calculateJourneyFare(Card oysterCard) throws ApplicationException {
        Optional<Swipe> swipe = Optional.ofNullable(oysterCard.getJourney().getSwipe());
        if (swipe.isPresent()) {
            calculateActualFare(oysterCard);
        }
        return oysterCard;
    }

    private void calculateActualFare(Card oysterCard) throws ApplicationException {
        if (Swipe.IN.equals(oysterCard.getJourney().getSwipe())) {
            oysterCard.setBalance(oysterCard.getBalance() - PropertyHelper.INSTANCE.getMaxFair());
        } else {
            oysterCard.setBalance(oysterCard.getBalance() - calculateTravelled(oysterCard.getJourney()));
        }
        oysterCard.getJourney().setJourneyStatus(JourneyStatus.FINISHED);
    }

    private float calculateTravelled(Journey journey) throws ApplicationException {
        int[] zones = Arrays.stream(getZonesTravelled(journey)).mapToInt(Integer::intValue).toArray();
        return Stream.of(FareBuilder.INSTANCE.build())
                .filter(fare -> journey.getJourneyType().equals(fare.getJourneyType()) && Arrays.equals(fare.getJourneyZones(), zones))
                .map(fare -> fare.getFare()).findFirst().get();
    }

    private Integer[] getZonesTravelled(Journey journey) throws ApplicationException {
        List<int[]> zones = Stream.of(StationBuilder.INSTANCE.build()).filter(
                jrny -> jrny.getName().equalsIgnoreCase(journey.getSource()) || jrny.getName().equalsIgnoreCase(journey.getDestination()))
                .map(jrny -> jrny.getZones()).collect(Collectors.toList());
        ArrayList<Integer> temp = new ArrayList<>();
        zones.forEach(zns -> {
            for (int zone : zns) {
                temp.add(zone);
            }
        });
        Collections.sort(temp);
        Integer[] zonesArr = new Integer[temp.size()];
        return temp.toArray(zonesArr);
    }

    /**
     * 
     */
    public void printBill() {
        listOfAllJourneys.forEach(System.out::println);
    }
}
