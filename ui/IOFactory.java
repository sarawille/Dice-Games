package ui;

public class IOFactory{
	
	public static Displayable getDisplayable(){
		return SimpleDisplay.getInstance();
	}
	
	public static Validator getValidator() {
		return Validator.getInstance();
	}

}
