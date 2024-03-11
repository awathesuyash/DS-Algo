class Solution {
    public String customSortString(String order, String s) {
  //  Input:  order = "cba", s = "abcd"
  //  Output:  "cbad"    
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
     StringBuilder result=new StringBuilder();
     for(int i=0;i<order.length();i++)
     {
         char val=order.charAt(i);

           if(map.containsKey(val))
           {
             result.append(String.valueOf(val).repeat(map.get(val)));
           }
           map.remove(val);
         
     }

     for(char c:map.keySet())
     {
         result.append(String.valueOf(c).repeat(map.get(c)));
     }
        return result.toString();
    }
}
