/* THIS IS FOR TEST ONLY!!! */
/* THIS IS FOR TEST ONLY!!! */
/* THIS IS FOR TEST ONLY!!! */
/* THIS IS FOR TEST ONLY!!! */
/* THIS IS FOR TEST ONLY!!! */

public class TransactionHistory {
	private String name;
	private String bookName;
	
	public TransactionHistory(String name, String bookName) {
		this.name = name;
		this.bookName = bookName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getDescriptionForList() {
		return name + ", " + bookName;
	}
}
