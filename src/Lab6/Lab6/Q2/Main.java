package Lab6.Q2;

public class Main {
    public static void main(String[] args) {
        // a. Test these two implementations
        MyMap_a objectMap = new MyMap_a();
        objectMap.put("key1", "value1");
        System.out.println("Object Map: " + objectMap.get("key1"));

        MyMap_b<String, String> genericMap = new MyMap_b<>();
        genericMap.put("key2", "value2");
        System.out.println("Generic Map: " + genericMap.get("key2"));

        // b. To show advantage of generic type over Object
        String value1 = (String) objectMap.get("key1");
        System.out.println("Object Map with casting: " + value1);

        // With the Generic map, no casting is needed
        String value2 = genericMap.get("key2");
        System.out.println("Generic Map without casting: " + value2);

        // c. To show advantage of parameterized type over generic raw type

        MyMap_b<String, Object> rawMap = new MyMap_b<>();
        rawMap.put("key3", "value3");
        rawMap.put("key4", 123);  

        // Check the type with the parameterized type
        MyMap_b<String, String> paramTypeMap = new MyMap_b<>();
        paramTypeMap.put("key5", "value5");
    }
}