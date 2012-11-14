package net.katerberg.tap.tabs;
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
import net.katerberg.tap.R;
import net.katerberg.tap.TapApplication;
import net.katerberg.tap.helpers.SettingsListeners;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

public class SettingsTab extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);        
        setupSettingsListeners();
    }

	private void setupSettingsListeners() {
		SettingsListeners soundListeners = new SettingsListeners();
		CheckBox soundToggle = (CheckBox)this.findViewById(R.id.sound_value);
		soundToggle.setChecked(TapApplication.isSoundOn());
		soundToggle.setOnCheckedChangeListener(soundListeners.onCheckedChangeListener);
	}
}