public class MasterCC extends CreditCard {
    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Master cards First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.
        return cardNumber.startsWith("5") && "12345".contains(cardNumber.substring(1, 2)) && cardNumber.length() == 16;
    }
}

