import java.util.List;

public class CardRecords {
    private List<CardRecord> cards;

    public List<CardRecord> getCards() {
        return cards;
    }

    public void setCards(List<CardRecord> cards) {
        this.cards = cards;
    }

    public static class CardRecord {
        private String cardNumber;
        private String expirationDate;
        private String cardHolderName;

        // Standard getters and setters
        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }

        public String getCardHolderName() {
            return cardHolderName;
        }

        public void setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
        }
    }
}

