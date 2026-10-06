class Solution {
    public int maxArea(int[] height) {

        int fp = 0; 
        int sp = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(fp < sp){
            int diff = sp - fp;
            int product;
            if(height[fp] < height[sp]){
                product = diff * height[fp];
                fp++;
            } else{
                product = diff * height[sp];
                sp--;
            }
            if(product > max){
                max = product;
            }
        }
        return max;
    }
}