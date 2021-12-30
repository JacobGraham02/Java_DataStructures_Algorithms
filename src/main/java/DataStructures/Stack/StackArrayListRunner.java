package DataStructures.Stack;

public class StackArrayListRunner {

    public static void main(String[] args) {
        StackArrayList stackArrayList = new StackArrayList();

        stackArrayList.push(2);
        stackArrayList.push(7);
        stackArrayList.push(8);

        System.out.println(stackArrayList.peek());
        System.out.println(stackArrayList);




    }
}
