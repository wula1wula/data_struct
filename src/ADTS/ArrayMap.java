package ADTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrayMap<K,V> {
    private int maxIndex = 100;
    private K[] keys;
    private V[] values;
    private int size;
    public ArrayMap(){
        keys = (K[])new Object[maxIndex];
        values = (V[])new Object[maxIndex];
        size = 0;
    }

    /**
     * 返回key的索引值，没有返回-1
     * @param key
     * @return
     */
    private int KeyIndex(K key){
        for(int i = 0;i<size;i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 检测有没有key值
     * @param key
     * @return
     */
    public boolean containsKey(K key){
//        int index = KeyIndex(key);
//        return index >-1;
        return KeyIndex(key) > -1;
    }

    /**
     * 添加key和value值，如果已存在更新value值
     * @param key
     * @param value
     */
    public void put(K key,V value){
        int index = KeyIndex(key);
        if(index == -1){
            if(size== maxIndex){
                throw new RuntimeException("数组已满");
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }else{
        values[index] = value;
        }
    }

    /**
     * 返回key键的value值
     * @param key
     * @return
     */
    public V get(K key){
        int index = KeyIndex(key);
        return values[index];
    }

    /**
     * 返回数组数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 返回key列表
     * @return
     */
    public List<K> keys(){
        List<K> keylist = new ArrayList<>();
        for(int i=0 ; i< size;i++){
            keylist.add(keys[i]);
        }
        return keylist;
    }

}
