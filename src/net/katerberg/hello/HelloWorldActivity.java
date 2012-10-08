package net.katerberg.hello;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
	
	private DbHandler inputDb;


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
    		Log.d("Writing: ", "Writing "+input+" to DB");
    		inputDb.addInput(new Input(input));
    		inputField.setText("");
    		
		}
	};
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        inputDb = new DbHandler(this);
        
        
        Button saveButton=(Button)this.findViewById(R.id.save);
        saveButton.setOnClickListener(saveClickListener);
        
    }
    
}