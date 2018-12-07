import java.awt.Image;
import java.io.*;
import java.util.*;

/**
 * The profile image class allows the user to select between 5 set images
 * @author Riyaad Islam and Oliver Nixon
 * @version 1.0.0
 */
public class ProfileImage {
	private String profileimageName;
	private Image image;
	private Image avatars[] = new Image[5];
	
	/**
	 * @return This method returns an image
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * @param Sets the image
	 */
	public void setImage(Image image) {
		this.image = image;
	}	

	/**
	 * @param profileimageName
	 * @param image
	 * @param avatars
	 * Constructs the objects
	 */
	public ProfileImage(String profileimageName, Image image, Image[] avatars) {
		this.profileimageName = profileimageName;
		this.image = image;
		this.avatars = avatars;
	}
	
	/**
	 * @return
	 */
	public Image[] getAvatars() {
		return avatars;
	}

	/**
	 * @param avatars
	 * Constructs avatars
	 */
	public void setAvatars(Image[] avatars) {
		this.avatars = avatars;
	}	
	
	/**
	 * @param in
	 * 
	 */
	public ProfileImage(Scanner in) {
		this.profileimageName = in.next().trim();
	}
	
	/**
	 * @return Returns profile image name
	 */
	public String getImageName() {
		return this.profileimageName;
	}
	
	/**
	 * @param file
	 * @throws IOException
	 */
	public void toFile(BufferedWriter file) throws IOException {
			file.write("Image); " + profileimageName + image);
			file.newLine();
	}
	
	@Override
	public String toString() {
			return this.profileimageName;
	}
}
