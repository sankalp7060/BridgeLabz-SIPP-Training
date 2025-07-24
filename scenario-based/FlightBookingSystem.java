import java.util.*;
interface Transport{
  String getTransportNumber();
}
class Flight implements Transport{
  private String flightNumber;
  Flight(String flightNumber){
    this.flightNumber=flightNumber;
  }
  public String getTransportNumber(){
    return flightNumber;
  }
  public String toString(){
    return "Flight "+flightNumber;
  }
}
class Booking<T extends Transport>{
  private String passengerName;
  private T transport;
  private String seatNumber;
  public Booking(String passengerName,T transport,String seatNumber){
    this.passengerName=passengerName;
    this.transport=transport;
    this.seatNumber=seatNumber;
  }
  public String getPassengerName(){
    return passengerName;
  }
  public T getTransport(){
    return transport;
  }
  public String getSeatNumber(){
    return seatNumber;
  }
  public String toString(){
    return "Passenger "+passengerName+", "+transport+" Seat Number "+seatNumber;
  }
}
class FlightBookingSystem<T extends Transport>{
  private List<Booking<T>> bookings=new ArrayList<>();
  private Set<String> bookedSeats=new HashSet<>();
  public boolean bookSeat(String passengerName,T transport,String seatNumber){
    if(bookedSeats.contains(seatNumber)){
      System.out.println("Seat already booked");
      return false;
    }
    Booking<T> booking=new Booking<>(passengerName,transport,seatNumber);
    bookings.add(booking);
    bookedSeats.add(seatNumber);
    System.out.println("Booking is successfull "+booking);
    return true;
  }
  public boolean isSeatAvailable(String seatNumber){
    return !bookedSeats.contains(seatNumber);
  }
  public void allBookings(){
    System.out.println("All Bookings:- ");
    for(Booking<T> booking:bookings){
      System.out.println(booking);
    }
  }
  public static void main(String[] args){
    Flight flight=new Flight("MKC-BC");
    FlightBookingSystem<Flight> flightBookingSystem=new FlightBookingSystem<>();
    flightBookingSystem.bookSeat("Sanky",flight,"C1");
    flightBookingSystem.bookSeat("Sankalp",flight,"B1");
    flightBookingSystem.bookSeat("San",flight,"A1");
    System.out.println(flightBookingSystem.isSeatAvailable("A1"));
    System.out.println(flightBookingSystem.isSeatAvailable("D1"));
    flightBookingSystem.allBookings();
  }
}