package model;

public class AmExCC extends CreditCard {
    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Implement American Express-specific validation logic
        // American Express cards First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        return cardNumber.startsWith("3") && (cardNumber.charAt(1) == 4 || cardNumber.charAt(1) == 7) && cardNumber.length() == 15;
    }
}
