// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

/**
 * This class tests all the methods in tower
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-20
 */
public class TowerTest extends student.TestCase {

    /** The tower field */
    private Tower tower;

    /** The disk field */
    private Disk disk;

    /** The disk neg field */
    private Disk diskNeg;

    /** The good disk field */
    private Disk goodDisk;

    /** The good disk 2 field */
    private Disk goodDisk2;

    /**
     * The setup method which runs every time before
     * each testMethod.
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
        diskNeg = new Disk(15);
        goodDisk = new Disk(10);
        goodDisk2 = new Disk(5);

    }


    /**
     * tests the position by asserting that
     * the tower starts in the leftPosition.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }


    /**
     * Tests push by pushing 2 disks and then asserting
     * that the size is 2.
     * 
     */
    public void testPush() {
        tower.push(goodDisk);
        tower.push(goodDisk2);
        assertEquals(2, tower.size());

    }


    /**
     * Tests the exception that push throws by passing in
     * a disk while the stack is empty.
     */
    public void testExceptionPush() {
        Exception thrown = null;
        try {
            tower.push(disk);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    /**
     * Test exception push by passing in a
     * disk that has a negative width.
     */
    public void testExceptionPushNeg() {
        Exception thrown = null;
        try {
            tower.push(goodDisk);
            tower.push(diskNeg);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
}
