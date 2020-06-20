package csfundamental.stacks;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {
    List<Stack> stacks = new ArrayList<Stack>();

    public static void main(String[] ar) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(10);
        setOfStacks.push(20);
        setOfStacks.push(30);
        setOfStacks.push(40);
        setOfStacks.push(50);
        setOfStacks.push(60);
        setOfStacks.push(70);
        setOfStacks.push(80);
        System.out.println("*****************************");
        Node node1 = setOfStacks.pop();
        Node node2 = setOfStacks.pop();
        Node node3 = setOfStacks.pop();
        Node node4 = setOfStacks.pop();
        Node node5 = setOfStacks.pop();
        Node node6 = setOfStacks.pop();
        Node node7 = setOfStacks.pop();
        Node node8 = setOfStacks.pop();
        Node node9 = setOfStacks.pop();
        System.out.println("*****************************");
    }

    public void push(int item) {
        boolean isItemAdded = false;
        if (stacks.isEmpty()) {
            Stack stack = new Stack();
            System.out.println("stack id:" + stack.getId() + " *" + item);
            stack.push(item);
            stacks.add(stack);
        } else {
            for (Stack stack : this.stacks) {
                if (!stack.isMaxLimitReached()) {
                    System.out.println("stack id:" + stack.getId() + " #" + item);
                    stack.push(item);
                    isItemAdded = true;
                } else {
                    continue;
                }
            }

            if (!isItemAdded) {
                Stack stack = new Stack();
                stack.push(item);
                System.out.println("stack id:" + stack.getId() + " @" + item);
                stacks.add(stack);
            }

        }
    }

    public Node pop() {
        for (int x = stacks.size() - 1; x >= 0; x--) {
            Stack stack = stacks.get(x);
            Node node = stack.pop();
            if (node != null) {
                System.out.println("stack id:" + stack.getId() + " @" + node.item);
                return node;
            }
            continue;
        }
        return null;
    }

    public Node popAt(int index){
        if(index >= stacks.size()){
            throw new IllegalArgumentException("invalid index");
        }
        Stack stack = stacks.get(index);
        return stack.pop();
    }
}
