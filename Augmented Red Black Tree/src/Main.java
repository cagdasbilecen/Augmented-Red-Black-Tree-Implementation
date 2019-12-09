import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;



public class Main extends Management {

	public static void main (String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		        Management m=new Management();
		        AugManagement aug=new AugManagement();
		        //RedBlackTree rbt = new RedBlackTree();
		        //rbt.consoleUI();
		      //  m.readTextFileAndLoadToArrayList();
		        //m.printEntryArray();
		       //System.out.println(m.ageCalculator("10/8/1995")); 
		        
		        
		        //m.consoleUI();
		        //m.addToTree();
		       //System.out.println(m.inOrderTravelToFindGetNumSmaller(m.root,"25/11/1965"));
		       //m.printTree(m.root);
		       
		      
		       //System.out.println(m.inOrderTravelToFindGetNumSmaller(m.root,"25/11/1965"));
		      // System.out.println(m.inOrderTravelToFindGetNumSmallerWithAge(m.root,54));
		       //System.out.println(m.inOrderTravelToFindGetNumSmallerWithDate(m.root,"25/11/1965"));
		       //m.consoleUI();
		        //System.out.println(m.findMin(m.root).key);
		        //System.out.println(m.findMax(m.root).key);
		        //System.out.println(m.treeMinimum(m.root).age);
		        
		       //////////////////////// aug.readTextFileAndLoadToArrayList();
		        //////////////////////////aug.addToTree();
		       // System.out.println(aug.findNode(aug.root.left, aug.root).key);
		       ////////////////////aug.trvl2(aug.root);
		        //aug.printTree(aug.root);
		        
		       ///////////////////////////7System.out.println(aug.root.countOfYoungerNodes);
		       
		      // aug.printTree(aug.root);
		       //System.out.println(aug.root.right.right.countOfYoungerNodes);

		       //System.out.println(aug.root.left.countOfYoungerNodes);
		       
		       

		        //System.out.println(aug.root.left.left.countOfYoungerNodes);
		        //aug.insertTree();
		        //System.out.println(aug.root.countOfYoungerNodes);
			    // System.out.println(m.inOrderTravelToFindGetNumSmallerWithId(m.root,7575));


		       ////// ------------ USER INTERFACE --------------- /////////
		       
		        m.readTextFileAndLoadToArrayList();
		        m.addToTree();
		        aug.readTextFileAndLoadToArrayList();
		        aug.addToTree();
		       	System.out.println("------ RB-Tree ------");
		       	System.out.println("All items were inserted");
		       	System.out.println("The result of GETNUMSMALLER1 for node with birthdate 7/6/1991 is "+m.inOrderTravelToFindGetNumSmallerWithDate(m.root,"7/6/1991"));
		       	System.out.println("The result of GETNUMSMALLER2 for node with id 9988 is "+m.inOrderTravelToFindGetNumSmallerWithId(m.root,"9988"));
		       	System.out.println("The maximum age of all people is "+m.findMax(m.root).getAge()+" id: "+m.findMax(m.root).getId()+" Birthdate: "+ m.findMax(m.root).getBirthDate());
		       	System.out.println("The minimum age of all people is "+m.findMin(m.root).getAge()+" id: "+m.findMin(m.root).getId()+" Birthdate: "+ m.findMin(m.root).getBirthDate());
		       	System.out.println("The number of all people is "+m.getNum(m.root));
		       	m.resetGlobalVariables();
		    	System.out.println("------ Augmented RB-Tree ------");
		       	System.out.println("All items were inserted");
		       	System.out.println("The result of GETNUMSMALLER1 for node with birthdate 7/6/1991 is "+aug.inOrderTravelToFindGetNumSmallerWithDate(aug.root,"7/6/1991"));
		       	System.out.println("The result of GETNUMSMALLER2 for node with id 9988 is "+aug.inOrderTravelToFindGetNumSmallerWithId(aug.root,"9988"));
		       	System.out.println("The maximum age of all people is "+aug.findMax(aug.root).getAge()+" id: "+aug.findMax(aug.root).getId()+" Birthdate: "+ aug.findMax(aug.root).getBirthDate());
		       	System.out.println("The minimum age of all people is "+aug.findMin(aug.root).getAge()+" id: "+aug.findMin(aug.root).getId()+" Birthdate: "+ aug.findMin(aug.root).getBirthDate());
		       	System.out.println("The number of all people is "+aug.getNum(aug.root));
		       	aug.resetGlobalVariables();
		           Scanner scan = new Scanner(System.in);
		           while (true) {
		               System.out.println("\n1.- Insert New Person\n"
		                       + "2.- GetNumSmaller1\n"
		                       + "3.- GetNumSmaller2\n"
		                       + "4.- Print tree\n"
		                       + "5.- GetMax\n"
		                       + "6.- GetMin\n"
		                       + "7.- GetNum\n");
		               int choice = scan.nextInt();

		               int item;
		               switch (choice) {
		                   case 1:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                	   if(item==1)
		                       m.insertTree();
		                	   else if(item==2) {
		                       aug.insertTree();
		                	   aug.trvl2(aug.root); }
		                	   else
		                	   System.out.println("error!");
		                       break;
		                   case 2:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                       System.out.println("Enter date");
		                       String date = scan.next();
		                       if(item==1) {
		                       System.out.println(m.inOrderTravelToFindGetNumSmallerWithDate(m.root,date));
		                       m.resetGlobalVariables(); }
		                       else if(item==2) { 
		                       System.out.println(aug.inOrderTravelToFindGetNumSmallerWithDate(aug.root,date));
			                   aug.resetGlobalVariables();
		                       }
		                       else
		                       System.out.println("error!");
		                       break;
		                   case 3:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                   	   System.out.println("Enter id");
		                       String id = scan.next();
		                       if(item==1) {
		                       System.out.println(m.inOrderTravelToFindGetNumSmallerWithId(m.root,id));
		                       m.resetGlobalVariables(); }
		                       else if(item==2) { 
		                       System.out.println(aug.inOrderTravelToFindGetNumSmallerWithId(aug.root,id));
			                   aug.resetGlobalVariables();	   
		                       }
		                       else
		                       System.out.println("error!");
		                       
		                       break;
		                   case 4:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                	   if(item==1)
		                	   m.printTree(m.root);
		                	   else if(item==2) {
		                	   aug.trvl2(aug.root);
		                	   aug.printTree(aug.root); }
		                	   else
		                	   System.out.println("error!");
		                       break;
		                   case 5:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                	   if(item==1) {
		                       System.out.println("Id: " + m.findMax(m.root).getId() + "\nBirthDate: " + m.findMax(m.root).getBirthDate());
		                       m.resetGlobalVariables(); }
		                	   else if(item==2) { 
		                	   System.out.println("Id: " + aug.findMax(aug.root).getId() + "\nBirthDate: " + aug.findMax(aug.root).getBirthDate());
			                   aug.resetGlobalVariables(); 
		                	   }
		                	   else
		                	   System.out.println("error!");	
		                       break;
		                   case 6:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                	   if(item==1) {
		                       System.out.println("Id: " + m.findMin(m.root).getId() + "\nBirthDate: " + m.findMin(m.root).getBirthDate());
		                       m.resetGlobalVariables(); }
		                	   else if(item==2) {
		                	   System.out.println("Id: " + aug.findMin(aug.root).getId() + "\nBirthDate: " + aug.findMin(aug.root).getBirthDate());
			                   aug.resetGlobalVariables(); 
		                	   }
		                	   else
		                	   System.out.println("error!");
		                       break;
		                   case 7:
		                	   System.out.println("1.RB 2.Aug");
		                	   item = scan.nextInt();
		                	   if(item==1) {
		                   	   System.out.println("Number of all nodes: "+ m.getNum(m.root));
		                   	   m.resetGlobalVariables(); }
		                	   else if(item==2) { 
		                	   System.out.println("Number of all nodes: "+ aug.getNum(aug.root));
			              	   aug.resetGlobalVariables(); 
		                	   }
		                	   else
		                	   System.out.println("error!");
		                	   
		                   	   break;
		                   
		               }
		           }
		       
		           /////////////----------------END OF USER INTERFACE----------------/////////////////////
		      
		        
	}

}
