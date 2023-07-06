/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hkorada
 */
public class Solution {

    ListNode head;

    static class ListNode {

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1, lastIndex = -1;
        int[] res = new int[]{firstIndex, lastIndex};
        if (nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == target) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    lastIndex = i;
                }
            }
        }
        if (lastIndex == -1) {
            res[0] = res[1] = firstIndex;
        } else {
            res[0] = firstIndex;
            res[1] = lastIndex;
        }
        return res;
    }

    public int[] getAverages(int[] nums, int k) {
        int len = nums.length - 1;
        if (k == 0) {
            return nums;
        }
        int newarr[] = new int[len + 1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = -1;
        }
        for (int j = 0; j < len; j++) {
            int sum = 0, count = 0;
            int mk = j - k;
            int ak = j + k;
            if (mk < 0) {
                continue;
            }
            if (ak > len) {
                continue;
            }
            for (int l = mk; l <= ak; l++) {
                sum += nums[l];
                count++;
            }
            newarr[j] = (sum / count);
        }
        return newarr;

    }

    public long minCost(int[] nums, int[] cost) {
        int len = nums.length - 1;
        int firstIndex = 1;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            int numsVal = nums[i];
            if ((numsVal < firstIndex) || (numsVal > firstIndex)) {
                sum += Math.abs(numsVal - firstIndex) * cost[i];
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void removeDuplicatesInStr(String str, boolean b[], String newStr, int idx) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (b[currChar - 'a']) {
            removeDuplicatesInStr(str, b, newStr, idx + 1);
        } else {
            newStr += currChar;
            b[currChar - 'a'] = true;
            removeDuplicatesInStr(str, b, newStr, idx + 1);
        }
    }

    public static void subsequence(String str, int idx, String newStr) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        subsequence(str, idx + 1, newStr + currChar);
        subsequence(str, idx + 1, newStr);
    }

    public long totalCost(int[] costs, int k, int candidates) {
        for (int i = 0; i < costs.length - 1; i++) {
            if (costs[i] > costs[i + 1]) {
                int temp = costs[i];
                costs[i] = costs[i + 1];
                costs[i + 1] = temp;
                i = -1;
            }
        }
        for (int i = 0; i < costs.length; i++) {
            int cost = costs[i];
            System.out.print(cost + ",");
        }
        System.out.println("");
        long totalCost = 0;
        for (int j = 0; j < k; j++) {
            totalCost += costs[j];
        }
        System.out.println("totalCost " + totalCost);
        return totalCost;
    }

    public int singleNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                return arr[i];
            }
        }
        return 0;
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");//init every sb element *important steps!!!
        }
        int incre = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                incre = 1;
            }
            if (index == numRows - 1) {
                incre = -1;
            }
            index += incre;
        }
        String re = "";
        for (int i = 0; i < sb.length; i++) {
            re += sb[i];
        }
        return re.toString();
    }

    public int longestSubarray(int[] nums) {
        int max_len = 0;
        int prev_len = 0;
        int current_len = 0;
        for (int num : nums) {
            if (num == 1) {
                current_len += 1;
                prev_len += 1;
            } else {
                max_len = Math.max(max_len, Math.max(current_len + prev_len, prev_len));
                current_len = 0;
                prev_len = current_len;
            }
        }
        return Math.max(max_len - 1, current_len);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start += 1;
            }
            end += 1;
        }
        return min;
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return "";
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }

    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
                if (m.get(num) >= 1) {
                    return true;
                }
            } else {
                m.put(num, 0);
            }
        }
        return false;
    }

    public int romanToInt(String s) {
        switch (s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

//        boolean b[] = new boolean[26];
//        String str = "abbccda";
//        subsequence(str, 0, "");
//        removeDuplicatesInStr(str, b, "", 0);
//        String str = "I2003 (Dynamic) vs I2000 BK (Dynamic)";
//        System.out.println(str.split("vs")[0]);
//
//        System.out.println(Math.round(0.003744923396681088 * 100) / 100.0);
        Solution s = new Solution();
//        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

//        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(s.gcdOfStrings("ABCDEF", "ABC"));
//        System.out.println(s.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
//        System.out.println(s.longestSubarray(new int[]{1, 0, 1, 1}));
//        System.out.println(s.convert("PAYPALISHIRING", 3));
//        System.out.println(s.convert("A", 1));
//        s.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
//        s.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4);
//        s.totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2);
//        s.minCost(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14});
//        s.minCost(new int[]{735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518},
//                new int[]{724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614});
//        s.searchRange(new int[]{1, 3}, 1);
//        s.largestAltitude(new int[]{-5, 1, 5, 0, -7});
//        s.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2});
//        int newarr[] = s.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
//        int newarr[] = s.getAverages(new int[]{100000}, 0);
//         int newarr[] = s.getAverages(new int[]{8}, 100000);
//        for (int i = 0; i < newarr.length; i++) {
//            System.out.println("newarr[i] " + newarr[i]);
//
//        }
//        s.getAverages(new int[]{8}, 100000);
//
//        s.addFirst(2);
//        s.addFirst(4);
//        s.addFirst(3);
//        s.printNode();
//        s.summaryRanges(new int[]{});
//        System.out.println("val === " + s.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
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

    public int largestAltitude(int[] gain) {
        int trip[] = new int[gain.length + 1];
        int firstVal = trip[0] = 0;
        int maxVal = 0;
        for (int i = 0; i < gain.length; i++) {
            trip[i + 1] = firstVal + gain[i];
            firstVal = trip[i + 1];
            if (firstVal > maxVal) {
                maxVal = firstVal;
            }
        }
        return maxVal;
    }

    public void printNode() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void addFirst(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp.next = new ListNode(data);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> l = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    l.add(i);
                    l.add(j);
                }
            }
        }
        System.out.println(l);
        Object[] arr = l.toArray();
        int n[] = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            n[j] = (int) arr[j];
        }
        return n;
    }

    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] rowArray = grid[i];
                int[] colArray = new int[n];
                for (int k = 0; k < n; k++) {
                    colArray[k] = grid[k][j];
                }
                if (Arrays.equals(rowArray, colArray)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void ParenthesisChecker(String input) {
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length <= 0) {
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
