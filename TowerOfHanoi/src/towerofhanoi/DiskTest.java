
package towerofhanoi;

/**
 * The disk test class which tests all
 * the method in the disk class.
 * 
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class DiskTest extends student.TestCase {

    /** The disk field */
    private Disk disk;

    /** The disk 2 field */
    private Disk disk2;

    /** The disk 3 field */
    private Disk disk3;

    /** The disk 4 field */
    private Disk disk4;

    /** The disk 5 field */
    private Disk disk5;

    /** The notSameClass field */
    private String notSameClass;

    /**
     * Set up method which runs everytime before each test method
     * 
     */
    public void setUp() {
        disk = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(10);
        disk5 = new Disk(5);
        notSameClass = "1";
    }


    /**
     * Test compareTo method compares disks to see
     * if they are either = to 0 or greater than or less
     * than zero.
     */
    public void testCompareTo() {
        assertEquals(0, disk.compareTo(disk3));
        assertEquals(10, disk2.compareTo(disk));
        assertEquals(-5, disk5.compareTo(disk));

    }


    /**
     * Tests for the IllegalArgumentException that is
     * thrown when a the disk passed in is null.
     */
    public void testCompareToException() {
        Exception thrown = null;
        try {
            disk.compareTo(disk4);

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    /**
     * tests the toString method by asserting that
     * the method produces the correct output format.
     */
    public void testToString() {
        assertEquals("10", disk.toString());
    }


    /**
     * Tests the equals method by asserting true if
     * a disk is equal to itself, equal to a disk with the same
     * width, and assertingFalse if the disk is equal to null, if the disk
     * is equal to a disk with a different width, and with something that is not
     * in the same class.
     */
    public void testEquals() {
        assertTrue(disk.equals(disk));
        assertFalse(disk.equals(null));
        assertTrue(disk.equals(disk3));
        assertFalse(disk.equals(disk2));
        assertFalse(disk.equals(notSameClass));
    }

}
