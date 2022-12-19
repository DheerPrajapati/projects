
package project1;

import bag.BagInterface;

/**
 * The Test class for DisplayCollection which tests all the methods
 *  in DisplayCollection.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-09
 */
public class DisplayCollectionTest extends student.TestCase {

    /** The Constant STRINGS. */
    public static final String[] STRINGS = new String[] { "red circle",
        "blue circle", "red square", "blue square" };

    /**
     * This method runs before each testMethod is called.
     */
    public void setUp() {
        // Since my DisplayCollection class does not contain any
        // Fields this my setUp method has to be blank
    }


    /**
     * This method tests the BagContents method in displayCollection
     * This tests for if the removed item in the bag an item that was actually
     * inside of the bag or not, if it is then the test will return assert True.
     */
    public void testBagContents() {
        DisplayCollection bagSize = new DisplayCollection();
        BagInterface<String> bagInterface = bagSize.getItemBag();
        int sizeGot = bagInterface.getCurrentSize();

        for (int i = 0; i < sizeGot; i++) {
            String removedItem = bagInterface.remove();

            boolean checker = false;
            for (int j = 0; j < STRINGS.length; j++) {
                checker = removedItem.equals(STRINGS[j]);
                if (checker) {
                    break;
                }
            }
            assertTrue(checker);

        }
    }


    /**
     * The test method which tests the bagSize method in displayCollector.
     * This method checks if the size of the bag is between 5 and 15, if it is
     * the method will assert true.
     */
    public void testBagSize() {

        for (int i = 0; i <= 20; i++) {
            DisplayCollection bagSize = new DisplayCollection();
            BagInterface<String> bagInterface = bagSize.getItemBag();
            int sizeGot = bagInterface.getCurrentSize();
            assertTrue(sizeGot <= 15);
            assertTrue(sizeGot >= 5);
        }

    }

}
