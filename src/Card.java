public class Card {
    private String cardName;
    private int cardValue;

    public Card(CardName cardName){
        setCardName(cardName);
        setCardValue(cardName);
    }

    private void setCardName(CardName cardName) {
        switch (cardName){
            case SIX -> this.cardName = "Шесть";
            case SEVEN -> this.cardName = "Семь";
            case EIGHT -> this.cardName = "Восемь";
            case NINE -> this.cardName = "Девять";
            case TEN -> this.cardName = "Десять";
            case JACK -> this.cardName = "Валет";
            case QUEEN -> this.cardName = "Дама";
            case KING -> this.cardName = "Король";
            case ACE -> this.cardName = "Туз";
        }
    }

    private void setCardValue(CardName cardName) {
        switch (cardName){
            case SIX -> this.cardValue = 6;
            case SEVEN -> this.cardValue = 7;
            case EIGHT -> this.cardValue = 8;
            case NINE -> this.cardValue = 9;
            case TEN -> this.cardValue = 10;
            case JACK -> this.cardValue = 11;
            case QUEEN -> this.cardValue = 12;
            case KING -> this.cardValue = 13;
            case ACE -> this.cardValue = 14;
        }
    }


    public int getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return cardName;
    }
}
