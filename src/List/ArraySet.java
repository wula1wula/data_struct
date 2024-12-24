package List;

import java.util.Iterator;
import java.util.function.Consumer;

public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;
    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /**
     * 检测值是否存在
     * @param x
     * @return
     */
    public boolean contains(T x){
        if(x== null){
            throw new IllegalArgumentException("不能检测空值");
        }
        for(int i =0;i<size;i++){
            if(items.equals(x)){
                return true;
            }
        }
        return false;
    }

    /**
     * 添加值
     * @param x
     */
    public void add(T x){
        if(x== null){
            throw new IllegalArgumentException("不能添加空值");
        }
        if(contains(x)){
            return;
        }
        items[size] = x;
        size +=1;
    }

    /**
     * 返回数组大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 重写foreach迭代方法
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    /**
     * 重写foreach迭代方法
     */
    private class ArraySetIterator implements Iterator<T>{
        private int w;
        public ArraySetIterator(){
            w = 0;
        }

        /**
         * 判断是否有下一个元素
         * @return
         */
        public boolean hasNext(){
            return w<size;
        }

        /**
         * 返回当前元素
         * @return
         */
        public T next(){
            T returnItem = items[w];
            w+=1;
            return returnItem;
        }
    }
    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for(int i =0; i<size-1;i++){
            sb.append(items[i].toString());
            sb.append(",");
        }
        sb.append(items[size-1]);
        sb.append("}");
        return sb.toString();
    }
}
