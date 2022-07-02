import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Table {
    private static Table instance;
    ArrayList<Card> cardsOnTheTable = new ArrayList<>();

    public static Table getInstance() throws InterruptedException {
        if (instance == null){
            instance = new Table();
            System.out.println("���� ������� ������");
            Thread.sleep(1000);
        }
        return instance;
    }

    public void putCard(Card card) throws InterruptedException {
        cardsOnTheTable.add(card);
        System.out.println("� ������ � �� ����");
    }

    public int getCountCardsOnTheTable(){
        return cardsOnTheTable.size();
    }

    public void giveCardsToWinner(Player player){
        player.getCardsAfterWin(cardsOnTheTable);
        cardsOnTheTable.clear();

    }


}
