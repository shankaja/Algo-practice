import java.util.Arrays;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        MyLinkedList<Integer> ml = new MyLinkedList<>();
        for (Integer integer : integers) {
            ml.insert(ml, integer);
        }
        System.out.println(ml);
    }


    static class MyLinkedList<T> {

        private T value;
        private MyLinkedList<T> next;

        MyLinkedList(T value) {
            this.value = value;
        }

        MyLinkedList() {
        }

        public void insert(MyLinkedList<T> root, T value) {
            if (root.getValue() == null) {
                root.setValue(value);
                return;
            }
            if (root.getNext() == null)
                root.setNext(new MyLinkedList<>(value));
            else {
                MyLinkedList<T> tempNode = root;
                while (tempNode.getNext() != null) {
                    tempNode = tempNode.getNext();
                }
                tempNode.setNext(new MyLinkedList<>(value));
            }
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public MyLinkedList<T> getNext() {
            return next;
        }

        public void setNext(MyLinkedList<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder(this.getValue() + "->");
            if (this.getNext() != null) {
                MyLinkedList<T> tempNode = this;
                while (tempNode.getNext() != null) {
                    tempNode = tempNode.getNext();
                    str.append(tempNode.getValue()).append("->");
                }

            }
            str.setLength(str.length() - 2);
            return str.toString();
        }
    }
}
