package DataStructures.Stack;

public class StackArrayRunner {

    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        stackArray.push(7);
        stackArray.push(3);
        stackArray.push(10);
        stackArray.push(8);
        stackArray.push(8);

        System.out.println(stackArray);
    }
}
