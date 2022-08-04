import java.time.LocalTime;

public class Game {
    public static boolean isDraw = false;

    public static void main(String[] args) throws InterruptedException{
        LocalTime start = LocalTime.now();
        Table table = Table.getInstance();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        CardDeck cardDeck = new CardDeck();
        cardDeck.createCardDeck();
        int order = (int) (Math.random() * 2) + 1;
        System.out.println("���������� ������, ������� ����� ������ ������");
        Thread.sleep(1000);
        System.out.println("�� ����� ����� #" + order);
        Thread.sleep(1000);
        System.out.println("����� #" + order + " �������������� ������ � ������� �����");
        cardDeck.mix();
        cardDeck.dealCards(player1, player2);
        Thread.sleep(1000);

        try {
            while (true){
                System.out.println("\n������ ����");
                Thread.sleep(1000);

                if (isDraw){
                    System.out.println("������ ������ ����� ���������");
                    table.putCard(player1.getCard(isDraw));
                    table.putCard(player2.getCard(isDraw));
                    Thread.sleep(1000);
                    isDraw = false;
                }
                else{
                    if (order == 1){
                        System.out.println("����������� ���� ��������� � ������ #1");
                        Thread.sleep(1000);
                        table.putCard(player1.getCard(isDraw));
                        order = 2;
                    }
                    else {
                        System.out.println("����������� ���� ��������� � ������ #2");
                        Thread.sleep(1000);
                        table.putCard(player2.getCard(isDraw));
                        order = 1;
                    }
                    checkWinner(table, player1, player2);
                }
            }
        }
        catch (GameIsOutException gameIsOutException){
            LocalTime finish = LocalTime.now();
            LocalTime gameIsGone = LocalTime.of(finish.minusHours(start.getHour()).getHour(), finish.minusMinutes(start.getMinute()).getMinute(), finish.minusSeconds(start.getSecond()).getSecond());
            System.out.println("���� ���������!");
            Thread.sleep(1000);
            if (player1.cardDeckIsEmpty()){
                System.out.println("������� ����� #2");
            }
            else {
                System.out.println("������� ����� #1");
            }
            Thread.sleep(1000);
            System.out.println("���� ����������: " + gameIsGone.getHour() + " ���(����/�����), " + gameIsGone.getMinute() + " �����, " + gameIsGone.getSecond() + " ������");
        }
    }

    public static void checkWinner(Table table, Player player1, Player player2) throws InterruptedException {
        if (table.getCountCardsOnTheTable() % 2 == 0 && table.getCountCardsOnTheTable() != 0){
            Thread.sleep(1000);
            System.out.println("\n�������� �� �������");
            Thread.sleep(1000);
            if (player1.getLastCardValue() == 6 && player2.getLastCardValue() == 14){
                table.giveCardsToWinner(player1);
                System.out.println("�������� ���� ����");
                Thread.sleep(1000);
                System.out.println("�������� ����� #1");
            }
            else if (player2.getLastCardValue() == 6 && player1.getLastCardValue() == 14){
                table.giveCardsToWinner(player2);
                System.out.println("�������� ���� ����");
                Thread.sleep(1000);
                System.out.println("�������� ����� #2");
            }
            else if (player1.getLastCardValue() > player2.getLastCardValue()){
                table.giveCardsToWinner(player1);
                System.out.println(player1.getLastCardName() + " ������, ��� " + player2.getLastCardName());
                Thread.sleep(1000);
                System.out.println("�������� ����� #1");

            }
            else if (player1.getLastCardValue() < player2.getLastCardValue()){
                table.giveCardsToWinner(player2);
                System.out.println(player1.getLastCardName() + " ������, ��� " + player2.getLastCardName());
                Thread.sleep(1000);
                System.out.println("�������� ����� #2");
            }
            else{
                System.out.println("�����");
                isDraw = true;
                return;
            }
            System.out.println("� ������ #1 " + player1.getCountCards() + " ����");
            System.out.println("� ������ #2 " + player2.getCountCards() + " ����");
        }
    }
}
