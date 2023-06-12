/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hkorada
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.summaryRanges(new int[]{});
//        char ch[] = {'c', 'f', 'j'};
//        System.out.println(s.nextGreatestLetter(ch, 'a'));
//        System.out.println(s.nextGreatestLetter(ch, 'c'));
//        System.out.println(s.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
//        System.out.println(s.nextGreatestLetter(ch, 'd'));
//        System.out.println(s.nextGreatestLetter(ch, 'g'));//j
//        System.out.println(s.nextGreatestLetter(ch, 'j'));//j
//        for (char c = 'a'; c <= 'z'; c++) {
//            System.out.println(Character.getNumericValue(c) + " == " + c);
//        }

//        int grid[][] = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        System.out.println(s.countNegatives(grid));
//        System.out.println(s.minFlips(2, 10, 5));
//        int arr[] = {3, 5, 1};
////        int arr[] = {1, 0, -1};
//        System.out.println(s.canMakeArithmeticProgression(arr));
    }
    
    public void ParenthesisChecker(String input){
        
        
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums.length<=0){
            return new ArrayList<>();
        }
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end || nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    ranges.add(start + "");
                } else {
                    ranges.add(start + "->" + end);
                }

                start = end = nums[i];
            }
        }

        if (start == end) {
            ranges.add(start + "");
        } else {
            ranges.add(start + "->" + end);
        }
        return ranges;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int minFlips(int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int bit1 = c & 1;
            int bit2 = b & 1;
            int bit3 = a & 1;

            if (bit1 == 1) {
                if (bit2 == 0 && bit3 == 0) {
                    ans++;
                }
            } else {
                if (bit2 == 1 && bit3 == 1) {
                    ans += 2;
                } else if (bit2 == 1 || bit3 == 1) {
                    ans++;
                }
            }
            c = c >> 1;
            b = b >> 1;
            a = a >> 1;

        }
        return ans;
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int firstVal = arr[0];//1
        int prevDiff = arr[1] - firstVal;//3-1 = 2
        System.out.println(prevDiff);
        for (int i = 1; i < arr.length; i++) {
            int second = arr[i];//3

            if (prevDiff != (second - firstVal)) {
                return false;
            }
            prevDiff = (second - firstVal);
            firstVal = second;
        }
        return true;
    }
}
