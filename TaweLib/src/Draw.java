
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Draw extends Application {

	@Override
	public void start(Stage primaryStage) {

		/* Creating buttons for shapes */
		ToggleButton pencilbutton = new ToggleButton("Pencil");
		ToggleButton eraserbutton = new ToggleButton("Eraser");
		ToggleButton linebutton = new ToggleButton("Straight Line");
		ToggleButton rectanglebutton = new ToggleButton("Rectangle Shape");
		ToggleButton circlebutton = new ToggleButton("Circle Shape");

		ToggleButton[] toolsArray = { pencilbutton, eraserbutton, linebutton, rectanglebutton, circlebutton };

		ToggleGroup tools = new ToggleGroup();

		for (ToggleButton tool : toolsArray) {
			tool.setMinWidth(90);
			tool.setToggleGroup(tools);
			tool.setCursor(Cursor.HAND);
		}

		ColorPicker colourpickerLine = new ColorPicker(Color.BLACK);
		ColorPicker colourpickerFill = new ColorPicker(Color.TRANSPARENT);

		Slider slide = new Slider(1, 50, 3);
		slide.setShowTickLabels(true);
		slide.setShowTickMarks(true);

		Label line_colour = new Label("Line Colour");
		Label fill_colour = new Label("Fill Colour");
		Label line_width = new Label("3.0");

		Button open = new Button("Open");
		Button save = new Button("Save");

		Button[] basArray = { save, open };

		for (Button button : basArray) {
			button.setMinWidth(90);
			button.setCursor(Cursor.HAND);
			button.setTextFill(Color.BLACK);
			button.setStyle("-fx-background-color: #666;");
		}
		save.setStyle("-fx-background-color: #80334d;");
		open.setStyle("-fx-background-color: #80334d;");

		VBox buttons = new VBox(10);
		buttons.getChildren().addAll(pencilbutton, eraserbutton, linebutton, rectanglebutton, circlebutton, line_colour,
				colourpickerLine, fill_colour, colourpickerFill, line_width, slide, open, save);
		buttons.setPadding(new Insets(5));
		buttons.setStyle("-fx-background-color: #999");
		buttons.setPrefWidth(100);

		/* Creating the canvas */
		Canvas sketchpad = new Canvas(400, 470);
		GraphicsContext gc;
		gc = sketchpad.getGraphicsContext2D();
		gc.setLineWidth(1);

		Line straightline = new Line();
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();

		sketchpad.setOnMousePressed(e -> {
			if (pencilbutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.beginPath();
				gc.lineTo(e.getX(), e.getY());
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			} else if (linebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				straightline.setStartX(e.getX());
				straightline.setStartY(e.getY());
			} else if (rectanglebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.setFill(colourpickerFill.getValue());
				rectangle.setX(e.getX());
				rectangle.setY(e.getY());

			} else if (circlebutton.isSelected()) {
				gc.setStroke(colourpickerLine.getValue());
				gc.setFill(colourpickerFill.getValue());
				circle.setCenterX(e.getX());
				circle.setCenterY(e.getY());

			}
		});

		sketchpad.setOnMouseDragged(e -> {
			if (pencilbutton.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			}
		});

		sketchpad.setOnMouseReleased(e -> {
			if (pencilbutton.isSelected()) {
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.closePath();
			} else if (eraserbutton.isSelected()) {
				double lineWidth = gc.getLineWidth();
				gc.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
			} else if (linebutton.isSelected()) {

				straightline.setEndX(e.getX());
				straightline.setEndY(e.getY());
				gc.strokeLine(straightline.getStartX(), straightline.getStartY(), straightline.getEndX(),
						straightline.getEndY());

			} else if (rectanglebutton.isSelected()) {
				rectangle.setWidth(Math.abs((e.getX() - rectangle.getX())));
				rectangle.setHeight(Math.abs((e.getY() - rectangle.getY())));

				if (rectangle.getX() > e.getX()) {
					rectangle.setX(e.getX());
				}

				if (rectangle.getY() > e.getY()) {
					rectangle.setY(e.getY());
				}

				gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
				gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());

			} else if (circlebutton.isSelected()) {
				circle.setRadius(
						(Math.abs(e.getX() - circle.getCenterX()) + Math.abs(e.getY() - circle.getCenterY())) / 2);

				if (circle.getCenterX() > e.getX()) {
					circle.setCenterX(e.getX());
				}
				if (circle.getCenterY() > e.getY()) {
					circle.setCenterY(e.getY());
				}

				gc.strokeOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
				gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());

			}

		});
		// gives the colour options
		colourpickerLine.setOnAction(e -> {
			gc.setStroke(colourpickerLine.getValue());
		});
		colourpickerFill.setOnAction(e -> {
			gc.setFill(colourpickerFill.getValue());
		});

		// slider
		slide.valueProperty().addListener(e -> {
			double width = slide.getValue();

			gc.setLineWidth(width);
		});

		/* Save and Open feature created */

		save.setOnAction((e) -> {
			// FileChooser savefile = new FileChooser();
			// File saveFile = new File();
			// saveFile).setTitle("Save File");

			File outputFile = new File("src\\Avatar6.png");
			if (outputFile != null) {
				try {
					WritableImage writeImage = new WritableImage(1080, 790);
					sketchpad.snapshot(null, writeImage);
					RenderedImage rendImg = SwingFXUtils.fromFXImage(writeImage, null);
					ImageIO.write(rendImg, "png", outputFile);
				} catch (IOException ex) {
					System.out.println("Not Valid");
				}
			}

		});

		open.setOnAction((e) -> {
			FileChooser openFile = new FileChooser();
			openFile.setTitle("Open File");
			File file = openFile.showOpenDialog(primaryStage);
			if (file != null) {
				try {
					InputStream io = new FileInputStream(file);
					Image img = new Image(io);
					gc.drawImage(img, 0, 0);
				} catch (IOException ex) {
					System.out.println("Not Valid");
				}
			}
		});

		/* The stage and scene */
		BorderPane pane = new BorderPane();
		pane.setLeft(buttons);
		pane.setCenter(sketchpad);

		Scene scene = new Scene(pane, 500, 480);

		primaryStage.setTitle("Avatar Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}