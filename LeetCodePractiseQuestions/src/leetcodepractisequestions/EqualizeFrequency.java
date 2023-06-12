/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.HashMap;

/**
 *
 * @author hkorada
 */
public class EqualizeFrequency {

    public static void main(String[] args) {
        String word = "abcc";

        HashMap<Character, Integer> m = new HashMap<>();
        String arr[] = word.split("");
        for (int i = 0; i < arr.length; i++) {
            char c = word.charAt(i);
            if (!m.containsKey(c)) {
                m.put(c, 0);
            }
            m.put(c, m.get(c) + 1);
        }
        
        
        System.out.println(m);

    }

    public void deleteChar(String word) {
//        word.
    }

}
