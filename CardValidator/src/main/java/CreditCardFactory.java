public class CreditCardFactory {
    public static CreditCard getCreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        if (cardNumber.startsWith("5") && "12345".contains(cardNumber.substring(1, 2)) && cardNumber.length() == 16) {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
        } else if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15) {
            return new AmExCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("6011") && cardNumber.length() == 16) {
            return new DiscoverCC(cardNumber, expirationDate, cardHolderName);
        }
        // Add other card types as needed
        return null; // or throw an exception for unknown card types
    }
}