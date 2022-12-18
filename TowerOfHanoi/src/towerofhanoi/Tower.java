// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

/**
 * The Tower class which stores the
 * disk function as stacks.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class Tower extends LinkedStack<Disk> {

    /** The position field */
    private Position position;

    /**
     * Instantiates a new tower.
     *
     * @param position
     *            the position
     */
    public Tower(Position position) {
        super();
        this.position = position;

    }


    /**
     * returns the position of the tower
     *
     * @return the position
     */
    public Position position() {

        return position;
    }


    /**
     * pushs a disk onto the tower
     * if the tower is either empty or
     * has a valid width that is not equal to zero
     * or negative. else it will throw
     * an illegalStateException.
     *
     * @param disk
     *            the disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }
}
