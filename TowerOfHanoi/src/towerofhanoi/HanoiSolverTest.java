
package towerofhanoi;

/**
 * HanoiSolverTest which tests all the methods in the
 * HanoiSolver Class.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class HanoiSolverTest extends student.TestCase {

    /** The solver field */
    private HanoiSolver solver;

    /**
     * The setUp method which runs every time before a testMethod.
     */
    public void setUp() {
        solver = new HanoiSolver(5);
    }


    /**
     * test Disks method which tests for
     * the correct number of disks being returned.
     */
    public void testDisks() {
        assertEquals(5, solver.disks());
    }


    /**
     * Checks that the correct tower is being returned
     * by using multiple assert statements
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.MIDDLE)
            .position());
        assertEquals(Position.RIGHT, solver.getTower(Position.RIGHT)
            .position());
        assertEquals(Position.MIDDLE, solver.getTower(Position.DEFAULT)
            .position());

    }


    /**
     * A testToString method which tests that the toString method
     * is being formatted correctly.
     */
    public void testToString() {
        assertEquals("[][][]", solver.toString());
    }


    /**
     * a test Solve method which tests that the
     * Tower ofHanoi is being solved correctly
     * by checking that all the disks are beginning on the
     * left tower and then checking that all the disks are on
     * the final tower in the same order after the method was called
     */
    public void testSolve() {

        Tower leftTower = solver.getTower(Position.LEFT);
        leftTower.push(new Disk(10));
        leftTower.push(new Disk(9));
        leftTower.push(new Disk(8));
        leftTower.push(new Disk(7));
        leftTower.push(new Disk(6));
        assertEquals("[6, 7, 8, 9, 10][][]", solver.toString());
        solver.solve();
        System.out.println(solver.toString());
        assertEquals("[][][6, 7, 8, 9, 10]", solver.toString());

    }
}
