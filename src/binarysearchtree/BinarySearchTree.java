/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Random;

/**
 *
 * @author accer
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(10);
        Random rnd =new Random();
//        for(int i=0;i<=10;i++)
//            InsertNode(root, rnd.nextInt(20)+0);
        InsertNode(root, 12);
        InsertNode(root, 9);
        InsertNode(root, 8);
        InsertNode(root, 11);
        System.out.println(root.left.data);
        inOrder(root);
        SearchNode(root, 10);
        FindMin(root);
        FindMax(root);
        DeleteNode(root, 10);
        inOrder(root);
        // TODO code application logic here
    }
    public static void inOrder(BinaryTreeNode root) {  
        if (root == null)  
         return;  
        inOrder(root.left);  
        System.out.print(root.data + " ");  
        inOrder(root.right);  
    }  

    public static class BinaryTreeNode{
        public Integer data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode(){
            this.data=null;
            left=null;
            right=null;
        }
        public BinaryTreeNode(int data){
            this.data=data;
            left=null;
            right=null;
        }
        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data=data;
        }
        public BinaryTreeNode getLeft(){
            return left;
        }
        public void setLeft(BinaryTreeNode left){
            this.left =left;
        }
        public BinaryTreeNode getRight(){
            return right;
        }
        public void setRight(BinaryTreeNode right){
            this.right =right;
        }
        
    
        
    }
    public static void InsertNode(BinaryTreeNode root,int data){
            BinaryTreeNode node=new BinaryTreeNode(data);
            if(root.data==null){
                root=node;
            }
            else{
                while(root!=null){
                    if(data<=root.data){
                        if(root.left==null){
                            root.left=node;
                            return;
                        }
                        else
                            root=root.left;
                    }
                    else{
                        if(root.right==null){
                            root.right=node;
                            return;
                        }
                        else
                            root=root.right;
                    }
                }
            }
            
        }
        public static BinaryTreeNode SearchNode(BinaryTreeNode root, int data){
            if(root.data == null)
                return null;
            else{
                if(data<root.data){
                    root=root.left;
                    SearchNode(root, data);
                }
                    
                else if(data>root.data){
                    root=root.right;
                    SearchNode(root, data);
                }
                else
                    System.out.println("found");
            }
            return root;
        }
        public static BinaryTreeNode FindMin(BinaryTreeNode root){
            if(root.data==null){
                System.out.println("no element");
                return null;
            }
            else{
               while(root.left!=null){
                   root=root.left;
               }
               System.out.println(root.data);
            }
            return root;
        }
        public static BinaryTreeNode FindMax(BinaryTreeNode root){
            if(root.data==null)
                System.out.println("no element");
            else{
               while(root.right!=null){
                   root=root.right;
               }
               System.out.println(root.data);
            }
            return root;
        }
        public static BinaryTreeNode DeleteNode(BinaryTreeNode root,int data){
            if(root.data == null)
                return null;
            else{
                if(data<root.data){
                    root.left=DeleteNode(root.left, data);
                   
                }
                    
                else if(data>root.data){
                    root.right=DeleteNode(root.right, data);
                }
                else{
                    if(root.left==null && root.right==null)
                        root=null;
                    else if(root.left==null)
                    {
                        root=root.right;
                    }
                    else if(root.right==null)
                    {
                        root=root.left;
                    }
                    else {
                        BinaryTreeNode temp =FindMin(root.right);
                       root.data=temp.data;
                        DeleteNode(root.right, temp.data);
                        
                    }
                }
            
            }
            return root;
             

        }
    
}
