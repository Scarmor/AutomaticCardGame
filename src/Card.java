public class Card {
    private String cardName;
    private int cardValue;

    public Card(CardName cardName){
        setCardName(cardName);
        setCardValue(cardName);
    }

    public void setCardName(CardName cardName) {
        switch (cardName){
            case SIX -> this.cardName = "�����";
            case SEVEN -> this.cardName = "����";
            case EIGHT -> this.cardName = "������";
            case NINE -> this.cardName = "������";
            case TEN -> this.cardName = "������";
            case JACK -> this.cardName = "�����";
            case QUEEN -> this.cardName = "����";
            case KING -> this.cardName = "������";
            case ACE -> this.cardName = "���";
        }
    }

    public void setCardValue(CardName cardName) {
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
