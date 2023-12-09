import java.util.List;

public class CardRecordsOutput {
    private List<CardRecordOutput> cards;

    public CardRecordsOutput(List<CardRecordOutput> cards) {
        this.cards = cards;
    }

    // Getters
    public List<CardRecordOutput> getCards() {
        return cards;
    }

    // Setters
    public void setCards(List<CardRecordOutput> cards) {
        this.cards = cards;
    }
}

