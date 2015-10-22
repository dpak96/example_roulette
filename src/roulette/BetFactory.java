package roulette;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	
	public Bet getBet(String type){
		if(type.equals("Red or Black")) return new RedBlack("Red or Black", 1);
		if(type.equals("Odd or Even")) return new OddEven("Odd or Even", 1);
        if(type.equals("Three in a Row")) return new ThreeConsecutive("Three in a Row", 11);
        return null;
	}

	
}
