package net.katerberg.tap.helpers;
/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of TAP.
 * 
 * TAP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

import java.util.Random;

import net.katerberg.tap.R;
import net.katerberg.tap.TapApplication;
import net.katerberg.tap.beans.Die;
import android.content.Context;
import android.media.MediaPlayer;

public class DiceHelper {
	static Random random = new Random();
	MediaPlayer mediaPlayer;

	public DiceHelper() {
		mediaPlayer = MediaPlayer.create(TapApplication.getAppContext(), R.raw.roll);
		defineMediaPlayerListeners();
	}

	//Assumes all values except modifier are non-null
	public Integer rollDie(Die die, Context context){

		if (TapApplication.isSoundOn()){
			mediaPlayer.start(); 
		}
		if (die==null){return null;}

		Integer total=0;//Initialized
		Integer modifier = die.getModifier();

		for (int i=0; i<die.getNumberOfDice(); i++){
			total += (random.nextInt(die.getMaxValue())+1);
		}
		if (modifier!=null){
			total+=modifier;
		}
		return total;
	}

	//Assumes properly populated customDie
	public String createDieDisplayText(Die customDie) {
		String result="";
		Integer modifier = customDie.getModifier();
		Integer numberOfDice = customDie.getNumberOfDice();
		Integer maxValue = customDie.getMaxValue();
		result += numberOfDice+"d"+maxValue;
		if (modifier != null && modifier > 0){
			result += "+" + modifier;
		} else if (modifier < 0){
			result += modifier;
		}
		return result;
	}

	private void defineMediaPlayerListeners() {
		SoundListeners soundListeners = new SoundListeners();
		mediaPlayer.setOnPreparedListener(soundListeners.onPreparedListener);
		mediaPlayer.setOnCompletionListener(soundListeners.onCompletionListener);
		mediaPlayer.setOnVideoSizeChangedListener(soundListeners.onVideoSizeChangedListener);
		mediaPlayer.setOnErrorListener(soundListeners.onErrorListener);
	}

}