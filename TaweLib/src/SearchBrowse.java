import java.util.ArrayList;

public class SearchBrowse {
	
	private static ArrayList<Resource> resourceList = new ArrayList<>(); //Call within the Librarian class, each time he creates a new resource.
	
	public static void addResource(Resource r) {
		resourceList.add(r);
	}
	
	public static ArrayList<Resource> getResources() {
		return resourceList;
	}
	
	public static ArrayList<Resource> getBooks() {
		ArrayList<Resource> bookList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof Book) {
				bookList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		
		return bookList;
	}
	
	public static ArrayList<Resource> getDVDs() {
		ArrayList<Resource> dvdList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof DVD) {
				dvdList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		
		return dvdList;
	}
	
	public static ArrayList<Resource> getLaptops() {
		ArrayList<Resource> laptopList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof LaptopComputer) {
				laptopList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		
		return laptopList;
	}
	
	public static ArrayList<Resource> search(String keyword) {
		ArrayList<Resource> list = new ArrayList<>();
		int count = 0;
		char[] keywordList = keyword.toLowerCase().toCharArray();
		do {
			Resource r = resourceList.get(count);
			char[] titleList = r.getTitle().toLowerCase().toCharArray();
			if (r.getTitle() == keyword) /* need to be changed to something sensible */{
				list.add(r);
			} else if (check(keywordList, titleList, 0)) {
				list.add(r);
			}
			
			count++;
		} while (count != resourceList.size());
		
		return list;
	}
	
	private static boolean check(char[] keyword, char[] title, int index) {
		boolean flag = false;
		while (index != keyword.length) {
			if (keyword[index] == title[index]) {
				flag = true;
			} else {
				flag = false;
			}
			index++;
		}
		return flag;
	}
	
}
