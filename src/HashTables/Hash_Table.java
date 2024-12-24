package HashTables;

import java.util.HashSet;
import java.util.Set;

//通过计算哈希值找到对应位置创建列表，放入创建的列表中
public class Hash_Table<K,V> {
    private static class MapNode<K,V>{
        K key;
        V value;
        MapNode<K,V> next;
        public MapNode(K key,V value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    private int size;
    private MapNode<K,V>[] buckets;
    private int capacity =8;
    public Hash_Table(){
        this.size=0;
        this.buckets=(MapNode<K, V>[]) new MapNode[capacity];
    }
    public int hash(K key){
        return key.hashCode()%capacity;
    }

    public void put(K key,V value){
        int index = hash(key);
        MapNode<K,V> node = new MapNode<>(key,value);
        if(buckets[index]==null){
            buckets[index] = node;
        }else{
            MapNode<K,V> head = buckets[index];
            while(head !=null){
                if(head.key.equals(key)){
                    head.value = value;
                    return;
                }
                if(head.next ==null){
                    break;
                }
                head = head.next;
            }
            head.next = node;
        }
        size +=1;
        if((1.0*size)/capacity>0.75){
            resize();
        }
    }

    private void resize() {
        MapNode<K,V>[] OldBuckets = buckets;
        buckets = new MapNode[2*capacity];
        capacity *=2;
        size = 0;
        for(MapNode<K,V> head : OldBuckets){
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public Set<K> KeySet(){
        Set<K> set = new HashSet<>();
        for(MapNode<K,V> head : buckets){
            while (head != null) {
                set.add(head.key);
                head = head.next;
            }
        }
        return set;
    }

    private  int size() {
        return size;
    }

    public V get(K key){
        int index = hash(key);
        MapNode<K,V> head = buckets[index];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        MapNode<K,V> head = buckets[index];
        MapNode<K,V> pre = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            pre = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        if(pre == null){
            buckets[index] = head.next;
        }else{
            pre.next = head.next;
        }
        V value = head.value;
        size -=1;
        return value;
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public boolean containsValue(V value){
        for(MapNode<K,V> head : buckets){
            while(head != null){
                if(value == null && head.value == null || (value != null && value.equals(head.value))){
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        buckets = (MapNode<K,V>[])new MapNode[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        Hash_Table<String, Integer> hashTable = new Hash_Table<>();
        hashTable.put("One", 1);
        hashTable.put("Two", 2);
        hashTable.put("Three", 3);

        // 测试包含的值
        System.out.println("Contains value 2? " + hashTable.containsValue(2)); // Expected: true
        System.out.println("Contains value 4? " + hashTable.containsValue(4)); // Expected: false
        System.out.println("Contains value null? " + hashTable.containsValue(null)); // Expected: false

        hashTable.put("Four", null);
        System.out.println("Contains value null? " + hashTable.containsValue(null)); // Expected: true
    }

}
