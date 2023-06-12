/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcodepractisequestions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hkorada
 */
public class MyHashSet {

    List<Integer> hashset;

    public MyHashSet() {
        hashset = new ArrayList<>();
    }

    public void add(int key) {
        if (hashset.contains(key)) {
            // dont add
        } else {
            hashset.add(key);
        }

    }

    public void remove(int key) {
        int index = 0;
        boolean containsKey = false;
        for (Integer integer : hashset) {
            if (key == integer) {
                containsKey = true;
                break;
            }
            index++;
        }
        if (containsKey) {
            hashset.remove(index);
        }
    }

    public boolean contains(int key) {
        return hashset.contains(key);
    }

    public void print() {
        System.out.println(hashset);
    }

    public static void main(String[] args) {
        MyHashSet my = new MyHashSet();
        my.add(1);
        my.add(2);

        System.out.println(my.contains(1));
        System.out.println(my.contains(3));
        my.print();
        my.add(2);
        my.print();

        System.out.println(my.contains(2));

        my.remove(2);
        System.out.println(my.contains(2));
        my.print();
    }
}
