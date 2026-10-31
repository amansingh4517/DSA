package SegmentTree;
import SegmentTree;
import java.util.*;

public class Test{
    public static void main(String[] args){
        int[] arr = {1,2,5,3,6,3,38,20,1};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(Arrays.toString(st.getSegmentTree()));
    }
}
