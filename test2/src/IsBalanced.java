//import javax.swing.tree.TreeNode;
//
//public class IsBalanced {
//    boolean isBalanced = true;
//    public  boolean IsBalanced_Solution(TreeNode root){
//        height(root);
//        return isBalanced;
//    }
//    private int height(TreeNode root){
//        if(root == null || !isBalanced)
//            return 0;
//        //分别遍历左子树和右子树
////        int left = height(root.left);
////        int right = height(root.right);
//        if(Math.abs(left-right)>1){
//            isBalanced = false;
//        }
//        return 1+Math.max(left,right);
//    }
//}
