package Array;

public class intArray {
    private int Max = 10;
    private int[] data;
    private int size;

    public intArray(){
        data = new int[Max];
        size = 0;
    }
    public intArray(int capacity){
        data = new int[capacity];
        size =0;
        Max = capacity;
    }

    /**
     * 添加元素
     * @param x
     */
    public void add(int x){
        if(size == Max){
            Max *= 2;
            int []newData = new int[Max];
            System.arraycopy(data,0,newData,0,size);
            data = newData;
        }
        data[size] =x;
        size+=1;
    }

    /**
     * 删除并返回索引元素
     * @param index
     * @return
     */
    public int delete(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("index is illegal");
        }
        int result = data[index];
        for(int i = index+1;i<size;i+=1){
            data[i-1] = data[i];
        }
        size -=1;
        return result;
    }

    /**
     * 返回数组元素
     * @param index
     * @return
     */
    public int get(int index){
        if(index <0 || index >=size){
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    public int size(){
        return size;
    }

    public boolean idEmpty(){
        return size == 0;
    }

    public void clean(){
        size = 0;
    }
    public static void main(String[] args) {
        intArray array = new intArray();

        // 测试添加元素
        array.add(10);
        array.add(20);
        array.add(30);
        System.out.println(array.get(1)); // 输出：20

        // 测试删除元素
        array.delete(1);
        System.out.println(array.get(1)); // 输出：30

        // 测试自动扩容
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
        System.out.println(array.size()); // 输出应为当前元素数量
        System.out.println(array.get(10)); // 输出第10个元素，确保扩容后数据正确
    }

}
