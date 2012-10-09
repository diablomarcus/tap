package net.katerberg.hello;

import java.util.Random;

import android.test.AndroidTestCase;

public class InputTest extends AndroidTestCase{
	
	Input test;

	public void setup(){
		test = new Input();
	}
	
	public void testGetText_Does() {
		setup();
		String testString = new Random().toString();
		
		test.setText(testString);
		
		assertEquals(testString, test.getText());
	}
	
	public void testGetId_Does() {
		setup();
		String testString = new Random().toString();
		
		test.setId(testString);
		
		assertEquals(testString, test.getId());
	}
}
