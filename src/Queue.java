import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Queue {
	static HotelReservation ht = new HotelReservation();
	static Menu menu = new Menu();
	
	
	public static void setQueStatus(String changedQueueStatus[]){ //assign Queue status as empty
		for (int x = 0; x < ht.que.length; x++){ // input "empty" as 7 index of array
			
			ht.que[x] ="empty";
		}
	}
	public static void viewQueueDetails(){ //view all queue details
		for (int x = 0; x < ht.que.length; x++){ 
			System.out.println("Queue No " + (x+1) + " is " + ht.que[x]); // printing
		}
	}
	public static void displayAndRemoveFromQueue(){ //view first 3 customers' queue list
		int nameCount=0;
		for (int x = 6; x >= 0; x--){ 
			if(!ht.que[x].equals("empty")){
				nameCount++;
				System.out.println(ht.que[x] + " successfully removed");
				ht.que[x]="empty";
				ht.countQueueEmpty--;
				if(nameCount==3){
					menu.getTheMenu();
				}
			}
			
		}
		 if(nameCount==0){
				System.out.println("No customers in Queue list to delete");
			}
	}
	
	public void addCustomerToQueue() { // Add customer


        for (int x = ht.countQueueEmpty; x >= 0; x--) {
            if (x == ht.que.length) {
                System.out.println("list is full.");
                System.out.println("");

                System.out.println(ht.que[6] + " removed.");
                continue;
            } else {
                ht.que[x + 1] = ht.que[x];

            }
        }

        ht.que[0] = ht.roomCustomerName;
        ht.countQueueEmpty++;
    }
	public void saveQueueDetails(){//save entered details to a text file
		PrintWriter pw3 = null;
		
		try{
			FileWriter fw1 = new FileWriter ("D:/CustomerQueue.txt"); // give the file path and file name
			fw1.write("");
			fw1.close();
			
			pw3 = new PrintWriter(new FileWriter("D:/CustomerQueue.txt", true));
			
			pw3.printf("%s\t%s%n%n", "QueueNumber", "CustomerName");
			
			for (int x = 0; x < ht.que.length; x++){
				pw3.format("%s\t%s%n", x, ht.que[x]);
			}
			
		} catch (IOException e){
			System.err.println("file not found");
			
		} finally {
			pw3.close(); //close the print writer
		}
	}
	public void readQueDetails(){ //Load saved details from text file
		BufferedReader buf1 = null;
		
		try{
			buf1 = new BufferedReader(new InputStreamReader(new FileInputStream("D:/CustomerQueue.txt")));
			
			
			int queNumberTemp = 0;
			String nameTemp = "";
			
			buf1.readLine(); 
			buf1.readLine();
			
			for (String line = buf1.readLine(); line != null;line = buf1.readLine()){
				StringTokenizer strT = new StringTokenizer(line); //set a Tokenizer to get values from file as string values
				
				while (strT.hasMoreElements()){ //Tokenizing
					queNumberTemp = Integer.valueOf((String) strT.nextElement()); //queue number
					nameTemp = (String) strT.nextElement();
					
					if (ht.que.length > queNumberTemp){ // check tokernized queue > array length
						ht.que[queNumberTemp] = nameTemp; 
						 ht.countQueueEmpty=queNumberTemp; //set queue number count as queNumberTemp
						 if(!nameTemp.equals("empty")){
							 ht.countQueueEmpty=(queNumberTemp+1);
						 } 
						 if(queNumberTemp==7 && !nameTemp.equals("empty")){
							   ht.countQueueEmpty=7;
							    }
						  
					}
				}
			}
			
		} catch (Exception e){
			System.err.println("file not found"); // prompt a error message "QueueDetails Text file not found."
						
		} finally {
			try {
				buf1.close(); //close buffered reader
			} catch (IOException e) {
			}
		}
	}
}



