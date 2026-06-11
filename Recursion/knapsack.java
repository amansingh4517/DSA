class knapsack{
    // 0\1 knapsack

    //this is 0/1 knapsack only one time a item can be picked no repeat 
    static int zeroOne(int[] w , int[] v , int c , int n){
        if(n==0 || c==0) return 0;
        if(w[n-1]>c)  return zeroOne(w , v , c , n-1);
        else {
            return Math.max(v[n-1] + zeroOne(w,v,c-w[n-1] , n-1) , zeroOne(w,v,c,n-1));
        }
    }

    // unbounded knapsack

    // in this item can be picked repeatedly to achive goal
    static int unbounded(int[] w , int[] v , int c , int n){
        if(n==0 || c==0) return 0;
        if(w[n-1]>c)  return unbounded(w , v , c , n-1);
        else {

            int temp =  Math.max(v[n-1] + unbounded(w,v,c-w[n-1] , n-1) , unbounded(w,v,c,n-1));
            return Math.max(v[n-1] + unbounded(w,v,c-w[n-1] , n) , temp);
        }
    }



    
    public static void main(String[] args) {
        int[] weight = {1,3,5,6,8};
        int[] value = {1,2,4,5,3};
        int capacity =  14;
        System.out.print("Considering 0/1 problem : ");
        System.out.println(zeroOne(weight , value , capacity , weight.length));
        System.out.print("Considering unbounded (can repeat) problem : ");
        System.out.println(unbounded(weight , value , capacity , weight.length));
    }
}