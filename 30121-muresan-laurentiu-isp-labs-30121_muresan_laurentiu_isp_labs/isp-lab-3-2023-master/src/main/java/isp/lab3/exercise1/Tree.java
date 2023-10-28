package isp.lab3.exercise1;

public class Tree {
    public int height;

    public Tree() {
        this.height = 15;
    }

    public void grow(int meters) {
        if (meters >= 1)
            this.height = this.height + meters;
    }

    public String ToString() {
        return "The height of the tree is " + this.height+ " meters";
    }

    public static void main(String[] args) {
        Tree Tree1 = new Tree();
        System.out.println( Tree1.ToString());
        Tree1.grow(4);
        System.out.println( Tree1.ToString());
    }

}
