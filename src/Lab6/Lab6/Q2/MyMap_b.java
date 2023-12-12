package Lab6.Q2;

import java.util.HashMap;

 // b. Use generic type
public class MyMap_b <K, V> {
    private HashMap <K, V> map;

    public MyMap_b() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }
}

