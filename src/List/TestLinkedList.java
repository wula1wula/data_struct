package List;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // 添加元素
        list.add(10);
        list.add(20);
        list.add(30);

        // 获取元素
        System.out.println(list.get(0)); // 预期：10
        System.out.println(list.get(1)); // 预期：20
        System.out.println(list.get(2)); // 预期：30

        // 删除元素
        list.remove(20);
        System.out.println(list.get(1)); // 预期：30

        // 检查链表大小
        System.out.println("Size: " + list.getSize()); // 预期：2
    }
}
