import java.util.*;

public class HotelReservation{	
	static String roomCustomerName; //declare to save the customer name
	static int roomNumber;  //declare to save the room number
	
	static String[] roomStatus = new String[10]; //declare static array to store room status
	static String[] roomStatusTemp = new String[10]; //declare additional static array to store same room status to use further
	static String[] que = new String[7]; // Declare an array to hold the queue details
	static int countQueueEmpty=0; // integer which is used in Queue adding
	static Scanner sc = new Scanner(System.in); // declare the scanner
	static Menu menu = new Menu();  // create an object for Menu class
	static Queue queue= new Queue();  // create an object for Queue class
	

	public static void main(String[] args) {
		queue.setQueStatus(que);//set the Queue List status to "empty" for all rooms at the beginning		
	     Room.setRoomStatus(roomStatus); //set the room status to "available" for all rooms at the beginning
		Room.setRoomStatus(roomStatusTemp); //set the temporary array room status to "available" for all rooms at the beginning
		  
		System.out.println("");
		System.out.println("          ,,,,,,,,,,,,,,,,,,,,    ");
		System.out.println("----------$ Hotel Has_Master $----------");
		System.out.println("          ''''''''''''''''''''  ");
        System.out.println("");
 
        System.out.println("         !! WELCOME !!     ");
		System.out.println("-- # Hotel Booking Options # --");
		System.out.println("   Press V to View all rooms...");
		System.out.println("   Press A to Add customer to a room...");
		System.out.println("   Press Q to Display Queue Details...");
		System.out.println("   Press W to Display and Remove First 3 customers in Queue List...");
		System.out.println("   Press E to Display available rooms...");
		System.out.println("   Press D to Remove customer from room...");
        System.out.println("   Press F to Find a room from customer name...");
		System.out.println("   Press S to Store Room and Queue details in a text file...");
		System.out.println("   Press L to Retrive customer details back from the text file...");
		System.out.println("   Press O to See Ordered room details alphabetically by name...");
		System.out.println("   Press X to Exit...");
		
		menu.getTheMenu(); //call getTheMenu to receive the user insertion and do further actions
	}
}
