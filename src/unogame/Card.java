/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unogame;

/**
 *
 * @author hetulpatel
 */
public class Card {
    private final String color;
    private final String value;

  
    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public boolean matches(Card otherCard) {
        return color.equals(otherCard.getColor()) || value.equals(otherCard.getValue());
    }
    
}
