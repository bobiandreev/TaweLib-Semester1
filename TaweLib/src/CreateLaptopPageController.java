import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    
    @FXML
    private TextField numOfCopies;
    
    private BufferedImage image;

    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	String title = this.title.getText();
    	int year = Integer.parseInt(this.year.getText());
    	String manufacturer = this.manufacturer.getText();
    	String model = this.model.getText();
    	String OS = this.operatingSystem.getText();
    	int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
    	//LaptopComputer newLaptop = new LaptopComputer(title, year, image, numberOfCopies, manufacturer, model, OS);
    	//System.out.println(newBook.toString());
    	SearchBrowse.addResource(new LaptopComputer(title, year, image, numberOfCopies, manufacturer, model, OS));
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