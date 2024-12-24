package ADTS;

import java.security.Key;
import java.util.Comparator;
import java.util.List;

public class MapHelper {
    /**
     * 返回key的索引值，没有返回-1
     * @param map
     * @param key
     * @return
     * @param <K>
     * @param <V>
     */
    public static <K,V> V get(ArrayMap<K,V> map, K key) {
        if(map.containsKey(key)){
            return map.get(key);
        }else{
            return null;
        }
    }

    /**
     * 接收key的列表，从中找到最大的key，<K extends Comparable<K>,V>限定了传入的key列表必须实现comparable接口
     * @param map
     * @return
     * @param <K>
     * @param <V>
     */
    public static <K extends Comparable<K>,V> K maxKey(ArrayMap<K,V> map){
        List<K> keys = map.keys();
        K maxKey = keys.getFirst();
        for(K k: keys){
            if(k.compareTo(maxKey)>0){
                maxKey = k;
            }
        }
        return maxKey;
    }

}
