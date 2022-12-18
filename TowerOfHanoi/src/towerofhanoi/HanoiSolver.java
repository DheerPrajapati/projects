// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

import java.util.Observable;

/**
 * HanoiSolver class.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class HanoiSolver extends Observable {

    /** The left. */
    private Tower left;

    /** The middle. */
    private Tower middle;

    /** The right. */
    private Tower right;

    /** The num disks. */
    private int numDisks;

    /**
     * The HanoiSolver Constructor which takes a numDisks
     * input and instantiates the left,middle, and right towers
     * and the numDisks.
     * 
     * @param numDisks
     *            the num disks
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;
    }


    /**
     * Returns the number of disks.
     *
     * @return the int
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Gets the desired tower depending on the
     * position passed in.
     *
     * @param pos
     *            the position of the tower
     * @return the tower
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }


    /**
     * This method returns the amount of disks on a tower
     * in string format for example if there where 3 disks on
     * the left tower the toString would look like
     * [1, 2, 3][][].
     *
     * @return the string
     */
    public String toString() {

        String builtString = left.toString() + middle.toString() + right
            .toString();
        return builtString;

    }


    /**
     * This method executes a specified move by going to a
     * specific source and tower destination.
     * 
     * @param source
     *            the source
     * @param destination
     *            the destination
     */
    private void move(Tower source, Tower destination) {
        Disk poppedSource = source.pop();
        destination.push(poppedSource);
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * This method basically solve the the whole
     * TowerOFHanoi by using a recursive approach.
     *
     * @param currentDisks
     *            the current disks
     * @param startPole
     *            the start pole
     * @param tempPole
     *            the temp pole
     * @param endPole
     *            the end pole
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        System.out.println(this);
        if (currentDisks == 1) {
            this.move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * The main method which uses the help of solveTowers. to Solve
     * the TowerOfHanoi.
     * 
     */
    public void solve() {
        this.solveTowers(numDisks, left, middle, right);
    }

}
