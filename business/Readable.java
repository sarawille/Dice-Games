package business;

public interface Readable {

	//Can I make it so that anything implementing Readable can choose between these two options?
	int readFaceUp();
	int readFaceUp(int i);
}
