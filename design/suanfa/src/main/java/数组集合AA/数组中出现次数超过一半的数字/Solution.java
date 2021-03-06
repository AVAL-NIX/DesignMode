package 数组集合AA.数组中出现次数超过一半的数字;

import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = 0;
        int key = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i] , map.getOrDefault(array[i] , 0) + 1);
            int temp = map.getOrDefault(array[i] , 0);
            if(temp > res){
                res = temp;
                key = array[i];
            }
        }
        return key;
    }

    public int majorityElement(int[] nums) {
        int v = nums[0];
        int count = 1;
        for(int i= 1; i< nums.length ; i++){
            if(nums[i] == v){
                count++;
            }else{
                count--;
            }
            if(count <=0){
                count = 1;
                v = nums[i];
            }
        }
        return v;
    }
}
