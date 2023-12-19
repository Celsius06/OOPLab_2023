package Lab6.Q2;

import java.util.HashMap;

// a. Use Object as the type for both the Key and the Value parameters
public class MyMap_a {
    private HashMap<Object, Object> map;

    public MyMap_a() {
        map = new HashMap<>();
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    public Object get(Object key) {
        return map.get(key);
    }
}
