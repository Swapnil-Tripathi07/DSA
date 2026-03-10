class MyHashMap {

    private int size = 1000;
    private LinkedList<Pair>[] bucket;

    class Pair {
        int key;
        int value;

        Pair(int k, int v){
            key = k;
            value = v;
        }
    }

    public MyHashMap() {
        bucket = new LinkedList[size];
    }

    private int hash(int key){
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if(bucket[index] == null)
            bucket[index] = new LinkedList<>();

        for(Pair p : bucket[index]){
            if(p.key == key){
                p.value = value;
                return;
            }
        }

        bucket[index].add(new Pair(key,value));
    }

    public int get(int key) {
        int index = hash(key);

        if(bucket[index] == null)
            return -1;

        for(Pair p : bucket[index]){
            if(p.key == key)
                return p.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        if(bucket[index] == null)
            return;

        bucket[index].removeIf(p -> p.key == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */