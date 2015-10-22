package roulette;

import roulette.Wheel.SpinResult;
import util.ConsoleReader;

public class ConsecutiveBet extends Bet{
	
	public ConsecutiveBet(){
		super("Three in a Row", 11);
	}

	@Override
	public boolean checkWin(Wheel myWheel, String betChoice){
        int start = Integer.parseInt(betChoice);
        return (start <= myWheel.getNumber() && myWheel.getNumber() < start + 3);
	}
	
	@Override
	public String makeBet(){
		return "" + ConsoleReader.promptRange("Enter first of three consecutive numbers",
                1, Wheel.NUM_SPOTS - 3);
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
