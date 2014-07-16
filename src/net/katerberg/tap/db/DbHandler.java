package net.katerberg.tap.db;
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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper{
	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;
	
	// Tables
	private final List<DbHandler> tableHandlerList;

	// Database Name
	private static final String DATABASE_NAME = "tapDb";

	public DbHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		tableHandlerList = new ArrayList<DbHandler>();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		for(DbHandler dbHandler : tableHandlerList){
			dbHandler.onCreate(db);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for(DbHandler dbHandler : tableHandlerList){
			dbHandler.onUpgrade(db, oldVersion, newVersion);
		}
	}

	@Override
	public void onDowngrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion){
		this.onUpgrade(db, oldVersion, newVersion);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		if (!db.isReadOnly()) {
			// Enable foreign key constraints
			db.execSQL("PRAGMA foreign_keys=ON;");
		}
	}

}