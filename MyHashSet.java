class MyHashSet {

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
}
