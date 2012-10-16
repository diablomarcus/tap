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

public class Input {
	private String _id;
	private String _text;
	
	//Blank constructor
	public Input(){
	}
	
	//Constructor for real usage
	public Input(String text){
		this._text = text;
	}
	
	//Constructor with manually set ID
	public Input(String id, String text){
		this._id = id;
		this._text = text;
	}
	

	public String getText(){
		return _text;
	}
	
	public void setText(String text){
		this._text=text;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

}
