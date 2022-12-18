// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dheer Prajapati dheer
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * The LinkedStack class which Implements the
 * StackInterface.
 *
 * @author dheer prajapati (dheer)
 * @version 2022-10-17
 * @param <T>
 *            the generic type
 */
public class LinkedStack<T> implements StackInterface<T> {

    /** The size field */
    private int size;

    /** The top node field */
    private Node<T> topNode;

    /**
     * LinkedStack Constructor which
     * instantiates topNode to be
     * null by deault.
     */
    public LinkedStack() {
        topNode = null;
    }


    /**
     * A method which returns the size of the linked
     * stack.
     *
     * @return the int
     */
    public int size() {
        return size;
    }


    /**
     * Checks if the linkedStack is empty
     *
     * @return true, if is empty(size = 0)
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * A method that clears the linkedStack.
     */
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * A method that forms a linkedStack into
     * a string version by surrounding the element
     * in brackets and separating each element with
     * commas.
     *
     * @return the string
     */
    public String toString() {
        Node<T> currentNode = topNode;
        String s = "[";
        if (currentNode != null) 
        {
            s += currentNode.getData().toString();
            currentNode = currentNode.getNextNode();
        }
        while (currentNode != null) {
            s += ", " + currentNode.getData().toString();
            currentNode = currentNode.getNextNode();

        }
        return s + "]";
    }


    /**
     * Pushs an specified entry onto the top
     * of the stack.
     *
     * @param newEntry
     *            the entry being pushed.
     */
    public void push(T newEntry) {
        topNode = new Node<T>(newEntry, topNode);
        size++;
    }


    /**
     * Checks if the stack is empty and then
     * gets the top Entry of the stack.
     *
     * @return the top entry's data.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Pops or removes the top element in the stack.
     *
     * @return the removed element.
     */
    public T pop() {
        T topThing = peek();
        topNode = topNode.getNextNode();
        size--;
        return topThing;
    }

    /**
     * THis private class implements the
     * standard methods for a node.
     *
     * @param <T>
     *            the generic type
     */
    private class Node<T> {

        /** The data field */
        private T data;

        /** The next field */
        private Node<T> next;

        /**
         * Instantiates a new node.
         *
         * @param entry
         *            the passed entry
         * @param node
         *            the passed node
         */
        private Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * sets the nextNode to be the node
         * in the parameter.
         *
         * @param nextNode
         *            the node to be set to.
         */
        private void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }


        /**
         * Node constructor that only takes
         * in data.
         *
         * @param data
         *            the data passed in.
         */
        private Node(T data) {
            this.data = data;
        }


        /**
         * a method that gets the next node.
         *
         * @return the next node
         */
        private Node<T> getNextNode() {
            return next;
        }


        /**
         * A method that gets the data
         *
         * @return the data
         */
        private T getData() 
        {
            return data;
        }

    }

}
