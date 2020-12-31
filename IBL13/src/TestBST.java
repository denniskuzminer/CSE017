public class TestBST {
    public static void main(String[] args){
        Node myRoot = new Node(10);
        BinarySearchTree myBST = new BinarySearchTree(myRoot);
        System.out.println(myBST.isLeaf());
        myBST.add(6);
        myBST.add(5);
        myBST.add(8);
        myBST.add(15);
        myBST.add(14);
        myBST.add(19);
        System.out.println(myBST.getLeftSubtree());
        System.out.println(myBST.isLeaf());
        //System.out.println(myBST);
        System.out.println(myBST.find(5)); // finds 5
        System.out.println(myBST.delete(8)); // deletes 8
        //System.out.println(myBST);

    }
}
