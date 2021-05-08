/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab1.blackjack;

/**
 *
 * @author Michael Valentino-Manno
 */
public class Card {

    private String suit;   //instance variables
    private int value;

    public Card(int inValue, String inSuit) //constructor
    {
        suit = inSuit;
        value = inValue;
    }

    public String getSuit() //getSuit method
    {
        return suit;
    }

    public int getValue() //getValue method that returns the numerical of the card
    {
        if (value < 10) {
            return value;
        } else if (value > 10 && value != 14) {
            value = 10;
        }

        return value;
    }

}
