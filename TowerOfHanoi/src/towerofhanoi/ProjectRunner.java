// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer

package towerofhanoi;

/**
 * The Class ProjectRunner which gives the
 * user the ability to run the GUI.
 * 
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class ProjectRunner {

    /**
     * The main method
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow puzzleWindow = new PuzzleWindow(new HanoiSolver(disks));
    }
}
