/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class AddBinary {

    public static void main(String[] args) {
//        int index = lengthOfLastWord("   fly me   to   the moon  ");
//        int index = lengthOfLastWord("luffy is still joyboy");r
        String index = addBinary("1010", "1011");
//        String index = addBinary("11", "1");

        System.out.println(index);
    }

    public static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0, carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            sum = carry;
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }
            carry = sum / 2;
            result.append((char)(sum % 2 + '0'));
//            carry = sum % 2;

            i--;
            j--;
        }

        
        return result.reverse().toString();

    }
}
