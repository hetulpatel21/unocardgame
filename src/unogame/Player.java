/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unogame;

/**
 *
 * @author hetulpatel
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Player {
    
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(CARDDECK deck) {
        hand.add(deck.drawCard());
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public Card playCard(Card currentCard) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the card you want to play (0 to " + (hand.size() - 1) + "): ");
        int index = scanner.nextInt();

        while (index < 0 || index >= hand.size() || !hand.get(index).matches(currentCard)) {
            System.out.println("Wrong choice. Try again.");
            index = scanner.nextInt();
        }

        return hand.remove(index);
    }
    
}
