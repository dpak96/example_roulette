package roulette;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	
	Properties descriptions = new Properties();
	String propertiesName = "description.properties";
	
	public BetFactory(){
        InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesName);
        try {
			descriptions.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Bet getBet(String type){
        Class<?> c = null;
		try {
			c = Class.forName("roulette.bets." + type);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Bet b = null;
        Constructor<?> cons[] = c.getConstructors();
        String des[] = descriptions.getProperty(type).split(",");
        
        try {
			b = (Bet) cons[0].newInstance(des[0], Integer.parseInt(des[1]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return b;
	}

	
}
