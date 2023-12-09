package model;

public abstract class CreditCard {
    protected String cardNumber;
    protected String expirationDate;
    protected String cardHolderName;

    public CreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
    }

    // Abstract method to validate card number
    public abstract boolean isValid();
}
