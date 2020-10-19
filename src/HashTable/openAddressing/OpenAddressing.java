package HashTable.openAddressing;

import HashTable.IHashTable;

/**
 * 开放寻址法
 * @param <K>
 * @param <V>
 */
public class OpenAddressing<K, V> implements IHashTable<K, V> {
    private HashNode[] hashNodes;
    private int capacity;
    private int size;

    public OpenAddressing() {
        this.capacity = 5;
        hashNodes = new HashNode[capacity];

    }

    public OpenAddressing(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        int startIndex = index;
        while(hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                hashNodes[index].value = value;
                return;
            }
            index++;
            index = index % capacity;
            if (index == startIndex) {
                resize();
                index = hash(key);
                startIndex = index;
            }
        }
        hashNodes[index] = new HashNode(key, value);
        size++;
    }

    private void resize() {
        capacity = capacity * 2;
        HashNode[] oldHashNodes = hashNodes;
        hashNodes = new HashNode[capacity];
        size = 0;
        for (int i = 0; i < oldHashNodes.length; i++) {
            if (oldHashNodes[i] != null) {
                put((K) oldHashNodes[i].key, (V) oldHashNodes[i].value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        while(hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                return (V) hashNodes[index].value;
            }
            index++;
            index = index % capacity;
        }

        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);
        while(hashNodes[index] != null) {
            if (hashNodes[index].key.equals(key)) {
                V value = (V) hashNodes[index].value;
                hashNodes[index] = null;
                size--;
                return value;
            }
            index++;
            index = index % capacity;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> hashNode: hashNodes) {
            if (hashNode != null) {
                System.out.println("key: " + hashNode.key + " value: " + hashNode.value);
            }
        }

        System.out.println("size: " + size);
        System.out.println("capacity: " + capacity);
    }
}
