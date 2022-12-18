// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * The disk class which implements all the basic
 * method for a disk to function in
 * our TowerOfHanoi
 *
 * @author dheer prajapati (dheer)
 * @version 2022-09-20
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * The Disk Constructor which generates 3 random indexes
     * to generate a random color for the disks.
     *
     * @param width
     *            the width
     */
    public Disk(int width) {

        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(256);
        int index2 = generator.nextInt(256);
        int index3 = generator.nextInt(256);
        Color randomGenColor = new Color(index, index2, index3);
        this.setBackgroundColor(randomGenColor);

    }


    /**
     * This method compares disks to see if there widths are
     * either greater than each other equal or less than each others.
     *
     * @param otherDisk
     *            the other disk
     * @return the int
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();

    }


    /**
     * This method returns the disks width as a
     * string.
     *
     * @return the string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getWidth());
        return s.toString();
    }


    /**
     * This method makes sure that
     * the disks widths are equal.
     *
     * @param obj
     *            the obj
     * @return true, if successful
     */
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Disk disk = (Disk)obj;

            return this.getWidth() == disk.getWidth();
        }
        else {
            return false;
        }
    }

}
