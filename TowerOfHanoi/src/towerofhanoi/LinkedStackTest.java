
package towerofhanoi;

/**
 * The LinkedStackTest class which
 * tests all the methods in
 * The linkedStack Class.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 */
public class LinkedStackTest extends student.TestCase {

    /** The stack field. */
    private LinkedStack<String> stack;

    /**
     * This method runs before each test
     * method.
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }


    /**
     * Tests the size method by
     * checking that the size of the current stack
     * is equal.
     */
    public void testSize() {
        assertEquals(0, stack.size());
    }


    /**
     * Checks the isEmpty Method by checking
     * that the method is returning true when the
     * stack isEmpty then checking that the method
     * is returning false if the stack had a entry in it.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("1");
        assertFalse(stack.isEmpty());
    }


    /**
     * A test method for clear which first adds an item to the
     * stack then clears and then asserting that the size became 0 after
     * the method ran.
     */
    public void testClear() {
        stack.push("1");
        stack.clear();
        assertEquals(0, stack.size());
    }


    /**
     * A test method for toString which checks what the string would
     * look like if there was nothing in the stack and what the string
     * would look like if there where two elements in the stack.
     */
    public void testToString() {
        assertEquals("[]", stack.toString());
        stack.push("1");
        stack.push("2");
        assertEquals("[2, 1]", stack.toString());
    }


    /**
     * Tests the push method by adding items to the stack
     * and then seeing if the top element of the stack lines up with
     * the most recent added element and if the size lines up with the
     * amount of elements added to the stack.
     */
    public void testPush() {
        stack.push("1");
        stack.push("5");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        assertEquals("10", stack.peek());
        assertEquals(5, stack.size());

    }


    /**
     * Tests the peek method by checking the size of the stack first
     * then adding 2 times and then asserting that the last item pushed onto the
     * stack is being returned by peek.
     */
    public void testPeek() {
        assertEquals(0, stack.size());
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.peek());
    }


    /**
     * Checks that peek throws an exception when isEmpty.
     */
    public void testPeekException() {
        Exception thrown = null;
        try {
            stack.peek();

        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    /**
     * Tests the pop method by pushing 2 items to the stack then asserting that
     * Those two items are being returned when popped.
     */
    public void testPop() {
        stack.push("1");
        stack.push("2");
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
    }
}
