package ui;

/**
 * @author - Sara Wille
 * The SimpleDisplay class prints to the Console.
 */
public class SimpleDisplay implements Displayable{

	private static SimpleDisplay displayInstance = new SimpleDisplay();
	
	private SimpleDisplay() {}
	
	protected static SimpleDisplay getInstance() {
		return displayInstance;
	}
	
    @Override
    public void display(String s){
	System.out.print(s);
    }
    
    public void displayln(String s){
	System.out.println(s);
    }
    
}
