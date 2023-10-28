package isp.lab3.exercise1;

public class TreeTest {

    public static void main(String[] args) {
        Tree myTree0= new Tree();
        myTree0.grow(1);
        String Message0= myTree0.ToString();
        System.out.println(Message0);
        Tree myTree1= new Tree();
        myTree1.grow(2);
        String Message1= myTree1.ToString();
        System.out.println(Message1);
        Tree myTree2= new Tree();
        myTree2.grow(3);
        String Message2= myTree2.ToString();
        System.out.println(Message2);
    }

}
