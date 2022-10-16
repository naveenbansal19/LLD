package LLD.HotelManagementSystem;

public class Hotel {
    String name;
    Integer id;
    Location hotelLocation;
    List<Room> roomList;
}
public class Location{
    int pin;
    String Street;
    String area;
    String city;
    String country;
}

public class Room{
    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLogs> houseKeepingLogs;
}

public enum RoomStyle{
    DELUX,STANDARD,FAMILY_SUITE;
}

public enum RoomStatus{
    AVAILABLE,RESERVED,OCCUPIED,NOT_AVAILABLE;
}

class RoomKey{
    String keyId;
    String barCode;
    Date issuedDate;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room);
}

class HouseKeepingLog{
    String description;
    Date startDate;
    int duration;
    HouseKeeper housekeeper;

    public void addRoom(Room room);
}

abstract class Person{
    String name;
    Account accountDetail;
    String phone;
}

public class Account{
    String userName;
    String password;
    AccountStatus accountStatus;
}

public enum AccountStatus{
    ACTIVE,CLOSED,BLOCKED;
}

class HouseKeeper extends Person{
    public List<Room> public getRoomServiced(Date date);
}

class Guest extends Person{
    Search searchObj;
    Booking bookObj;

    public List<RoomBookings> getAllRoomBookings();
}

class Receptionist extends Person{
    Search searchObj;
    Booking bookObj;

    public void checkInGuest(Guest guest,RoomBooking bookingInfo);
    public void checkOutGuest(Guest guest,RoomBooking bookingInfo);
}

class Admin extends Person{
    public void addRoom(Room roomDetail);
    public Room deleteRoom(String roomId);
    public void editRoom(Room roomDetail); 
}

class search{
    public List<Room> searchRoom(Roomstyle roomstyle,Date startDate,int duration);
}

class Booking{
    public RoomBooking createBooking(Guest guestInfo);
    public RoomBooking cancelBooking(int bookingId);
}

class RoomBooking{
    String bookingId;
    Date startDate;
    Int durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharges;
}


/*
 Decorator Design Pattern is used to decorate the above prices  //for BaseRoomCharge 
 */

 interface BaseRoomCharge{
    double getCost();
 }

 class RoomCharge implements BaseRoomCharge{
   double cost;
   double getCost(){
    return cost;
   }
   void setCost(double cost){
    this.cost=cost;
   }
 }

 class RoomServiceCharge implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    double getCost(){
       baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
       return baseRoomCharge.getCost();
    }
 }

 class InRoomPurchaseCharges implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    double getCost(){
       baseRoomCharge.setCost(baseRoomCharge.getCost() + cost); //inroompurchasecharges + base room cost
       return baseRoomCharge.getCost();
    }
 }
