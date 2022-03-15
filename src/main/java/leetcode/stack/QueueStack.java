package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个栈实现队列
 */
public class QueueStack {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	/** Initialize your data structure here. */
	public QueueStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		//入栈操作时，首先将元素入队到queue2
		queue2.offer(x);
		//然后将 queue1的全部元素依次出队并入队到queu2，此时queue2的前端的元素即为新入栈的元素
		while (!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}
		//交换queue1 和queue2
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue1.poll();
	}

	/** Get the top element. */
	public int top() {
		return queue1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty();
	}

    public static void main(String[] args) throws Exception {
        QueueStack stackQueue = new QueueStack();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        System.out.println(stackQueue.top());
        System.out.println(stackQueue.pop());
        stackQueue.push(4);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
}
