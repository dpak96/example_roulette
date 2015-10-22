package roulette;

import roulette.Wheel.SpinResult;
import util.ConsoleReader;

public class ParityBet extends Bet{
	
	public ParityBet(){
		super("Odd or Even", 1);
	}

	@Override
	public boolean checkWin(Wheel myWheel, String betChoice){
        return (myWheel.getNumber() % 2 == 0 && betChoice.equals("even")) ||
                (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
	}
	
	@Override
	public String makeBet(){
		return ConsoleReader.promptOneOf("Please bet", "even", "odd");
	}

	@Override
	public void place() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMade(SpinResult spinResult) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
