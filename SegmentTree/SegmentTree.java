package SegmentTree;

import java.util.*;

public class SegmentTree {

    private int[] tree;
    private int[] lazyTree;

    public SegmentTree(int[] arr) {
        this.tree = new int[4 * arr.length];
        this.lazyTree = new int[4 * arr.length];
        buildTree(arr, 0, 0, arr.length - 1);

    }

    // Build Segment Tree
    private void buildTree(int arr[], int i, int low, int high) {
        if (low == high) { // if single index/leaf node
            this.tree[i] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        buildTree(arr, 2 * i + 1, low, mid); // left child = 2i+1
        buildTree(arr, 2 * i + 2, mid + 1, high); // right child = 2i+2

        this.tree[i] = this.tree[2 * i + 1] + this.tree[2 * i + 2];
    }

    public int[] getSegmentTree() {
        return this.tree;
    }

    public int[] getLazyTree() {
        return this.lazyTree;
    }

    public int query(int i, int start, int end, int low, int high) {
        // start , end -> range of query
        // low , high -> range of current node

        if (end < low || high < start) // curr range of node is totally out of query range
            return 0;
        if (start <= low && high <= end) // curr range of node is totally out of query range
            return tree[i];

        // Partially cover the qur

        int mid = (low + high) / 2;
        int l = query(2 * i + 1, start, end, low, mid);
        int r = query(2 * i + 2, start, end, mid + 1, high);

        return r + l; // return according to condition
    }

    public void updateElement() {

    }

    public void rangeUpdate(int i, int low, int high, int start, int end, int val) {

        // Case 1: No overlap
        if (high < start || low > end) {
            return;
        }

        // Apply any pending update before descending
        if (lazyTree[i] != 0) {
            int pending = lazyTree[i];

            tree[i] += (high - low + 1) * pending;

            if (low != high) {
                lazyTree[2 * i + 1] += pending;
                lazyTree[2 * i + 2] += pending;
            }

            lazyTree[i] = 0;
        }

        // Case 2: Complete overlap
        if (start <= low && high <= end) {
            tree[i] += (high - low + 1) * val;

            if (low != high) {
                lazyTree[2 * i + 1] += val;
                lazyTree[2 * i + 2] += val;
            }

            return;
        }

        // Case 3: Partial overlap
        int mid = low + (high - low) / 2;

        rangeUpdate(2 * i + 1, low, mid,start, end, val);

        rangeUpdate(2 * i + 2, mid + 1, high,start, end, val);

        // Recalculate the parent
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

}