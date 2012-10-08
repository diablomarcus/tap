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
