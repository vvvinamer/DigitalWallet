package coding.wallet;

import coding.wallet.impl.offers.Offer1;
import coding.wallet.impl.offers.Offer2;
import coding.wallet.models.Account;
import coding.wallet.models.OFFER_TYPE;

import java.util.Map;

public class OfferConfig {

    //TODO: Will be like singleton bean.
    private static Map<OFFER_TYPE, TransactionalOffer> transactionalOfferMap;
    private static Map<OFFER_TYPE, NonTransactionalOffer> nonTransactionalOfferMap;

    public static void initOfferConfig(Map<String, Account> accounts) {
        NonTransactionalOffer offer2 = new Offer2(accounts);
        nonTransactionalOfferMap = Map.of(offer2.offerName(), offer2);

        TransactionalOffer offer1 = new Offer1(accounts);
        transactionalOfferMap = Map.of(offer1.offerName(), offer1);
    }

    public static Map<OFFER_TYPE, TransactionalOffer> getTransactionalOfferMap() {
        return transactionalOfferMap;
    }

    public static Map<OFFER_TYPE, NonTransactionalOffer> getNonTransactionalOfferMap() {
        return nonTransactionalOfferMap;
    }
}
