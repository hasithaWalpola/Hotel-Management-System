public class Menu {
	static HotelReservation ht = new HotelReservation();
	static Room room =new Room();
	static Customer cus = new Customer();
	static Queue queue= new Queue();
	public void getTheMenu(){
		
		
		loop : while(true){
                           System.out.print("");
			   System.out.print("Your Option : ");
			char userSelectedOption = ht.sc.next().toLowerCase().charAt(0); // get the user insertion
			
			switch(userSelectedOption){
			case 'a':
				Customer.assignCutomerOnRoom(); //add a customer to a room
				break;
			case 'v':
				room.determineAllRoomDetails(); //view all the room numbers and customer names
				break;
			case 'q':
				queue.viewQueueDetails(); //view all the queue list
				break;
			case 'w':
				queue.displayAndRemoveFromQueue(); //remove and display last 3 customers of queue list
				break;
			case 'e':
				room.determineAvailableRooms(); //see rooms which are not rented yet
				break;
			case 'd':
				Customer.removeCustomer();   //delete an existing customer from a room
				break;
			case 'f':
				Customer.searchCustomer(); //find a room number using customer name
				break;
			case 's':
				room.saveDetails();  //save entered room details to text file
				queue.saveQueueDetails();  //save queue list to text file
				break;
			case 'l':
				room.readDetails(); //Retrieve saved room details from text file
				queue.readQueDetails();  //Retrieve queue list from text file
				break;
			case 'o':
				room.getCustomerInOrder(); //see customer names in alphabetical order with room number
				break;
			case 'x':
				System.out.print("Thank You !"); // exit the program
				System.exit(1);
				break;	
			default :
				System.out.print("Please Try Again !");
			}
			   System.out.println();
			   
		}
	}
}

