package be.ugent.tiwi.datastructures.lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList implements SortedList {

    private float probabilty = 0.5f;

    SortedLinkedList root;
    public SkipList(float probability, int layerCount){
        this.probabilty = probability;


    }
    @Override
    public void insert(int key) {

    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public void print() {

    }
}
