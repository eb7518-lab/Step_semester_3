package week9.class_problems;

import java.util.Scanner;

abstract class AbstractTravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected double distance;

    public AbstractTravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends AbstractTravelBooking {
    public BusBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 2 * distance;
    }

    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends AbstractTravelBooking {
    public TrainBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 1.5 * distance;
    }

    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends AbstractTravelBooking {
    public FlightBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 2500 + 4 * distance;
    }

    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            AbstractTravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else {
                booking = new FlightBooking(distance);
            }

            System.out.printf("%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}