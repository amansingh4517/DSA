package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniques {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        HashMap<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, max = -1 ;
		while (j < s.length()) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			if (map.size()>k) {
				while (map.size()>k) {
					char rCh = s.charAt(i);
					if (map.get(rCh)>1)
						map.put(rCh, map.get(rCh) - 1);
					else
						map.remove(rCh);
					i++;
				}
			}
			if (map.size() == k)
				max = Math.max(max, j - i + 1);
			j++;
			
		}
		System.out.println(max);
    }
}
