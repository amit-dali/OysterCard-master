package helpers;

import objectmodel.Card;

public enum CardHelper {
    INSTANCE;

    public Card topUpOysterCard(Card oysterCard) {
        final String CURRENT_METHOD = "topUpOysterCard=";
        System.out.println(CURRENT_METHOD + "input=" + oysterCard);
        oysterCard.setBalance(PropertyHelper.INSTANCE.getTopUpAmout());
        System.out.println(CURRENT_METHOD + "output=" + oysterCard);
        return oysterCard;
    }

}
