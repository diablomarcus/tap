package net.katerberg.tap;
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
import net.katerberg.tap.listeners.AcceptCustomDieListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddNewDieActivity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_custom_die);
	
		EditText nameField = (EditText)findViewById(R.id.customNameOfDie);
		EditText typeField = (EditText)findViewById(R.id.customDieType);
		EditText numberField = (EditText)findViewById(R.id.customNumberOfDice);
		EditText modifierField = (EditText)findViewById(R.id.customModifier);
		((Button)this.findViewById(R.id.acceptCustomDie))
			.setOnClickListener(new AcceptCustomDieListener(this, nameField, typeField, numberField, modifierField));
	}

}
