import java.util.*;
public class MovieTicket{
  private String movieName;
  private String seatNumber;
  private int price;
  public MovieTicket(String movieName,String seatNumber,int price){
    this.movieName=movieName;
    this.seatNumber=seatNumber;
    this.price=price;
    System.out.println("Ticket booked successfully!");
  }
  public void ticketDetails(){
    System.out.println("Movie Name:- "+movieName);
    System.out.println("Seat Number:- "+seatNumber);
    System.out.println("Movie ticket price:- "+price);
  }
  public static void main(String[] args){
    String movieName="One Day";
    String seatNumber="A-1";
    int price=500;
    MovieTicket ticket=new MovieTicket(movieName,seatNumber,price);
    ticket.ticketDetails();
  }
}