class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            String s = arr[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            
            String key = new String(c);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(arr[i]);
        }
        
        return new ArrayList<>(map.values());
    }
}