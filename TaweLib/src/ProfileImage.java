import java.awt.Image;
import java.io.*;
import java.util.*;

public class ProfileImage {
	private String profileimageName;
	private Image image;
	private Image avatars[] = new Image[5];
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}	
		
	public ProfileImage(String profileimageName, Image image, Image[] avatars) {
		this.profileimageName = profileimageName;
		this.image = image;
		this.avatars = avatars;
	}
	
	public Image[] getAvatars() {
		return avatars;
	}

	public void setAvatars(Image[] avatars) {
		this.avatars = avatars;
	}	
	
	
	public ProfileImage(Scanner in) {
		this.profileimageName = in.next().trim();
	}
	
	public String getImageName() {
		return this.profileimageName;
	}
	
	public void toFile(BufferedWriter file) throws IOException {
			file.write("Image); " + profileimageName + image);
			file.newLine();
	}
	
	@Override
	public String toString() {
			return this.profileimageName;
	}
}
