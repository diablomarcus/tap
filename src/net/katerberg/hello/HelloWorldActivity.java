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