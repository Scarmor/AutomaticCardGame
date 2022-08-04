import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CardDeck {
    public Deque<Card> deque = new ArrayDeque<>();

    public CardDeck(){

    }

    public void createCardDeck(){
        for (CardName cardName : CardName.values()){
            for (int i = 0; i < 4; i++){
                deque.add(new Card(cardName));
            }
        }
    }

    public void dealCards(Player p1, Player p2){
        for (int i = 0; !deque.isEmpty(); i++){
            if (i % 2 == 0){
                p2.addCardToDeck(deque.pollFirst());
            }
            else {
                p1.addCardToDeck(deque.pollFirst());
            }
        }
    }

    public void mix(){
        ArrayList<Card> newDeck = new ArrayList<>();
        for (int n = 0; !deque.isEmpty(); n++){
            if (n % 2 == 0){
                newDeck.add(deque.pollFirst());
            }
            else {
                newDeck.add(deque.pollLast());
            }
        }
        for (int i = 0; i < 36; i++){
            int randomIndex = (int) (Math.random() * ((newDeck.size() - 1) + 1));
            deque.add(newDeck.get(randomIndex));
            newDeck.remove(randomIndex);
        }
    }


    @Override
    public String toString() {
        return "Колода содержит:" +
                "\n" + deque +
                "\n";
    }
}
