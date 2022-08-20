package com.keyin;

public class BST{

    Node root;
    public void insert(Node node){
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node){
        int data = node.data;

        if(root == null){
            root = node;
            return root;
        } else if(data < root.data){
            root.left = insertHelper(root.left, node);
        } else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display(){
        displayHelper(root);    
    }

    private void displayHelper(Node root){
        String outputtest=" ";
        if(root != null){
            displayHelper(root.left);
            System.out.print(root.data +" ");
            outputtest = (outputtest + " " + root.data); //del
            displayHelper(root.right);
            //System.out.println(outputtest); //del
            //System.out.println(outputtest);
            return;
            
        } 
        
    }
}
