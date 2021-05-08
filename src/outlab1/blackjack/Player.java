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
import java.util.Scanner; //allows for user imput

public class Player {

    int money = 500;   //players starting money
    int total = 0;     //players starting card total
    int monBet = 0;    //money bet
    int won = 0;       //gets incramented for player win, lose, tie
    int lose = 0;
    int tie = 0;
    //boolean aceFlag = false;  //couldn't figure out a good way to do it.
    Scanner in = new Scanner(System.in);  //new scanner for user input

    public int handTotal(int num) //method that calculates a players total in their hand
    {
        if (won > 0) //if a game was complete, reset the hand back to 0
        {
            total = 0;
            lose = 0;
            won = 0;
        } else if (lose > 0) //if a game was complete, reset the hand back to 0
        {
            total = 0;
            won = 0;
            lose = 0;
        } else if (tie > 0) //if a game was complete, reset the hand back to 0
        {
            total = 0;
            total = 0;
            tie = 0;
        }

        if (num == 14) //if an ace was drawn prompt the user for their desired value
        {
            System.out.println("Would you like your ace to be worth '1' or '11'?");
            int worth = in.nextInt();
            boolean valid = false;
            while (valid == false) {
                valid = true;
            }
            if (worth == 1) {
                //aceFlag = true;
                num = 1;

            } else if (worth == 11) {
                //aceFlag = true;
                num = 11;
                if ((total + num) > 31) {
                    num = 1;
                }
            } else {
                System.out.println("Enter a valid response"); //if an invalid word was typed, prompt user for new word
                worth = in.nextInt();
                valid = false;
            }
        }
        if (num > 10 && num != 11) //face cards are worth 10
        {
            num = 10;
        }

        total += num;

        return total;

    }

    public boolean getQuit() //Method to find if the player wants to quit
    {
        System.out.println("Type 'play' or 'quit'");
        String play = in.nextLine();
        boolean valid = false;
        boolean quit = false;
        while (valid == false) {
            valid = true;

            if (play.equals("play")) {
                quit = false;

            } else if (play.equals("quit")) {
                quit = true;
            } else {
                System.out.println("Type in a valid word");
                play = in.nextLine();
                valid = false;
            }
        }
        return quit;
    }

    public boolean getStand() //method to find if user wants to hit or stand
    {
        System.out.println("'hit' or 'stand'");
        String hit = in.nextLine();
        boolean stand = false;
        boolean valid = false;
        while (valid == false) {
            valid = true;
            if (hit.equals("hit")) {
                stand = false;
            } else if (hit.equals("stand")) {
                stand = true;
            } else {
                System.out.println(" type in a valid word");
                valid = false;
                hit = in.nextLine();
            }
        }
        return stand;
    }

    public int calcMoney() //Method that calculates the users money after a game is completed
    {
        if (won > 0) //if player won 
        {
            money += monBet;
        } else if (lose > 0) //if player lost
        {
            money -= monBet;
        } else if (tie > 0) //if player tied
        {

        }

        if (money == 0) {
            outMoney();  //if money is = 0, the player is out of money
        }
        System.out.println("You currently have: $" + money);
        return money;
    }

    public int getBet() //method that gets the amount the user would like to bet
    {
        System.out.println("Enter your bet");
        int bet = in.nextInt();
        boolean valid = false;
        while (valid == false) {
            valid = true;
            if (bet <= money && bet > 0) //they have to have enough to afford the bet
            {

            } else //if not, prompt for a valid amount
            {
                System.out.println("Enter a valid bet");
                valid = false;
                bet = in.nextInt();
            }
        }
        monBet = bet;
        return monBet;
    }

    public boolean getWin(int i) //method that uses ints to represent wins, loses, and ties
    {
        if (i == 1) {
            won++;
            return true;
        } else if (i == 2) {
            lose++;
            return false;
        } else {
            tie++;
            return true;
        }
    }

    public boolean outMoney() //method to say if user is out of money
    {
        if (money == 0) {
            return true;
        } else {
            return false;
        }
    }
}

/* public boolean getAceFlag()  //couldn't get ace working 100%
 {
     return aceFlag;
 }
 
}*/
