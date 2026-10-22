class Solution {
    public int kthFactor(int n, int k) {
        int res = -1;
        List<Integer> fact = new ArrayList<>();
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0)
                fact.add(i);
        }
        fact.add(n);
        if(k <= fact.size()) return fact.get(k - 1);
        return res;
    }
}