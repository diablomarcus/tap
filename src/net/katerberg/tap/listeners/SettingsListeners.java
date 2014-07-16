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
import java.util.logging.Level;
import java.util.logging.Logger;

import net.katerberg.tap.TapApplication;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class SettingsListeners {

	protected  Logger _logger;



	public SettingsListeners() {
		_logger = Logger.getLogger("SettingsListeners");
	}

	public OnCheckedChangeListener onSoundChangeListener = new OnCheckedChangeListener() {

		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked){
				TapApplication.setSoundOn(true);
			} else {
				TapApplication.setSoundOn(false);
			}
			_logger.log(Level.CONFIG, "Sound setting changed", isChecked);
		}
	};
	public OnCheckedChangeListener onCustomNameChangeListener = new OnCheckedChangeListener() {

		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked){
				TapApplication.setCustomNameOn(true);
			} else {
				TapApplication.setCustomNameOn(false);
			}
			_logger.log(Level.CONFIG, "Custom Name setting changed", isChecked);
		}
	};
}