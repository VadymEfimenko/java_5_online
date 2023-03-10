package ua.com.alevel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Dictionary<K, V> {

    private ArrayList<Node<K, V>> dictionary = new ArrayList<>();

    public ArrayList<Node<K, V>> getDictionary() {
        return dictionary;
    }

    public int size() {
        return dictionary.size();
    }

    public boolean put(K key, V value) {
        Node<K, V> node = new Node<>();
        node.setKey(key);
        node.setValue(value);
        if (dictionary.stream().anyMatch(kvNode -> kvNode.getKey().equals(key))) {
            Node<K, V> existingNode = dictionary.stream().filter(kvNode -> kvNode.getKey().equals(key)).findFirst().get();
            dictionary.remove(existingNode);
        }
        return dictionary.add(node);
    }

    public boolean isEmpty() {
        return dictionary.size() == 0;
    }

    public boolean containsKey(K key) {
        return dictionary.stream().anyMatch(k -> k.getKey().equals(key));
    }

    public boolean containsValue(V value) {
        return dictionary.stream().anyMatch(val -> val.getKey().equals(value));
    }

    public V get(K key) {
        return dictionary.stream()
                .filter(kvNode -> kvNode.getKey().equals(key))
                .findFirst().orElseThrow().getValue();
    }

    public boolean remove(K key) {
        return dictionary.removeIf(kvNode -> kvNode.getKey().equals(key));
    }

    public boolean putAll(Dictionary<K, V> dictionary) {
        return this.dictionary.addAll(dictionary.getDictionary());
    }

    public boolean clear() {
        dictionary.clear();
        return dictionary.isEmpty();
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        dictionary.forEach(kvNode -> set.add(kvNode.getKey()));
        return set;
    }

    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        dictionary.forEach(kvNode -> values.add(kvNode.getValue()));
        return values;
    }
}
