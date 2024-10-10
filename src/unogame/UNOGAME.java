/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unogame;

/**
 *
 * @author hetulpatel
 */
//date:10/10/2024
// #Team
public class UNOGAME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UNOGAME game = new UNOGAME();
        game.PlayGame();
    }

    public void PlayGame() {
        CARDDECK CARDDECK = new CARDDECK();
        CARDDECK.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        for (int i = 0; i < 7; i++) {
            player1.drawCard(CARDDECK);
            player2.drawCard(CARDDECK);
        }

        System.out.println(player1.getName() + " Hand: " + player1.getHand());
        System.out.println(player2.getName() + " Hand: " + player2.getHand());

        Player RecentPlayer = player1;
        Card RecentCard = CARDDECK.drawCard(); 
        System.out.println("First card on the bunch of cards: " + RecentCard);
        while (!isWinner(player1) && !isWinner(player2)) {
            System.out.println(RecentPlayer.getName() + "'s turn");
            System.out.println("Current card on the pile: " + RecentCard);
            System.out.println(RecentPlayer.getName() + "'s hand: " + RecentPlayer.getHand());

            if (CanPlay(RecentPlayer, RecentCard)) {
                Card playedCard = RecentPlayer.playCard(RecentCard);
                System.out.println(RecentPlayer.getName() + " plays: " + playedCard);
                RecentCard = playedCard;
            } else {
                System.out.println(RecentPlayer.getName() + " Draws a card.");
                RecentPlayer.drawCard(CARDDECK);
            }

            RecentPlayer = (RecentPlayer == player1) ? player2 : player1;
        }

        System.out.println("Game over! " + (isWinner(player1) ? player1.getName() : player2.getName()) + " Wins!");
    }

    private boolean CanPlay(Player player, Card currentCard) {
        for (Card card : player.getHand()) {
            if (card.matches(currentCard)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinner(Player player) {
        return player.getHand().isEmpty();
    }
    
}
