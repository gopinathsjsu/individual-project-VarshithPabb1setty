public class CardRecordOutput {
    private String cardNumber;
    private String cardType;
    // private boolean isValid;

    public CardRecordOutput(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        // this.isValid = isValid;
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    // public boolean isValid() {
    //     return isValid;
    // }

    // Setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    // public void setValid(boolean valid) {
    //     isValid = valid;
    // }
}

