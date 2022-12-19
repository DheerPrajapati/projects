
package project1;

import bag.Bag;
import bag.BagInterface;
import java.util.Random;

/**
 * The Display collection class which has the ability to 
 * create a randomly generated bag.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-09
 */
public class DisplayCollection {

    /** The Constant STRINGS. */
    public static final String[] STRINGS = new String[] { "red circle",
        "blue circle", "red square", "blue square" };

    /**
     * The itemBag feild
     */
    private BagInterface<String> itemBag;

    /**
     * The displayColelction constructor which holds
     * the an instance of the random class
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();

        Random random = new Random();

        // Generates a random number between 5 to 15
        int count = random.nextInt(11) + 5;

        // Adds a random string to the itemBag
        for (int i = 0; i < count; i++) 
        {
            int ri = random.nextInt(4);
            itemBag.add(STRINGS[ri]);
        }

    }


    /**
     * a getter method for itemBag.
     *
     * @return the item bag
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }

}
