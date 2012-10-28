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
package net.katerberg.hello;

import org.mockito.Mock;

import android.test.AndroidTestCase;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class ClickListenersTest extends AndroidTestCase {

	public ClickListeners test;
	@Mock
	private DbHandler mockInputDb;
	@Mock
	private TextView mockOutputField;
	@Mock
	private TextView mockTextView;
	@Mock
	private EditText mockEditField;
	
	public void setup(){
		
	}
	
	public void testGetDisplayClickListener_Does(){
		setup();
		
		OnClickListener testObject = ClickListeners.getDisplayClickListener(mockOutputField, mockInputDb);
		
		assertNotNull(testObject);
	}
	
	public void testGetClearClickListener_Does(){
		setup();
		
		OnClickListener testObject = ClickListeners.getClearClickListener(mockInputDb);
		
		assertNotNull(testObject);
	}
	
	public void testGetClearClickListener_Does_With_More_Parameters(){
		setup();
		
		OnClickListener testObject = ClickListeners.getClearClickListener(mockTextView, mockInputDb);
		
		assertNotNull(testObject);
	}
	
	public void testGetSaveClickListener_Does(){
		setup();
		
		OnClickListener testObject = ClickListeners.getSaveClickListener(mockEditField, mockInputDb);
		
		assertNotNull(testObject);
	}
	
	public void testGetSaveClickListener_Does_With_More_Parameters(){
		setup();
		
		OnClickListener testObject = ClickListeners.getSaveClickListener(mockEditField, mockInputDb);
		
		assertNotNull(testObject);
	}
	

}
