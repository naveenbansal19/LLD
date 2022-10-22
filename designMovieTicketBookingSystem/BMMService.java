import java.util.List;

public class BMSService{
    List<CinemaHall> cinemas;

    public List<Movie> getMovies(Date date,String city);
    public List<CinemaHall> getCinemaHalls(String city);


}

public class CinemaHall{
    int cinemaHallId;
    String cinemaHallName;
    Address address;
    List<Audi> audiLists;

    public Map<Date,Movies> getMovies(List<Date> dateList);
    public Map<Date,Show> getShows(List<Date> dateList);

}

public class Address{
    int pincode;
    String street;
    String city;
    String state;
    String country;
}

public class Audi{
    int audiId;
    String audiName;
    int totalSeats;
    List<Show> shows;
}

public class Show{
    int shouwId;
    Movie movie;
    Date startTime;
    Date endTime;
    List<Seat>  seats; //based upo the show seats will vary that's why it is in 'Show' class.
    CinemaHall cinemaPlayedAt; 
}

public class Seat{
    int seatId;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;
}

public enum SeatType{
   DELUXE,ECONOMY,RECLINER;
}
public enum SeatStatus{
    RESERVED,BOOKED,AVAILABLE,NOT_AVAILABLE;
}

public class Movie{
    String movieName;
    Genre genre;
    int movieId;
    int durationInMinutes;
    String language;
    Date releaseDate;
    Map<String,List<Show>> cityShowMap; //different city k corresponding it will return shows
}

public enum Genre{
    FICTION,HORROR,COMEDY,ROMANTIC,OTHERS;
}
public class User{
    int userId;
    Search searchObj;
}
public class SystemMember extends User{ //system has additional power 
   Account account;
   String name;
   String email;
   Address address;
}

public class Member extends SystemMember{
    public Booking makeBooking(Booking booking);
    public List<Booking> getBooking();
}

public class Admin extends SystemMember{
    public boolean addMovie(Movie movie);
    public boolean addShow(Show show);
}

public class Account{
    string username;
    string password;
}

public class Search{
    public List<Movie> searchMoviesByName(String name);
    public List<Movie> searchMoviesByGenre(Genre genre);
    public List<Movie> searchMoviesByLanguage(String language);
    public List<Movie> searchMoviesByDate(Date releaseDate);
}

public class Booking{
    String bookingId;
    Date bookingDate;
    Member member;
    Show show;
    Audi audi;
    BookingStatus bookingStatus;
    double totalAmount;
    List<Seat> seats;
    Payment paymentObj;

    public boolean makePayment(Payment payment);
}

public enum bookingStatus{
    DECLINED,CONFIRMED,PENDING;
}

public class Payment{
    double amount;
    Date paymentDate;
    int transactionId;
    PaymentStatus paymentStatus;

}

public enum PaymentStatus{
    DECLINED,PENDING,REFUNDED,COMPLETED;
}
