class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int res = 0;
        for(int high = 0; high < s.length(); high++){
            char c = s.charAt(high);
            int len = high - low + 1;
            map.put(c,map.getOrDefault(c, 0) + 1);
            while(map.size() < len){
                char lc = s.charAt(low);
                map.put(lc, map.getOrDefault(lc, 0) - 1);
                if(map.get(lc) == 0)
                    map.remove(lc);
                low++;
                len = high - low + 1;
            }
            res = Math.max(len, res);
        }
        return res;
    }
}