class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int res[] = new int[q.length];
        for(int i = 0; i < q.length; i++){
            int start = q[i][0];
            int end = q[i][1];
            int val = 0;
            for(int j = start; j <= end; j++){
                val ^= arr[j];
            }
            res[i] = val;
        }
        return res;
    }
}