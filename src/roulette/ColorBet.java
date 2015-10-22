package roulette;

import roulette.Wheel.SpinResult;
import util.ConsoleReader;

public class ColorBet extends Bet{

	public ColorBet(){
		super("Red or Black", 1);
	}

	@Override
	public boolean checkWin(Wheel myWheel, String betChoice){
		 return myWheel.getColor().equals(betChoice);
	}
	
	@Override
	public String makeBet(){
		return ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
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
