import javafx.scene.image.Image;

public class DVD extends Resource {
	
	private String director;
	private int runtime;
	private String language;
	private String subtitles;

	public DVD( String title, int year, Image thumbnailImage, int numOfCopies, String director, int runtime,
			String language, String subtitles) {
		super(title, year, thumbnailImage, numOfCopies);
		this.director = director;
		this.runtime = runtime;
		this.language = language;
		this.subtitles = subtitles;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

}
