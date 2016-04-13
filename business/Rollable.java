package business;

public interface Rollable {
	
	//Can I make it so that anything implementing Rollable can choose between these two options?
	void roll();
	void roll(int item);
}
