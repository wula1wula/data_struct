package HashTables;

public class Open_Addressing {
    private static class MapNode<K,V>{
        K key;
        V value;
        boolean isTombstone;
    }
}
