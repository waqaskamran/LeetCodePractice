package DesignPattern.Graph;

public class SymmetricNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(2);

        root.left.left= new TreeNode(3);
        root.right.right= new TreeNode(3);
        System.out.println("isSymetry" +isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode treeNode) {
        if(treeNode == null) return true;
       return isSymetry(treeNode.left,treeNode.right);
    }

    private static boolean isSymetry(TreeNode left, TreeNode right) {
     if(left  == null && right == null){return true;}
     if(left  == null || right == null){return false;}
     return left.value == right.value &&
             isSymetry(left.left,right.right) &&
             isSymetry(left.right ,right.left);
    }
}



class TreeNode{
    int value;
    TreeNode left,right;

    public TreeNode(int value) {
        this.value = value;
    }
}
