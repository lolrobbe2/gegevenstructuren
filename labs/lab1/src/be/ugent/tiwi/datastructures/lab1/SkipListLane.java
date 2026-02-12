package be.ugent.tiwi.datastructures.lab1;

public class SkipListLane{
    private static class LayerNode {

        public int getKey() {
            return key;
        }

        private final int key;

        private LayerNode left;
        private LayerNode right;
        private LayerNode bottom;

        public LayerNode(int key, LayerNode left,LayerNode right, LayerNode bottom) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }

        LayerNode GetNext(int requestedKey){
            if(requestedKey == key)
                return  bottom;
            return requestedKey > key ? right : left;
        }

        public LayerNode getLeft() {
            return left;
        }

        public void setLeft(LayerNode left) {
            this.left = left;
        }

        public LayerNode getBottom() {
            return bottom;
        }

        public void setBottom(LayerNode bottom) {
            this.bottom = bottom;
        }

        public LayerNode getRight() {
            return right;
        }

        public void setRight(LayerNode right) {
            this.right = right;
        }
    }

    private LayerNode start;
    int size = 0;
    public void insert(int key) {
        if(size == 0){
            start = new LayerNode(key,null,null,null);
            size++;
            return;
        }
        LayerNode current = start;
        LayerNode previous = null;
        //walk to the list until we found the end
        while (current != null) {
            if(current.getKey() > key && previous != null && previous.getKey() < key){
                //indertion
                current.left = new LayerNode(key,previous,current,null);
                previous.right = current.left;
                return;
            }
            previous = current;
            current = current.GetNext(key);
        }
        if(key < previous.key){
            previous.left = new LayerNode(key,current,previous,null);//TODO bottom
        } else {
            previous.right = new LayerNode(key, previous,current,null);//TODO bottom
        }
        size++;
    }

    public void remove(int key) {

    }
}
