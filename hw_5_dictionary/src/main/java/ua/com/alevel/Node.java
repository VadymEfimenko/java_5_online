package ua.com.alevel;

public class Node<K, V> {

    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "key=" + key +
                ", value=" + value +
                "}";
    }
}
