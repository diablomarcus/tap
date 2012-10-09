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
