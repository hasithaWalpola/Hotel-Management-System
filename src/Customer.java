import java.util.InputMismatchException;

public class Customer {
	static HotelReservation ht = new HotelReservation();
	static Menu menu = new Menu();
	static Queue queue = new Queue();

	public static void assignCutomerOnRoom() { // add customer to a room
		System.out.println("Please enter the room number between 0 - 9 : ");
		try {
			int countCheck = 0;
			for (int j = 0; j < ht.roomStatus.length; j++) {
				if (ht.roomStatus[j].equals("available")) {
					countCheck++;
				}

			}
			if (countCheck == 0) {
				System.out.println(" Sorry! All rooms are booked");
				System.out.println("");
				menu.getTheMenu();
			}
			ht.roomNumber = ht.sc.nextInt(); // get the room number

			if (ht.roomNumber < ht.roomStatus.length && ht.roomNumber >= 0) { // check
																				// the
																				// validation
																				// of
																				// room
																				// number
				if (ht.roomStatus[ht.roomNumber].equals("available")) { // check
																		// whether
																		// the
																		// room
																		// is
																		// vacant
																		// or
																		// not

					System.out.print("Please enter a name of customer for room number " + ht.roomNumber + " : "); // prompt
																													// message
																													// to
																													// say
																													// insert
																													// the
																													// customer
																													// name
					ht.roomCustomerName = ht.sc.next(); // get customer name

					ht.roomStatus[ht.roomNumber] = ht.roomCustomerName;
					ht.roomStatusTemp[ht.roomNumber] = ht.roomCustomerName;

					System.out.println("Successfully added");// say customer
																// that the
																// opertaion
																// successfully
																// done
					queue.addCustomerToQueue();

				} else {
					System.out.println("Room No " + ht.roomNumber + " is reserved !");
					System.out.println("");
					menu.getTheMenu();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input"); // print an error message if
													// wrong room number is
													// entered
			menu.getTheMenu();
		}

	}

	public static void removeCustomer() { // delete an existing customer from a
											// room
		try {
			System.out.print("Please enter the room number to delete the customer : ");
			ht.roomNumber = ht.sc.nextInt(); // get room number

			if (ht.roomNumber < ht.roomStatus.length) { // check whether the
														// entered room number
														// is exist in array
				ht.roomStatus[ht.roomNumber] = "available"; // change the room
															// status into
															// available
															// according to room
															// number
				System.out.print("Successfully deleted.");
			}
		} catch (Exception e) {
			System.err.println("Invalid Input"); // prompt an error message if
													// the user inserted a wrong
													// room no
		}

	}

	public static void searchCustomer() { // find a room number using customer
											// name

		try {
			System.out.print("Please enter the customer's name : ");
			ht.roomCustomerName = ht.sc.next(); // get the customer name

			for (int x = 0; x < ht.roomStatus.length; x++) {
				if (ht.roomStatus[x].equalsIgnoreCase(ht.roomCustomerName)) { // check
																				// whether
																				// the
																				// customer
																				// is
																				// in
																				// current
																				// room
																				// according
																				// to
																				// room
																				// number

					System.out.print(ht.roomStatus[x] + "'s room No is " + x + ".");
				}
			}
		} catch (Exception e) {
			System.err.println("Invalid Input");
		}

	}
}
