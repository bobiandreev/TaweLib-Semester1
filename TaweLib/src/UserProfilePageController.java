
//import java.awt.Label;
import javafx.scene.control.Label;

import javafx.fxml.FXML;

/**
 * This class shows the user information of the currently logged user.
 * 
 * @author Boris Andreev
 *
 */
public class UserProfilePageController {
	@FXML
	private Label usernameLabel;

	@FXML
	private Label addressLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label mobileLabel;

	private User curUser;

	/**
	 * This method gets called whenever the profile page is loaded. It sets the
	 * labels to show the specific users information.
	 */
	@FXML
	private void initialize() {
		curUser = LoginController.getLoggedUser();
		String username = (" " + curUser.getUsername());
		usernameLabel.setText(username);
		String name = (" " + curUser.getName());
		nameLabel.setText(name);
		String mobile = (" " + curUser.getMobileNumber());
		mobileLabel.setText(mobile);
		String address = (" " + curUser.getHouseNumber() + " " + curUser.getStreetName() + ", "
				+ curUser.getPostcode());
		addressLabel.setText(address);
	}
}
