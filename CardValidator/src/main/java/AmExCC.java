// package model;

public class AmExCC extends CreditCard {
    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        System.out.println(cardNumber.charAt(1));
        // Implement American Express-specific validation logic
        // American Express cards First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        return (cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15;
    }
}
