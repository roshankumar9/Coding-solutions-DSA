class Solution {
    public boolean prime(int n){
        int fact = 0;
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0)
                fact++;
            if(fact > 1)
                return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime(i))
                count++;
        }
        return count;
    }
}