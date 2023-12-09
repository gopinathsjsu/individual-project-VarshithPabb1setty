// package model;

public class VisaCC extends CreditCard {
    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Implement Visa-specific validation logic
        // Visa cards start with 4 and are 13 or 16 digits long
        return cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16);
    }
}

