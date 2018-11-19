import java.util.ArrayList;

public class Copy {
	
	private ArrayList<String> copies = new ArrayList<>();
	private Resource resource;
	private int numOfCopies;
	
	public Copy(Resource resource, int numOfCopies) {
		this.resource = resource;
		this.numOfCopies = numOfCopies;
		copies = generateCopies(numOfCopies);
	}
	
	public ArrayList<String> generateCopies(int numbOfCopies) {
		ArrayList<String> copies = new ArrayList<>();
		for (int i = 0; i < numOfCopies; i++) {
			
		}
		return copies;
	}
}
