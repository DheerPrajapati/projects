// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Puzzle Window class which configures all
 * the positions of the disks and poles.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class PuzzleWindow implements Observer {

    /** The game field */
    private HanoiSolver game;

    /** The left field */
    private Shape left;

    /** The right field */
    private Shape right;

    /** The middle field */
    private Shape middle;

    /** The window field */
    private Window window;

    /** The Constant WIDTH_FACTOR field */
    public static final int WIDTH_FACTOR = 5;

    /** The Constant DISK_GAP field */
    public static final int DISK_GAP = 0;

    /** The Constant DISK_HEIGHT field */
    public static final int DISK_HEIGHT = 10;

    /**
     * A method that pauses between Disk movements.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * When called this method
     * updates the front-end, after the back-end has been changed.
     *
     * @param position
     *            the position
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;

        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case MIDDLE:
                currentPole = middle;
            default:
                currentPole = middle;
        }

        Tower tower = game.getTower(position);
        int stackSize = tower.size() * DISK_HEIGHT;
        int poleCenterX = currentPole.getX() + currentPole.getWidth() / 2;

        int finalY = currentPole.getY() + currentPole.getHeight() - stackSize;
        int finalX = poleCenterX - currentDisk.getWidth() / 2;

        currentDisk.setX(finalX);
        currentDisk.setY(finalY);
    }


    /**
     * The PuzzleWindow Construcotr takes in a game
     * input and instantiates the all the field variables.
     * and updates the disks locations as they are moved.
     *
     * @param game
     *            the game
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        left = new Shape(100, 100, 5, 100, Color.BLACK);
        middle = new Shape(200, 100, 5, 100, Color.BLACK);
        right = new Shape(300, 100, 5, 100, Color.BLACK);
        window = new Window("Tower of Hanoi");
        for (int i = game.disks(); i >= 1; i--) {
            Disk newDisk = new Disk(i * WIDTH_FACTOR);
            window.addShape(newDisk);
            Tower leftTower = game.getTower(Position.LEFT);
            leftTower.push(newDisk);
            this.moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * This method will be automatically called
     * when the games move method calls its notifyObservers
     * method.
     *
     * @param o
     *            o
     * @param arg
     *            arg
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass().equals(Position.class)) {
            Position castedArg = (Position)arg;
            moveDisk(castedArg);
            sleep();
        }

    }


    /**
     * When this method is called
     * the display is updated when the back-end changes.
     *
     * @param button
     *            the button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
