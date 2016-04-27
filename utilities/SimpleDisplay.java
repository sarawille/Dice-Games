package utilities;


/**
 * @author - Sara Wille
 * The SimpleDisplay class prints to the Console.
 */
public class SimpleDisplay implements Displayable{

	private static SimpleDisplay displayInstance;
	
	public static SimpleDisplay getDisplayInstance() {
		return displayInstance;
	}

	public static void setDisplayInstance(SimpleDisplay displayInstance) {
		SimpleDisplay.displayInstance = displayInstance;
	}

	private SimpleDisplay() {}
	
    @Override
    public void display(String s){
	System.out.print(s);
    }
    
    public void displayln(String s){
	System.out.println(s);
    }
    
}
