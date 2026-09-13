package week6.assignment_problems;

public class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 25);

        HallTicket second = priya;
        second.seatNumber = 45;

        System.out.println(priya.studentName + " " + priya.seatNumber);
        System.out.println(second == priya);

        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println(separate == priya);
    }
}