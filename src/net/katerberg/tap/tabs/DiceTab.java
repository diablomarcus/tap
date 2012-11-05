package net.katerberg.tap.tabs;

import java.util.Random;

import net.katerberg.tap.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DiceTab extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicetab);
        createListeners();
    }

	private void createListeners() {
		TextView diceDisplayView = (TextView)this.findViewById(R.id.diceDisplayView);
		
		((Button)this.findViewById(R.id.d4)).setOnClickListener(createRollListener(4, diceDisplayView));
		((Button)this.findViewById(R.id.d6)).setOnClickListener(createRollListener(6, diceDisplayView));
		((Button)this.findViewById(R.id.d8)).setOnClickListener(createRollListener(8, diceDisplayView));
		((Button)this.findViewById(R.id.d10)).setOnClickListener(createRollListener(10, diceDisplayView));
		((Button)this.findViewById(R.id.d12)).setOnClickListener(createRollListener(12, diceDisplayView));
		((Button)this.findViewById(R.id.d20)).setOnClickListener(createRollListener(20, diceDisplayView));
		((Button)this.findViewById(R.id.d100)).setOnClickListener(createRollListener(100, diceDisplayView));
		
	}

	private OnClickListener createRollListener(final Integer dieSize, final TextView outputField) {
		if (dieSize == null || outputField == null|| dieSize < 0){
			return null;
		}
		
		return createOnClickListener(outputField, dieSize);
	}

	private OnClickListener createOnClickListener(final TextView outputField, final Integer dieSize) {
		if (outputField == null || dieSize==null) {
			return null;
		}
		
		return new OnClickListener() {
	    	public void onClick(View v) {

	    		Integer randomNumber = (Integer)(new Random().nextInt(dieSize)+1);
	    		outputField.setText(randomNumber.toString());
	    	}
		};
	}
}