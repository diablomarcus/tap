package net.katerberg.hello;

import java.util.Random;

import android.test.AndroidTestCase;

public class DiceTest extends AndroidTestCase{

	public void testRollD_Does(){

		Integer maxVal = 100;
		for(int i=1; i<10000; i++){ //This test is terrible.
			Integer returnValue = Dice.rollD(new Random().nextInt(maxVal)+1);
		
			assertNotNull(returnValue);
			assertTrue(returnValue<=maxVal);
		}
		
	}
	
	public void testRollD_Handles_Null(){

		Integer returnValue = Dice.rollD(null);
		
		assertNull(returnValue);
		
		
	}

}
