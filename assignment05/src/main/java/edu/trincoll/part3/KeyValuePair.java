package edu.trincoll.part3;
/**
 * Represents a key-value pair.
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public class KeyValuePair<K, V> {
    private final K key;
    private V value;

    /**
     * Constructs a new KeyValuePair.
     * @param key The key
     * @param value The value
     */
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return The key of this pair
     */
    public K getKey() {
        return key;
    }

    /**
     * @return The value of this pair
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets a new value for this pair.
     * @param value The new value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Checks if this KeyValuePair is equal to another object.
     * Two KeyValuePairs are considered equal if both their keys and values are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof KeyValuePair)) return false;

        KeyValuePair<?, ?> that = (KeyValuePair<?, ?>) obj;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    /**
     * Generates a hash code for this KeyValuePair.
     * The hash code is based on both the key and the value.
     */
    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
