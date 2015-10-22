package roulette;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";

    // add new bet subclasses here
    private String[] myPossibleBets = {
    		"RedBlack",
    		"OddEven",
    		"ThreeConsecutive",
    };
    
    private String propertiesName = "description.properties";
    
    protected Properties descriptions = new Properties();
    
    private BetFactory myFactory = new BetFactory();
    private Wheel myWheel;

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
        InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesName);
        try {
			descriptions.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * @return name of the game
     */
    public String getName () {
        return DEFAULT_NAME;
    }

    /**
     * Play a round of roulette.
     *
     * Prompt player to make a bet, then spin the roulette wheel, and then verify 
     * that the bet is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player) {
        int amount = ConsoleReader.promptRange("How much do you want to bet",
                                               0, player.getBankroll());
        Bet b = promptForBet();
        b.place();

        System.out.print("Spinning ...");
        Wheel.SpinResult spinResult = myWheel.spin();
        System.out.println(String.format("Dropped into %s", spinResult));
        if (b.isMade(spinResult)) {
            System.out.println("*** Congratulations :) You win ***");
            amount = b.payout(amount);
        }
        else {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
    }

    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {

            System.out.println(String.format("%d) %s", (k + 1), descriptions.getProperty(myPossibleBets[k]).split(",")[0]));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
        return myFactory.getBet(myPossibleBets[response-1]);
    }
}
