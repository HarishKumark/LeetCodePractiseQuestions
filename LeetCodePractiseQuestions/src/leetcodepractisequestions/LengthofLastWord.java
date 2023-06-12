/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

/**
 *
 * @author hkorada
 */
public class LengthofLastWord {

    public static void main(String[] args) {
//        int index = lengthOfLastWord("   fly me   to   the moon  ");
//        int index = lengthOfLastWord("luffy is still joyboy");
        int index = lengthOfLastWord("Hello World");

        System.out.println(index);
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String lastWord = "";
        for (String str : s.split(" ")) {
            if (!str.isEmpty()) {
                lastWord = str;
            }
        }
        return lastWord.length();
    }
}
