package DuoTai;

import java.util.Comparator;

public class Dog implements compareTo{
    private String name;
    private int size;
    public Dog(){}
    public Dog(String name,int size){
        this.name = name;
        this.size = size;
    }

    //重写compareTo接口的compareTo方法
    @Override
    public int compareTo(Object o) {
        Dog d = (Dog)o;
        return this.size-d.size;
    }

    //重写Comparator接口的compare方法
    private static class DogComparator implements Comparator<Dog>{
        public int compare(Dog a,Dog b){
            return a.name.compareTo(b.name);
        }
    }
    //静态方法，返回DogComparator对象
    public static Comparator<Dog> getDogComparator(){
        return new DogComparator();
    }


    public void setName(String name){
        this.name = name;
    }
    public void setSize(int size){
        this.size = size;
    }
    public String getName(){
        return this.name;
    }
    public int getSize(){
        return this.size;
    }
}
