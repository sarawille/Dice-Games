package ui;

/**
 * 
 * @author Sara Wille
 * The IOFactory can return a Displayable and a Validator.
 * Singleton design pattern.
 *
 */
public class IOFactory{
	
	public static Displayable getDisplayable(){
		return SimpleDisplay.getInstance();
	}
	
	public static Validator getValidator() {
		return Validator.getInstance();
	}

}
