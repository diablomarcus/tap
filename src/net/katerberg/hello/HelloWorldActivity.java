/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of Katerproject.
 * 
 * Katerproject is free software: you can redistribute it and/or modify
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
/*
 * Copyright (c) 2012 "Mark Katerberg"
 * TBD
 *
 *This file is part of a Katerproject.
 *
 *This Katerproject is free software: you can redistribute it and/or modify
 *it under the terms of the GNU Affero General Public License as
 *published by the Free Software Foundation, either version 3 of the
 *License, or (at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU Affero General Public License for more details.
 *
 *You should have received a copy of the GNU Affero General Public License
 *along with this program. If not, see <http://www.gnu.org/licenses/>.
 *	
 */
package net.katerberg.hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
	
	private DbHandler inputDb;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        inputDb = new DbHandler(this);

        Button saveButton=(Button)this.findViewById(R.id.save);
        Button displayButton=(Button)this.findViewById(R.id.display);
        Button clearButton=(Button)this.findViewById(R.id.clear);
        TextView outputField = (TextView)findViewById(R.id.output);
        
        saveButton.setOnClickListener(ClickListeners.getSaveClickListener((EditText)findViewById(R.id.input), inputDb));
        displayButton.setOnClickListener(ClickListeners.getDisplayClickListener(outputField, inputDb));
        clearButton.setOnClickListener(ClickListeners.getClearClickListener(outputField, inputDb));
    }	
}
