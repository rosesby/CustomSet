package com.mcc;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomSet<T> extends AbstractSet<T> {

    private T[] array;

    public CustomSet(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomSetIterator();
    }

    // Return the length of the array
    @Override
    public int size() {
        return array.length;
    }

    // Set the value at a given index
    public void set(int index, T value) {
        array[index] = value;
    }

    // Return the value at a given index
    public T get(int index) {
        return array[index];
    }

    private class CustomSetIterator implements Iterator<T>{
        // the current element we are looking at
        int current = 0;

        // return whether or not there are more elements in the array that
        // have not been iterated over.
        @Override
        public boolean hasNext() {
            if (current < array.length) {
                return true;
            } else {
                return false;
            }
        }

        // return the next element of the iteration and move the current
        // index to the element after that.
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[current++];
        }
    }
}
