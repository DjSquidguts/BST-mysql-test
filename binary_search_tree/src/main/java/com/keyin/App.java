package com.keyin;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        

            Scanner tree_input = new Scanner(System.in);

            System.out.println("");
            System.out.println("Please enter 9 numbers: ");
            
            int num1 = tree_input.nextInt();
            int num2 = tree_input.nextInt();
            int num3 = tree_input.nextInt();
            int num4 = tree_input.nextInt();
            int num5 = tree_input.nextInt();
            int num6 = tree_input.nextInt();
            int num7 = tree_input.nextInt();
            int num8 = tree_input.nextInt();
            int num9 = tree_input.nextInt();
            
            System.out.println("");
            String inputs = (num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6 + " " + num7 + " " + num8 + " " + num9 + " ");
            BST tree = new BST();

            System.out.println("The inputs are: " + inputs);
            System.out.println("");
            System.out.println("Binary Search Tree Results: ");

            tree.insert(new Node(num1));
            tree.insert(new Node(num2));
            tree.insert(new Node(num3));
            tree.insert(new Node(num4));
            tree.insert(new Node(num5));
            tree.insert(new Node(num6));
            tree.insert(new Node(num7));
            tree.insert(new Node(num8));
            tree.insert(new Node(num9));
                    
            tree.display();
            tree_input.close();
        
            
        
    }
}
