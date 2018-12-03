import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The CreateLaptopPageController Class which controls the CreateLaptopPage.fxml
 * @author Ming
 *
 */
public class CreateLaptopPageController {

    @FXML
    private BorderPane createLaptopPane;

    @FXML
    private TextField title;

    @FXML
    private TextField year;

    @FXML
    private Button thumbnailImage;

    @FXML
    private TextField manufacturer;

    @FXML
    private TextField model;

    @FXML
    private TextField operatingSystem;
    
    private BufferedImage image;

    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }

    @FXML
    public void clickOnThumbnailImage(ActionEvent event) throws IOException {
    	FileChooser fc = new FileChooser();
    	File selectedFile = fc.showOpenDialog(null);
    	image = ImageIO.read(selectedFile.getAbsoluteFile());
    	/* ImageIcon imgIcon = new ImageIcon(image);
    	JLabel lbl = new JLabel();
    	lbl.setIcon(imgIcon);
    	JFrame frame = new JFrame("Image viewer");
    	frame.getContentPane().add(lbl, BorderLayout.CENTER);
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	*/
    }
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createLaptopPane.getScene().getWindow();
	    stage.close();
	}
}