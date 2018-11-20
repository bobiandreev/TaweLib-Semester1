import java.util.ArrayList;

public class SearchBrowse {
	
	private static ArrayList<Resource> resourceList; //Call within the Librarian class, each time he creates a new resource.
	
	public static void addResource(Resource r) {
		resourceList.add(r);
	}
	
	public static ArrayList<Resource> getResources() {
		return resourceList;
	}
	
	public static ArrayList<Resource> getLaptops() {
		ArrayList<Resource> laptopList = new ArrayList<>();
		int count = 1;
		do {
			if (resourceList.get(count) instanceof LaptopComputer) {
				laptopList.add(resourceList.get(count));
			}
			count++;
		} while (count == resourceList.size());
		
		return laptopList;
	}
	
	public static ArrayList<Resource> getBooks() {
		ArrayList<Resource> bookList = new ArrayList<>();
		int count = 1;
		do {
			if (resourceList.get(count) instanceof Book) {
				bookList.add(resourceList.get(count));
			}
			count++;
		} while (count == resourceList.size());
		
		return bookList;
	}
	
	public static ArrayList<Resource> getDVDs() {
		ArrayList<Resource> dvdList = new ArrayList<>();
		int count = 1;
		do {
			if (resourceList.get(count) instanceof DVD) {
				dvdList.add(resourceList.get(count));
			}
			count++;
		} while (count == resourceList.size());
		
		return dvdList;
	}
	
	public static ArrayList<Resource> search(String keyword) {
		ArrayList<Resource> list = new ArrayList<>();
		int count = 1;
		do {
			if (resourceList.get(count).getTitle() == keyword) /* need to be changed to something sensible */{
				list.add(resourceList.get(count));
			}
			count++;
		} while (count == resourceList.size());
		
		return list;
	}
	
}
