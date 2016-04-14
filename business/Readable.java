package business;

public interface Readable {

	//Can I make it so that anything implementing Readable can choose between these two options?
	//TODO use design pattern to determine which method is used??
	int readFaceUp();
	int readFaceUp(int i);
}
