// package model;

public class DiscoverCC extends CreditCard {
    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Implement Master-specific validation logic
        // Master cards First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.
        return cardNumber.startsWith("6011") && cardNumber.length() == 16;
    }
}
