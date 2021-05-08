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
public class Outlab1BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gameplay game = new Gameplay();  //Create instance of gameplay
        game.play();      //one method that plays for one player and the dealer
    }
}
