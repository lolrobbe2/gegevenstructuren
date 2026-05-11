package be.ugent.tiwi.datastructures.lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList implements SortedList {

    private float probability = 0.5f;
    private final Random random = new Random();
    private final ArrayList<SkipListLane> lanes;
    private int size = 0;
    public SkipList(float probability, int layerCount){
        this.probability = probability;
        this.lanes = new ArrayList<>();

        for (int i = 0; i < layerCount; i++) {
            lanes.add(new SkipListLane());
        }
    }
    @Override
    public void insert(int key) {
        SkipListLane.LayerNode previous = null;
        for (int i = lanes.size(); i > 0; i--) {
            if (random.nextBoolean()) {
                for (int j = i; j < lanes.size() - 1; j++) {
                    SkipListLane.LayerNode current = lanes.get(j).insert(key);
                    if(previous == null){
                        previous = current;
                    } else {
                        current.setBottom(previous);
                    }
                }
                break;
            }
        }

        SkipListLane.LayerNode node = lanes.get(lanes.size() - 1).insert(key);
        if(previous != null) {
            previous.setBottom(node);
        }
        size++;
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
