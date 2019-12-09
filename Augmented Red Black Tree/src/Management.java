
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;


public class Management<I,A> extends RedBlackTree<I,A> {
	int q = 0 ; 
	//defined for Integer ID VALUES....
	public ArrayList<EntryClass<I,A>> entryArray=
			new ArrayList<EntryClass<I,A>>(); //array list that type of entryclass which types of integer and string...
	public int numSmaller=0;
	public int numSmaller2=0;
	public int retValue=0;
	public int numAllNodes=0;

	//RedBlackTree<I,A> RBT=new RedBlackTree<I,A>(); 
	
	
	public Management(){
		
		  } //constructor of class
	
	//Age calculator with given date input
	public int ageCalculator(String date) { //date always string, it's a constant, so parameter of function is string
		int age;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date currentDate = new Date();
		String curDate = dateFormat.format(currentDate).toString(); 
		String[] fields = date.split("/");
		int localMonth= Integer.parseInt(fields[1]);
		int localYear=Integer.parseInt(fields[2]);
		int localDay=Integer.parseInt(fields[0]);
		String[] fields2= curDate.split("/");
		int curMonth=Integer.parseInt(fields2[1]);
		int curYear=Integer.parseInt(fields2[0]);
		int curDay=Integer.parseInt(fields2[2]);
		
	    int day,month=0,year=0;
	    day=curDay-localDay;
	    if(day<0) { 
	    	day+=30;
	    	month-=1;
	    }
	    month+=curMonth-localMonth;
	    if(month<0) { 
	    	month+=12;
	    	year-=1;
	    }
	    year+=(curYear-localYear);
	    
	    age = year*365 + month*30 + day*1 ;
	
		return age;
		
	} 
	
	
	
	//PROCESSES WHICH ARE READ TEXT FILE, CREATE AN ENTRYCLASS OBJECT AND ADD THIS OBJECT TO ARRAYLIST , RESPECTIVELY...
	@SuppressWarnings("unchecked")
	public void readTextFileAndLoadToArrayList() throws FileNotFoundException, IOException  { 

	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\cadob\\OneDrive\\Masaüstü\\people.txt"))) {
	    String line;
	    
	    while ((line = br.readLine()) != null) {
	    	String[] fields = line.split(",");
	    	
	    		int age = ageCalculator(fields[1]);  //calculate age of current line
	    		EntryClass e1=new EntryClass(fields[0],age,fields[1]); //create an entryClass object..
	    		e1.setTempId((fields[0]));
	    		entryArray.add(e1);
	    		
	    	}
	    }
	
	catch (ArrayIndexOutOfBoundsException e) { //handle array index out of bounds...
		System.out.println(e.getMessage());
	}
	catch (NullPointerException e) { //handle null pointer... (converting array to array list has handled this one already..)
		System.out.println(e.getMessage());
	}
	}
	//END OF PROCESSES
	
	public void printEntryArray() {
		for (int i = 0; i < entryArray.size(); i++) {
			System.out.println(entryArray.get(i).getAge()); 
			//System.out.println(entryArray.get(i).getId());
		}
	}
	
	public void addToTree() { // add entryclass objects to tree from entrarray arraylist..
		for (int i = 0; i < entryArray.size(); i++) {
			
			Node node=new Node((int)entryArray.get(i).getAge());
			node.setAge(entryArray.get(i).getAge());
			node.setId((entryArray.get(i).getId()));
			node.setTempId(entryArray.get(i).tempid);
			node.setBirthDate(entryArray.get(i).getBirthDate());
			
			
			insert(node);
			
		
		}
	}
	///Three same function with different parameters date,age,id
	public int inOrderTravelToFindGetNumSmallerWithDate(Node<I,A> node,String date) {
		int age=ageCalculator(date);
		if(node==null) {
			return numSmaller;      
		}
		inOrderTravelToFindGetNumSmallerWithDate(node.left,date);
		if(node.key>age) numSmaller++;
		inOrderTravelToFindGetNumSmallerWithDate(node.right,date);
		
		
		return numSmaller;
	}
	public int inOrderTravelToFindGetNumSmallerWithAge(Node<I,A> node,int age) {
		if(node==null) {
			return numSmaller2;      
		}
		inOrderTravelToFindGetNumSmallerWithAge(node.left,age);
		if(node.key>age) numSmaller2++;
		inOrderTravelToFindGetNumSmallerWithAge(node.right,age);
		
		
		return numSmaller2;
	}

	public int inOrderTravelToFindGetNumSmallerWithId(Node<I,A> node,I id) {
		if(node==null) {
		 return retValue;
		}  
		
		inOrderTravelToFindGetNumSmallerWithId(node.left,id);
		if(id.equals(node.tempid)) retValue=inOrderTravelToFindGetNumSmallerWithAge(root,node.key);
		inOrderTravelToFindGetNumSmallerWithId(node.right,id);

		return retValue;
	}
	//end of three functions..
	
	
	public Node<I, A> findMax(Node<I,A> node) {  //find Node which has maximum age 
		Node maximumNode=new Node(-1);
		Node maximumNodeL=new Node(-1);
		Node maximumNodeR=new Node(-1);

		if(node==null)
			return maximumNode;
		maximumNodeL = findMax(node.left);
		maximumNode= node;
		maximumNodeR = findMax(node.right);
		if(maximumNodeL.key>maximumNode.key)
			maximumNode=maximumNodeL;
		if(maximumNodeR.key>maximumNode.key)
			maximumNode=maximumNodeR;
	
		return maximumNode;
		}
	
	public Node findMin(Node subTreeRoot){
		while(subTreeRoot.left!=nil){
	    subTreeRoot = subTreeRoot.left;
	    }
	      return subTreeRoot;
	    }
	
	public int getNum(Node<I,A> node) {
	        if (node == nil) {
	            return numAllNodes;
	        }
	        getNum(node.left);
	        numAllNodes++;
	        getNum(node.right);
	        
	        return numAllNodes;
	        
	}
	
	public void resetGlobalVariables() { 
		 numSmaller=0;
		 numSmaller2=0;
		 retValue=0;
		 numAllNodes=0;
	}

	public void insertTree() {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Enter Birthdate");
		 String item = scan.nextLine();
		 int age=ageCalculator(item);
		 System.out.println("Enter ID");
		 String id=scan.next();
         Node node = new Node(age);
         node.setId(id);
         node.setBirthDate(item);
         node.setTempId(id);
         node.setAge(age);
         insert(node);
         
  	
         System.out.println("Added.");
	}
	
	
	
   


	
	

	
	
	
	
	
}
