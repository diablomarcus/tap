package net.katerberg.hello;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper{
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "inputsManager";
 
    // Contacts table name
    private static final String TABLE_INPUTS = "inputs";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String INPUT_TEXT = "input";

	public DbHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        String CREATE_INPUTS_TABLE = "CREATE TABLE " + TABLE_INPUTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," 
        		+ INPUT_TEXT + " TEXT" 
                + ")";
        db.execSQL(CREATE_INPUTS_TABLE);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String DROP_INPUTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_INPUTS;
		
		db.execSQL(DROP_INPUTS_TABLE);
		this.onCreate(db);
		
	}
	
	public void addInput(Input input){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(INPUT_TEXT, input.getText());

		db.insert(TABLE_INPUTS, null, contentValues);
		db.close();
	}
		
	public Input getInput(String id){
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(TABLE_INPUTS, 
				new String[]{KEY_ID, INPUT_TEXT}, 
				KEY_ID+"=?", 
				new String[]{id == null ? "" : id}, //Give value of id if it has a value
				null, 
				null, 
				null);
		if (cursor != null){
			cursor.moveToFirst(); //ID is the primary key, it should only ever have one result here
		}
		
		return new Input(cursor.getString(0),cursor.getString(1));
	}
	

	public List<Input> getAllInput(){
		List<Input> inputList = new ArrayList<Input>();
		
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT "+KEY_ID+","+INPUT_TEXT+" FROM "+TABLE_INPUTS;
		Cursor cursor = db.rawQuery(sql, null);
		cursor.moveToFirst();
		
		for(int i=0; i<cursor.getCount(); i++){
			Input input = new Input();
			input.setId(cursor.getString(0));
			input.setText(cursor.getString(1));
			inputList.add(input);
			cursor.moveToNext();
		}
		cursor.close();
		db.close();
		return inputList;
	}
	
	public Integer getInputCount(){
		String countQuery = "SELECT " + KEY_ID + " FROM " + TABLE_INPUTS;
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.rawQuery(countQuery, null);
        Integer size = cursor.getCount();

        cursor.close();
        db.close();
 
        return size;
	}
	
	public Integer updateInput(Input input){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(INPUT_TEXT, input.getText());
		Integer rowsChanged= db.update(TABLE_INPUTS, 
				values, 
				KEY_ID + " = ?", 
				new String[] {input.getId()==null ? "" : input.getId()});
		db.close();
		return rowsChanged;
		
	}
	
	public void deleteInput(Input input){
		deleteInput(input.getId());
	}
	public void deleteInput(String id){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_ID, id);
		db.delete(TABLE_INPUTS, KEY_ID + " = ?", new String[] {id});
		db.close();
	}
}