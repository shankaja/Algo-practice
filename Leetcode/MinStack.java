import java.util.ArrayList;
import java.util.List;

class MStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

//leetcode 155
public class MinStack {

    private final List<Integer> stack;
    private int minIndex;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        if (!stack.isEmpty() && stack.get(minIndex) != null && stack.get(minIndex) > val) {
            minIndex = stack.size();
        }
        stack.add(val);

    }

    public void pop() {
        stack.remove(stack.size() - 1);
        if (stack.size() - 1 < minIndex) {
            minIndex = 0;
            for (int i = 1; i < stack.size(); i++) {
                if (stack.get(minIndex) > stack.get(i)) {
                    minIndex = i;
                }
            }
        }
    }

    public int top() {
        return this.stack.get(stack.size() - 1);
    }

    public int getMin() {
        return this.stack.get(minIndex);
    }
}
