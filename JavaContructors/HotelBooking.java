public class HotelBooking{
  private String guestName;
  private String roomType;
  private int nights;
  public HotelBooking() {
    this.guestName = "Unknown";
    this.roomType = "Standard";
    this.nights = 1;
  }
  public HotelBooking(String guestName,String roomType,int nights){
    this.guestName=guestName;
    this.roomType=roomType;
    this.nights=nights;
  }
  public HotelBooking(HotelBooking other){
    this(other.guestName,other.roomType,other.nights);
  }
}