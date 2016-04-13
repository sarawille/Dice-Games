package ui;

public class IOFactory{
	
	public static Displayable getDisplayable(){
		return SimpleDisplay.getInstance();
	}

}
