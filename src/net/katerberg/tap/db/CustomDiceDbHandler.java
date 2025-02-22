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

import net.katerberg.tap.beans.Die;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CustomDiceDbHandler extends DbHandler {


	// Custom Dice
	private static final String TABLE_CUSTOM_DICE = "customDice";

	// Custom Dice Column names
	private static final String KEY_ID = "customDieId";
	private static final String NAME_OF_DIE = "nameOfDie";
	private static final String NUMBER_OF_DICE = "numberOfDice";
	private static final String MAX_VALUE = "maxValue";
	private static final String MODIFIER = "modifier";

	
	public CustomDiceDbHandler(Context context) {
		super(context);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CUSTOM_DICE_TABLE = "CREATE TABLE " + TABLE_CUSTOM_DICE + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," 
				+ NAME_OF_DIE + " TEXT," 
				+ NUMBER_OF_DICE + " INTEGER," 
				+ MAX_VALUE + " INTEGER," 
				+ MODIFIER + " INTEGER" 
				+ ")";
		db.execSQL(CREATE_CUSTOM_DICE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String DROP_CUSTOM_DICE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CUSTOM_DICE;

		db.execSQL(DROP_CUSTOM_DICE_TABLE);
		this.onCreate(db);
	}

	public Long addCustomDie(Die customDie){
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = createContentValuesFromCustomDie(customDie);

		long insert = db.insert(TABLE_CUSTOM_DICE, null, contentValues);
		db.close();
		return insert;
	}

	public Die getCustomDie(String id){
		SQLiteDatabase db = this.getWritableDatabase();

		Cursor cursor = db.query(TABLE_CUSTOM_DICE, 
				new String[]{KEY_ID, NAME_OF_DIE, NUMBER_OF_DICE, MAX_VALUE, MODIFIER}, 
				KEY_ID+"=?", 
				new String[]{id == null ? "" : id}, //Give value of id if it has a value
				null, 
				null, 
				null);
		if (cursor != null){
			cursor.moveToFirst(); //ID is the primary key, it should only ever have one result here
		}

		Die customDie = new Die(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
		db.close();
		cursor.close();


		return customDie;
	}


	public List<Die> getAllCustomDice(){
		List<Die> customDiceList = new ArrayList<Die>();

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT " + KEY_ID + "," + NAME_OF_DIE + "," + NUMBER_OF_DICE + "," + MAX_VALUE + "," + MODIFIER 
				+ " FROM " + TABLE_CUSTOM_DICE;
		Cursor cursor = db.rawQuery(sql, null);
		cursor.moveToFirst();

		for(int i=0; i<cursor.getCount(); i++){
			customDiceList.add(new Die(cursor.getInt(0), cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4)));
			cursor.moveToNext();
		}
		cursor.close();
		db.close();
		return customDiceList;
	}

	public Integer getCustomDiceCount(){
		String countQuery = "SELECT " + KEY_ID 
				+ " FROM " + TABLE_CUSTOM_DICE;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(countQuery, null);
		Integer size = cursor.getCount();

		cursor.close();
		db.close();

		return size;
	}

	public Integer updateCustomDie(Integer id){
		if (id==null){
			return null;
		}
		Die customDie = getCustomDie(id.toString());
		if (customDie == null){
			return null;
		}
		return updateCustomDie(customDie);
	}

	public Integer updateCustomDie(Die customDie){

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = createContentValuesFromCustomDie(customDie);

		Integer rowsChanged= db.update(TABLE_CUSTOM_DICE, 
				values, 
				KEY_ID + " = ?", 
				new String[] {customDie.getCustomDieId().toString()==null ? "" : customDie.getCustomDieId().toString()});
		db.close();
		return rowsChanged;
	}

	public void deleteInput(Die input){
		deleteInput(input.getCustomDieId());
	}

	public void deleteInput(Integer id){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_ID, id);
		db.delete(TABLE_CUSTOM_DICE, KEY_ID + " = ?", new String[] {id.toString()});
		db.close();
	}

	private ContentValues createContentValuesFromCustomDie(Die customDie) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(NAME_OF_DIE, customDie.getNameOfDie());
		contentValues.put(NUMBER_OF_DICE, customDie.getNumberOfDice());
		contentValues.put(MAX_VALUE, customDie.getMaxValue());
		contentValues.put(MODIFIER, customDie.getModifier());
		return contentValues;
	}

	public void deleteAllCustomDice() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CUSTOM_DICE, null, null);
	}
}
