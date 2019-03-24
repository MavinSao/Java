import java.util.Scanner;

public class HotelManagement {
	private String floors;
	private String numberRoomEeachFloor;
	private int rooms;
	private String floorNumber;
	private String roomNumber;
	private Scanner sc = new Scanner(System.in);
	private String floorAndRoom[][];
	private Validation validate = new Validation(); 
	

	public void setUpHotel() {
		
		System.out.println("----------Setting up hotel----------");
		//Input number of floor
		do {
		System.out.print("->Enter number of floor:"); floors = sc.next();
		}while(!validate.isValidate(floors));
		//Input number of room
		do {
		System.out.print("->Enter number of room in each floor:"); numberRoomEeachFloor =sc.next();
		}while(!validate.isValidate(numberRoomEeachFloor));
		int floor = Integer.valueOf(floors);
		int numRoom = Integer.valueOf(numberRoomEeachFloor);
		int rooms = floor * numRoom;
		floorAndRoom = new String[floor][numRoom];
		System.out.println("Hotel is already setup with "+ floors +" floors and "+ rooms +" rooms Successfully");		
	
	}
	public void displayMenu() {
		do {
		char ch;
			System.out.println("----------Hotel Management----------");
			System.out.println("1- Check In");
			System.out.println("2- Check Out");
			System.out.println("3- Display");
			System.out.println("4- Exit");
			System.out.println("------------------------------------");
			System.out.print("Choose option(1-4) :"); ch = sc.next().charAt(0);
			switch (ch) {
				case '1': checkIn();break;
				case '2': checkOut(); break;
				case '3': display();break;
				case '4': System.out.println("=>Good Bye!");
						System.exit(0); break;
				default: System.out.println("Please Choose option(1-4)"); 	
			} 
		}while(true);
			
			
	}
	public void checkIn() {
		
		String guestName;
		System.out.println("----------CheckIn hotel----------");
		do {
		System.out.print("->Enter floor number"+"(1->"+floorAndRoom.length+"):"); floorNumber =sc.next();
		}while(!validate.isValidate(floorNumber));
		do {
		System.out.print("->Enter room number"+"(1->"+numberRoomEeachFloor+"):"); roomNumber =sc.next();
		}while(!validate.isValidate(roomNumber));
		int floorNum = Integer.valueOf(floorNumber);
		int roomNum = Integer.valueOf(roomNumber);
		
		if(floorAndRoom[floorNum-1][roomNum-1]==null) {
		System.out.print("->Enter guest's name:"); guestName =sc.next();
		floorAndRoom[floorNum-1][roomNum-1]=guestName;
		System.out.println(guestName+" checkin Successfully!");
		}
		else System.out.println("This room is already check in, Please find another room!");
		
	}
	public void checkOut() {
		System.out.println("----------CheckOut hotel----------");
		do {
		System.out.print("->Enter floor number"+"(1->"+floorAndRoom.length+"):"); floorNumber =sc.next();
		}while(!validate.isValidate(floorNumber));
		do {
		System.out.print("->Enter room number"+"(1->"+numberRoomEeachFloor+"):"); roomNumber =sc.next();
		}while(!validate.isValidate(roomNumber));
		int floorNum = Integer.valueOf(floorNumber);
		int roomNum = Integer.valueOf(roomNumber);
		if(floorAndRoom[floorNum-1][roomNum-1]==null) {
			System.out.println("No one checkIn in this room, you can't checkout!");
		}
		else {
			System.out.print("->Guest's name: " + floorAndRoom[floorNum-1][roomNum-1]+", Press 1 to checkout and 0 to cancel :"); 
			int yesNo= sc.nextInt();
			if(yesNo==1) {
				floorAndRoom[floorNum-1][roomNum-1]=null;
				System.out.println("=>"+floorAndRoom[floorNum-1][roomNum-1]+" has been checkout successfully!");		
			}
			else {
				System.out.println();
			}
		}
	}
	public void display() {
		System.out.println("----------Display----------");
		
		for(int i=0;i<floorAndRoom.length;i++) {
			System.out.print("Floor "+(i+1)+":");
			for(int j=0;j<floorAndRoom[i].length;j++) {
				System.out.print(floorAndRoom[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
}
