package List;

public class SelectSort {
    //寻找最小值
    //交换最小值到已排序末尾
    //继续排序剩余数组
    public static void selectSort(String[] s){
            selectSort(s,0);
    }
    private static int findMin(String[] s,int start){
        int min = start;
        for(int i = start;i<s.length;i++){
            if(s[i].compareTo(s[min])<0){
                min = i;
            }
        }
        return min;
    }
    private static void swap(String[] s,int a,int b){
        String temp = s[a];
        s[a] = s[b];
        s[b]=temp;
    }
    private static void selectSort(String[] s, int start){
        if(start == s.length){
            return;
        }
        int Minvalue = findMin(s,start);
        swap(s,start, Minvalue);
        selectSort(s,start+1);
    }
}
