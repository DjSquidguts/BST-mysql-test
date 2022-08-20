package com.keyin;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.time.LocalDateTime;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        
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
        

        tree.insert(new Node(num1));
        tree.insert(new Node(num2));
        tree.insert(new Node(num3));
        tree.insert(new Node(num4));
        tree.insert(new Node(num5));
        tree.insert(new Node(num6));
        tree.insert(new Node(num7));
        tree.insert(new Node(num8));
        tree.insert(new Node(num9));

        //System.out.println("");
        System.out.println("Binary Search Tree Results are : ");
        tree.display();
        System.out.println("");
        System.out.println("");
        Gson gson = new Gson();
        String tree_string = gson.toJson(tree);
        System.out.println("TREE STRING: " + tree_string);
        //System.out.println(tree_string);
        System.out.println("");
        //tree.display();
        
        
        createTable();
        post(inputs, tree_string);
        
        tree_input.close();   
    }

    //adding in the write databse mysql parts
    public static void post(String inputs,String tree_string) throws Exception{
		final String inputsdb = (inputs);
		final String treeoutputs = (tree_string);
        
        
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        //System.out.println("Converted String: " + strDate);
        
		try { 
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO BST_Trees (strDate, inputs, treeoutputs) VALUES ('"+strDate+"','"+inputsdb+"','"+treeoutputs+"')");
			 
			posted.executeUpdate();
		} catch(Exception e) {System.out.println(e);    }
		finally {
			System.out.println("Insert into DB Completed!");
		}
		
	}
	
	
	public static void createTable() throws Exception {
		try {  
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS BST_Trees(id int NOT NULL AUTO_INCREMENT, strDate varchar(255),inputs varchar(255), treeoutputs varchar(255), PRIMARY KEY(id))");
		create.executeUpdate();
		
		}catch(Exception e){System.out.println(e);}
		finally {
			System.out.println("Database is Ready!");
			};
	}

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/binarytree";
			String username = "root";
			String password = "Keyin2021";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("connected to MYSQL DB");
			return conn;
		} catch(Exception e) {System.out.println(e);}
		
		
		
		return null;
	}
}
