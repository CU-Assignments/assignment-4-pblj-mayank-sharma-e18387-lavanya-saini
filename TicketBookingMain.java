class TicketBookingSystem {
    int availableSeats = 5; 
    synchronized void bookTicket(String name, int seatsRequested) {
        System.out.println(name + " is trying to book " + seatsRequested + " seat(s)...");
        if (availableSeats >= seatsRequested) {
            System.out.println("Booking successful for " + name);
            availableSeats -= seatsRequested;
        } else {
            System.out.println("Booking failed for " + name + ". Not enough seats available.");
        }
        System.out.println("Remaining Seats: " + availableSeats + "\n");
    }
}
class BookingThread extends Thread {
    TicketBookingSystem tbs;
    int seatsRequested;
    BookingThread(TicketBookingSystem tbs, String name, int seatsRequested, int priority) {
        super(name);  
        this.tbs = tbs;
        this.seatsRequested = seatsRequested;
        setPriority(priority); 
    }
    public void run() {
        tbs.bookTicket(getName(), seatsRequested);
    }
}
public class TicketBookingMain {
    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        BookingThread t1 = new BookingThread(tbs, "VIP_User1", 2, Thread.MAX_PRIORITY);  
        BookingThread t2 = new BookingThread(tbs, "Normal_User1", 2, Thread.NORM_PRIORITY); 
        BookingThread t3 = new BookingThread(tbs, "VIP_User2", 1, Thread.MAX_PRIORITY);     
        BookingThread t4 = new BookingThread(tbs, "Normal_User2", 1, Thread.NORM_PRIORITY); 
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
