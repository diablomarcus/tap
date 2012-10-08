package net.katerberg.hello;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {


    private OnClickListener saveClickListener = new OnClickListener() {
    	public void onClick(View v) {
    		TextView outputField = (TextView)findViewById(R.id.output);
    		EditText inputField = (EditText)findViewById(R.id.input);
    		
    		String input = inputField.getEditableText().toString();
    		String outputString="";
    		
    		if (!input.equals("")) {
    			outputString = "You typed: "+input;
    		} 
    		outputField.setText(outputString);
    		inputField.setText("");
    		
		}
	};
	
	public SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(null, null, null, 1) {
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.beginTransaction();
		}
	};
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        Button saveButton=(Button)this.findViewById(R.id.save);
        saveButton.setOnClickListener(saveClickListener);
        
    }
    
}