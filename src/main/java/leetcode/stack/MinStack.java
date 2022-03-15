package leetcode.stack;

import java.util.Stack;

/**
 * ## 问题描述
 * 实现一个栈， 该栈带有出栈（ pop） 、 入栈（ push） 、 取最小元素（ getMin） 3
 * 个方法。 要保证这3个方法的时间复杂度都是O(1)。
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<Integer>();
    //辅助栈要存最小和第二小的元素
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     * @param element  入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        //如果辅助栈为空，或新元素小于等于辅助栈栈顶，则新元素压入辅助栈
        if (minStack.empty() || element  <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     */
    public Integer pop() {
        //如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     */
    public int getMin() throws Exception {
        if (mainStack.empty()) {
            throw new Exception("stack is empty");
        }

        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
