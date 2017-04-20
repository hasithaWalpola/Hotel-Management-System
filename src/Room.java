import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Room {
	 static HotelReservation ht = new HotelReservation();

	public static void setRoomStatus(String changedRoomStatus[]){ //set the status to "available" for all
		for (int x = 0; x < ht.roomStatus.length; x++){ // insert "available" for 10 indexes of array
			changedRoomStatus[x] = "available";
		}
		
	}
	public void determineAllRoomDetails(){ //view the room numbers and customer names
		for (int x = 0; x < ht.roomStatus.length; x++){ 
			System.out.println("room No " + x + " is " + ht.roomStatus[x]);
		}
	}
	
	public void determineAvailableRooms(){  // see available rooms
		int checkCount=0;
		for (int x = 0; x < ht.roomStatus.length; x++){
			if (ht.roomStatus[x].equals("available")){ // check availability
				System.out.print("\n");
				System.out.print("room No " + x + " is available"); // print room numbers
				checkCount++;
			}			
		}
		if(checkCount==0){
			System.out.print("Sorry! All rooms are booked ");
		}
	}
	public void saveDetails(){//store entered details to text file
		PrintWriter pw2 = null;
		
		try{
			FileWriter fw = new FileWriter ("D:/HotelReservation.txt"); // declare file writer and give the file path and file name to form a text file
			fw.write("");
			fw.close();
			
			pw2 = new PrintWriter(new FileWriter("D:/HotelReservation.txt", true));
			
			pw2.printf("%s\t%s%n%n", "roomNumber", "roomName"); 
			
			for (int x = 0; x < ht.roomStatus.length; x++){
				pw2.format("%s\t%s%n", x, ht.roomStatus[x]); // print the values
			}
			System.out.print("Successfully Saved");
		} catch (IOException e){
			System.err.println("file not found"); // file not found error
			
		} finally {
			pw2.close();
		}
	}
	
	public void readDetails(){ //Load saved room details from text file
		BufferedReader buf = null; // declare the buffered reader as empty
		
		try{
			buf = new BufferedReader(new InputStreamReader(new FileInputStream("D:/HotelReservation.txt"))); //assign path to buffered reader
			
			
			int numberTemp = 0;
			String nameTemp = "";
			
			buf.readLine(); // avoid reading headings in the file
			buf.readLine(); // // avoid spaces after heading in the file
			
			for (String line = buf.readLine(); line != null;line = buf.readLine()){
				StringTokenizer strT = new StringTokenizer(line); //declare a Tokenizer to get values from the file as string values
				
				while (strT.hasMoreElements()){ // do Tokenizing until finding empty element
					numberTemp = Integer.valueOf((String) strT.nextElement());
					nameTemp = (String) strT.nextElement(); //prompt for the customer name
					
					if (ht.roomStatus.length > numberTemp){ // check tokernized room number > array length
						ht.roomStatus[numberTemp] = nameTemp; 
						ht.roomStatusTemp[numberTemp] = nameTemp;  
					}
				}
			}
			System.out.print("Successfully read");
			
		} catch (Exception e){
			System.err.println("File not found");
						
		} finally {
			try {
				buf.close(); // close the buffered reader
			} catch (IOException e) {
			}
		}
	}
	public void printSortedNames(){
		// get sorted names using sString array
				for(int u=0; u< ht.roomStatusTemp.length;u++){
					if(!ht.roomStatusTemp[u].equals("available")){
						
						for (int k = 0; k < ht.roomStatus.length; k++){
							 if(ht.roomStatusTemp[u].equals(ht.roomStatus[k])){ // compare sorted customer name
								System.out.println("room No " + k + " is reserved for " + ht.roomStatusTemp[u]); // print  
									
						        		}					
									}
					}
					
				 }
	}
	public void getCustomerInOrder(){ // get Customer names in order

		String tempWord; // declare temporary empty string 		
		// bubble sort
		for(int i=0; i < ht.roomStatusTemp.length-1;i++){
			
			for(int j=1; j< ht.roomStatusTemp.length-1; j++){
				
				if(ht.roomStatusTemp[j-1].compareToIgnoreCase(ht.roomStatusTemp[j]) > 0){
					
					tempWord = ht.roomStatusTemp[j-1];
					ht.roomStatusTemp[j-1] = ht.roomStatusTemp[j];
					ht.roomStatusTemp[j] = tempWord;
				}
			}
		}
		printSortedNames(); 
	  }
	
}
