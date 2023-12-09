public class CardValidationUtil {

    public static String getCardTypeAndValidity(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return "Invalid: empty/null card number";
        }

        if (!cardNumber.matches("\\d+")) {
            return "Invalid: non numeric characters";
        }

        if (cardNumber.length() > 19) {
            return "Invalid: more than 19 digits";
        }

        CreditCard card = CreditCardFactory.getCreditCard(cardNumber, "", "");

        if (card == null) {
            return "Invalid: Not a possible card number";
        }

        boolean isValid = card.isValid();
        return isValid ? getCardType(card) : "Invalid: Not a possible card number";
    }

    public static String getCardType(CreditCard card) {
        if (card instanceof VisaCC) {
            return "Visa";
        } else if (card instanceof MasterCC) {
            return "MasterCard";
        } else if (card instanceof AmExCC) {
            return "AmericanExpress";
        } else if (card instanceof DiscoverCC) {
            return "Discover";
        }
        return "Unknown";
    }
}
