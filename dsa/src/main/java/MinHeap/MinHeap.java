package MinHeap;

import java.util.ArrayList;

public class MinHeap {
    private final ArrayList<Integer> data;
    public int length;

    public MinHeap() {
        this.data = new ArrayList<>();
        this.length = 0;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }
    private int leftChild(int idx) {
        return 2 * idx + 1;
    }
    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    public void insert(int value) {
        this.data.add(this.length, value);
        this.heapifyUp(this.length);
        this.length++;
    }

    public int delete() {
        if(this.length == 0) return -1;

        int out = this.data.get(0);
        this.length--;
        if(this.length == 0) {
            this.data.clear();
            return out;
        }
        this.data.set(0, this.data.get(this.length));
        this.heapifyDown(0);
        return out;
    }

    private void heapifyUp(int idx) {
       if(idx == 0) return;

       int parent = this.parent(idx);
       int pValue = this.data.get(parent);
       int val = this.data.get(idx);

       if(pValue > val) {
           this.data.set(idx, pValue);
           this.data.set(parent, val);
           this.heapifyUp(parent);
       }
    }

    private void heapifyDown(int idx) {
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);

        if(idx >= this.length || lIdx >= this.length) return;

        int lValue = this.data.get(lIdx);
        int rValue = this.data.get(rIdx);
        int val = this.data.get(idx);

        if(lValue > rValue && val > rValue) {
            this.data.set(idx, rValue);
            this.data.set(rIdx, val);
            this.heapifyDown(rIdx);
        } else if(lValue < rValue && val > lValue) {
            this.data.set(idx, lValue);
            this.data.set(lValue, val);
            this.heapifyDown(lIdx);
        }
    }
}
