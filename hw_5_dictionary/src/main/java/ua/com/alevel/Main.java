package ua.com.alevel;

public class Main {
    public static void main(String[] args) {
        Dictionary<Integer, String> dictionary = new Dictionary<>();
        Dictionary<Integer, String> otherDictionary = new Dictionary<>();

        put(dictionary);
        put(otherDictionary);

        System.out.println(dictionary.getDictionary());

        System.out.println("size " + dictionary.size());
        System.out.println("is empty " + dictionary.isEmpty());

        System.out.println("containsKey 1" + dictionary.containsKey(1));
        System.out.println("containsKey 2" + dictionary.containsKey(2));
        System.out.println("containsKey 3" + dictionary.containsKey(3));
        System.out.println("containsKey 4" + dictionary.containsKey(4));
        System.out.println("containsKey 5" + dictionary.containsKey(5));
        System.out.println("containsKey 6" + dictionary.containsKey(6));

        System.out.println("value by key 1" + dictionary.get(1));
        System.out.println("value by key 2" + dictionary.get(2));
        System.out.println("value by key 3" + dictionary.get(3));
        System.out.println("value by key 4" + dictionary.get(4));
        System.out.println("value by key 5" + dictionary.get(5));

        System.out.println("remove key 1" + dictionary.remove(1));
        System.out.println("remove key 2" + dictionary.remove(2));
        System.out.println("remove key 3" + dictionary.remove(3));
        System.out.println("remove key 4" + dictionary.remove(4));
        System.out.println("remove key 5" + dictionary.remove(5));
        System.out.println(dictionary.getDictionary());

        System.out.println("put all" + dictionary.putAll(otherDictionary));
        System.out.println("clear " + dictionary.clear());

        put(dictionary);

        System.out.println("key set" + dictionary.keySet());
        System.out.println("values" + dictionary.values());

    }

    static <K, V> void put(Dictionary<Integer, String> dictionary) {
        dictionary.put(1, "hello");
        dictionary.put(2, "world");
        dictionary.put(3, "how");
        dictionary.put(4, "are");
        dictionary.put(5, "you");
    }
}