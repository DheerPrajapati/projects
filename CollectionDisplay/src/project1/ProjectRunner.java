// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package project1;

/**
 * The Project runner Class shows the functionality of
 * displayCollection and ShapeWindow.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-09
 */
public class ProjectRunner {

    /**
     * The main method which creates instances of displayCollection
     * and shapeWindow.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        DisplayCollection displayC = new DisplayCollection();

        ShapeWindow shapeW = new ShapeWindow(displayC.getItemBag());

    }

}
