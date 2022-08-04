import java.util.ArrayList;

public class Player {
    private CardDeck cardDeck;
    private int id;
    private Card lastCard;

    public Player(int id) throws InterruptedException {
        cardDeck = new CardDeck();
        this.id = id;
        System.out.printf("Игрок #%d садится за стол\n", id);
        Thread.sleep(1000);
    }

    public Card getCard(Boolean isDraw) throws InterruptedException {
        Card card = cardDeck.deque.poll();
        if (isDraw){
            System.out.println("Игрок #" + id + " берет неизвестную карту из колоды");
            Thread.sleep(1000);
            lastCard = card;
            return lastCard;
        }
        if (card != null){
            System.out.println("Игрок #" + id + " берет карту " + card + " из колоды");
            Thread.sleep(1000);
            lastCard = card;
        }
        else {
            System.out.printf("У игрока #%d не осталось карт в колоде\n", id);
            Thread.sleep(1000);
            System.out.printf("Игрок #%d проиграл\n", id);
            Thread.sleep(1000);
            throw new GameIsOutException();
        }
        return lastCard;
    }

    public int getLastCardValue(){
        return lastCard.getCardValue();
    }

    public Card getLastCardName(){
        return lastCard;
    }

    public void getCardsAfterWin(ArrayList<Card> cards){
        for (Card card : cards){
            cardDeck.deque.offerLast(card);
        }
    }

    public void addCardToDeck(Card card){
        cardDeck.deque.offerFirst(card);
    }

    public boolean cardDeckIsEmpty(){
        return cardDeck.deque.isEmpty();
    }

    public int getCountCards(){
        return cardDeck.deque.size();
    }
}
