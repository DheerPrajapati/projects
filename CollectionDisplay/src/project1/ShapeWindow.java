

package project1;

import bag.BagInterface;
import cs2.TextShape;
import java.awt.Color;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;

/**
 * The ShapeWindow class contains the GUI mechanics for the project
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-09
 */
public class ShapeWindow {

    /**
     * The window field
     */
    private Window window;

    /**
     * The textShape field
     */
    private TextShape textShape;

    /**
     * The quitButton Field
     */
    private Button quitButton;

    /**
     * The chooseButton field
     */
    private Button chooseButton;

    /**
     * the itemBag field
     */
    private BagInterface<String> itemBag;

    /**
     * Instantiates a new shape window.
     *
     * @param itemBag
     *            the item bag
     */
    public ShapeWindow(BagInterface<String> itemBag) {
        this.itemBag = itemBag;
        window = new Window();
        window.setTitle("project1");
        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);

        // Quit Button initialization
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        // Quit button placement
        window.addButton(quitButton, WindowSide.NORTH);

        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        // Quit button placement
        window.addButton(chooseButton, WindowSide.SOUTH);

    }


    /**
     * THis method allows the user to
     * exit out the GUI once the
     * "Quit" button is chosen.
     *
     * @param button
     *            the button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This method makes it so if the user
     * clicked the choose button in the GUI
     * then the user will be presented with
     * a randomly chosen string from the bag
     * every time the button is clicked.
     *
     * @param button
     *            the button
     */
    public void clickedChoose(Button button) {
        if (!itemBag.isEmpty()) {
            String itemRemoved = itemBag.remove();
            textShape.setText(itemRemoved);
            this.colorText();
            this.centerText();
        }
        else {
            textShape.setText("No More Items");
            this.colorText();
            this.centerText();
        }

    }


    /**
     * This method makes it so everytime it
     * sees the word "red" or "blue" inside
     * of the the Strings in the bag it will
     * catch it and display the string of that color
     * otherwise it will keep the color of the string
     * black.
     */
    public void colorText() {

        String textOfShape = textShape.getText();

        if (textOfShape.contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (textOfShape.contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }

    }


    /**
     * This method helps me center the text in the center
     * of the GUI by using various different getter and
     * setter methods
     */
    public void centerText() {
        int graphPanelWidth = window.getGraphPanelWidth() / 2;
        int graphPanelHeight = window.getGraphPanelHeight() / 2;
        int textWidth = textShape.getWidth() / 2;
        int textHeight = textShape.getHeight() / 2;

        textShape.setX(graphPanelWidth - textWidth);
        textShape.setY(graphPanelHeight - textHeight);

    }

}
