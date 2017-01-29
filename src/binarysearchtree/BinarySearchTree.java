/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author accer
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Integer> binArray=new ArrayList<Integer>();
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(10);
        Random rnd =new Random();
//        for(int i=0;i<=10;i++)
//            InsertNode(root, rnd.nextInt(20)+0);
        InsertNode(root, 12);
        InsertNode(root, 9);
        InsertNode(root, 8);
        InsertNode(root, 11);
        InsertNode(root, 13);
        InsertNode(root, 2);
        InsertNode(root, 3);
        InsertNode(root, 1);
        //System.out.println(root.left.data);
        FindKthSmallest(root,3);
        inOrder(root);
        binArray.get(3);
        SearchNode(root, 10);
        FindMin(root);
        FindMax(root);
        DeleteNode(root, 10);
        inOrder(root);
        // TODO code application logic here
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
     
    }
    
    public static void inOrder(BinaryTreeNode root) {  
        if (root == null)  
         return;  
        
        inOrder(root.left);  
        System.out.print(root.data + " ");  
        inOrder(root.right); 
        
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
            if(root==null)
                return null;
            if(data<root.data)
                root.left=DeleteNode(root.left, data);
            if(data>root.data)
                root.right=DeleteNode(root.right, data);
            else{
                if(root.left==null && root.right==null)
                    root=null;
                else if(root.left==null){
                    root=root.right;
                }
                else if(root.right==null){
                    root=root.left;
                }
                else{
                    BinaryTreeNode temp=FindMin(root.right);
                    root.data=temp.data;
                    DeleteNode(root.right, temp.data);
                }
                
            }
            return root;
        }
        public static void FindKthSmallest(BinaryTreeNode root,int k){
            if(root==null)
                return;
            FindKthSmallest(root.left, k);
            binArray.add(root.data);
            if(binArray.size()==k)
                System.out.println(binArray.get(k-1));
            FindKthSmallest(root.right, k);
        }
    
}
