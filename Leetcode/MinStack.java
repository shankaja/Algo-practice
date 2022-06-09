import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

//leetcode 155
public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minimum;

    public MinStack(){
        stack = new Stack<>();
        minimum = new Stack<>();
    }

    public void push(int e){
        if (minimum.isEmpty()||minimum.peek()>=e){
            minimum.push(e);
        }
        stack.push(e);
    }

    public int pop(){
        int pop = stack.pop();
        if (minimum.peek() == pop)
            return minimum.pop();
        return pop;
    }

    public int getMin(){
        return minimum.peek();
    }
}
