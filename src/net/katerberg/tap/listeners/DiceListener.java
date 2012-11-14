package net.katerberg.tap.listeners;
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
import net.katerberg.tap.beans.Die;
import net.katerberg.tap.helpers.DiceHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DiceListener implements OnClickListener {

	private Die die;
	private TextView outputView;
	private DiceHelper diceHelper;

	public DiceListener(Die die, TextView outputView){
		this.die = die;
		this.outputView = outputView;
		diceHelper = new DiceHelper();
	}
	
	public void onClick(View v) {
		if (!areInputsValid()){return;}
		
		outputView.setText(diceHelper.rollDie(die, v.getContext()).toString());
		
	}

	private boolean areInputsValid() {
		if (outputView == null || 
				die == null ||
				die.getMaxValue() == null ||
				die.getNumberOfDice() == null){
			return false;
		}
		return true;
	}

	
}
