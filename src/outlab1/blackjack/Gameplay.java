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
import java.util.Random;  //import java.random


public class Gameplay 
{
	Card[] deck = new Card[52];          
	Boolean[] used = new Boolean[52];  //array used to avoid duplicate card pulls
	Random rand = new Random(); // used to generate a random card draw method
        Player p1 = new Player();
       // Player p2 = new Player();   //would have been used for multiple players
       // Player p3 = new Player();
       // Player p4 = new Player();
        Player dealer = new Player(); //dealer is an instance of the player class
	int randCard; //Used to draw a random card from the deck of cards
					
	private void generateDeck()   //Generates the deck of cards
        { 
		for (int x = 0; x < 13; x++) {
			deck[x] = new Card(x + 2, "Hearts");
		}
		for (int x = 13; x < 26; x++) {
			deck[x] = new Card((x - 11), "Diamonds");
		}
		for (int x = 26; x < 39; x++) {
			deck[x] = new Card((x - 24), "Clubs");
		}
		for (int x = 39; x < 52; x++) {
			deck[x] = new Card((x - 37), "Spades");
		}
                for (int i = 0; i < 52; i++)
                {
                    used[i] = false;      //set all values in the used array to false
                }
	}

	private int deal()
        {
           
		randCard = rand.nextInt(52);  //random number
                boolean checkDupe;   
                checkDupe = true;
                while (checkDupe = true)   //while to keep generating random numbers until
                {                          //a card that hasn't been pulled comes up
                checkDupe = false;
                
                if(used[randCard] == false)
                {
                    used[randCard] = true;  
                }
                else
                {
                     randCard = rand.nextInt(52);
                     checkDupe = true;
                     break;
                } 
               
                }
		
		System.out.print("Player has been dealt the ");
		switch (deck[randCard].getValue()) { //Switch used to print out the correct card title
		case 11:
			System.out.print("Jack");
			break;
		case 12:
			System.out.print("Queen");
			break;
		case 13:
			System.out.print("King");
			break;
		case 14:
			System.out.print("Ace");
			break;
		default:
			System.out.print(deck[randCard].getValue());
		}
		System.out.println(" of " + deck[randCard].getSuit());
                return (deck[randCard].getValue());   //return the cards numerical value
           
                

             
	}


	public void play()
        {
                
                while(p1.outMoney() == false)  //If player one is not out of money, go in while
                {
                if(p1.outMoney() == true)    //do nothing
                {
                 
                }
                else if (p1.getQuit() == true)   //if the user wants to quit, end while loop
                    {
                        System.out.println("See you next time!!");
                        break;
                    }
                    
                    else      //if the user wants to play
                    {
                        generateDeck();   
                        System.out.print("Player 1 ");
                        p1.getBet();      //calls method where user inputs their bet
                        
                        p1.handTotal(deal());     //deals 3 cards to player1, and adds their values
                        p1.handTotal(deal());
                        p1.handTotal(deal());
                        
                        System.out.println("Dealer drawing...");
                        
                        dealer.handTotal(deal());       //dealer pulls and shows their card
                        
                        System.out.println(" ");
                        System.out.println("Total = " + p1.handTotal(0));   //print out total of player1's cards
                        System.out.println("Dealer Total = " + dealer.handTotal(0)); //print out dealers total
                        
                        boolean inLoop = true;
                        
                        while(inLoop)   //while used so player can keep hitting
                        {
                            inLoop = false;
                            if(p1.getStand() == false)    //calls getStand(), to see if player wants to hit
                            {
                                p1.handTotal(deal());     //deals card
                                System.out.println(" ");
                                System.out.println("Total = " + p1.handTotal(0));  //prints out new total
                                inLoop = true;
                                if(p1.handTotal(0) > 31)    //if player breaks, end the game
                                {
                                    System.out.println("You went over 31!");
                                    p1.getWin(2);       //2 denotes a loss, 1 denotes a win, these ints are used in player class
                                    dealer.getWin(1);
                                    p1.outMoney();      //checks players money
                                    p1.calcMoney();     //calculates balance
                                    inLoop = false;
                                    if(p1.outMoney() == true)    //if player runs out of money, end the game
                                    {
                                        System.out.println("Game over!! Don't go to Vegas!");
                                        break;
                                    }
                                    
                                }
                                System.out.println(" ");
                            }
                            else
                            {
                                break;
                            }
                            
                        }
                        
                        boolean inside = true;
                        
                        while(inside)  //while loop used for dealer's auto plau, stands at values >= 27
                        {
                            inside = false;
                            if(p1.handTotal(0) == 0) //if player1 breaks, no need for dealer to play, end game
                            {
                                break;
                            }
                            if (dealer.handTotal(0) < 27)  //draw if under 27
                            {
                                System.out.println("Dealer drawing...");
                                dealer.handTotal(deal());
                                
                                System.out.println("Dealer Total = " + dealer.handTotal(0)); //show new total
                                System.out.println(" ");
                                inside = true;
                            }
                            else if(dealer.handTotal(0) > 31) //if the dealer breaks, player 1 wins
                            {
                                System.out.println("Dealer breaks!!! You win!");
                                p1.getWin(1);
                                dealer.getWin(2);
                                p1.calcMoney();
                            }
                            else
                            {
                                System.out.println("Dealer is standing"); //dealer stops, then     
                            }
                            
                        }
                        if (dealer.handTotal(0) > p1.handTotal(0) && dealer.handTotal(0) < 32) //if dealer 1 wins
                        {
                            System.out.println("You lose!");
                            p1.getWin(2);
                            dealer.getWin(1);
                            p1.outMoney();
                            p1.calcMoney();
                            if( p1.outMoney() == true) //if the players bet brought them to 0, end program
                            {
                                System.out.println("Game over!! Don't go to Vegas!");
                                break;
                            }
                            
                        }
                        else if(dealer.handTotal(0) < p1.handTotal(0) && p1.handTotal(0) < 32) //if player1 wins
                        {
                            System.out.println("You win!");
                            p1.getWin(1);
                            dealer.getWin(2);
                            p1.calcMoney();  
                        }
                        else if(dealer.handTotal(0) == p1.handTotal(0)) //if its a tie, pass 3 to getWin(), it represents a tie, and the players money won't change
                        {
                            p1.getWin(3);
                            dealer.getWin(3);
                            p1.calcMoney();
                        }
                    }
                }
 
}
}
