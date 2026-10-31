package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {

        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28} ;
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            if(arr[i]<0) q.add(arr[i]);
        }
        if(q.isEmpty()) ans.add(0);
        else ans.add(q.peek());
        for(int i = k ; i < arr.length ; i++){
            if(arr[i]<0) q.add(arr[i]);
            if(arr[i-k]<0) q.remove();
            if(q.isEmpty()) ans.add(0);
            else ans.add(q.peek());
            
        }
        System.out.println(ans);
    }
}
