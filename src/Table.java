import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Table {
    private static Table instance;
    ArrayList<Card> cardsOnTheTable = new ArrayList<>();

    public static Table getInstance() throws InterruptedException {
        if (instance == null){
            instance = new Table();
            System.out.println("Стол успешно создан");
            Thread.sleep(1000);
        }
        return instance;
    }

    public void putCard(Card card) throws InterruptedException {
        cardsOnTheTable.add(card);
        System.out.println("И кладет её на стол");
    }

    public int getCountCardsOnTheTable(){
        return cardsOnTheTable.size();
    }

    public void giveCardsToWinner(Player player){
        player.getCardsAfterWin(cardsOnTheTable);
        cardsOnTheTable.clear();

    }


}
