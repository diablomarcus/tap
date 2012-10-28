package net.katerberg.hello;

import java.util.Random;

public class Dice {

	public static Integer rollD(Integer dieSize){
		Integer val = null;
		if (null != dieSize){
			Random random = new Random();
			val = random.nextInt(dieSize);
			System.out.println(val);
		}
		return val;
	}

}
