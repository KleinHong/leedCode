package com.hzy.find.work.part1;

import java.util.Arrays;
import java.util.HashMap;

public class S1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            res[0]=i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Demo[] temp = new Demo[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i]=new Demo(i,nums[i]);
        }
        Arrays.sort(temp,(s1,s2)->s1.value-s2.value);
        int left=0;
        int right=temp.length-1;
        while (left<right){
            int sum=temp[left].value
                    +temp[right].value;
            if (sum==target){
                res[0]=temp[left].index;
                res[1]=temp[right].index;
                return res;
            }
            if (sum>target){
                right--;
            }
            if (sum<target){
                left++;
            }
        }
        return res;
    }

    public static class Demo{
        public int index;
        public int value;

        public Demo (int index,int value){
            this.index=index;
            this.value=value;
        }
    }
}
