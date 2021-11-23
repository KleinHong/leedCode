package com.hzy.find.work.part1;

import java.util.Arrays;

public class S3 {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        if (s.length() == 1) {
//            return 1;
//        }
//        int maxLen = 0;
//        Set<Character> set = new HashSet();
//        set.add(s.charAt(0));
//        int index1 = 0, index2 = 1;
//        while (index2 < s.length() && index1 < index2) {
//            while (set.contains(s.charAt(index2))) {
//                set.remove(s.charAt(index1));
//                index1++;
//            }
//            maxLen = Math.max(maxLen, index2 - index1 + 1);
//
//            set.add(s.charAt(index2));
//            index2++;
//
//        }
//        return maxLen;
//    }

    public int lengthOfLongestSubstring(String s) {
        int[] tempArr = new int[128];
        Arrays.fill(tempArr, -1);
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = s.charAt(i);
            start = Math.max(start, tempArr[lastIndex] + 1);
            maxLen = Math.max(maxLen, i - tempArr[lastIndex] + 1);
            tempArr[lastIndex] = i;
        }
        return maxLen;
    }
}
