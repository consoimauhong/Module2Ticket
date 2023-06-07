package Plane;

public class Plane {
    private String id;
    private String name;
    private String amountSeat;
    private String fromPlance;
    private String toPlance;
    private String starTime;
    private String endTime;
    private double fare;

    public Plane() {
    }

    public Plane (String id, String name, String amountSeat, String fromPlance, String toPlance, String starTime, String endTime, double fare) {
        this.id = id;
        this.name = name;
        this.amountSeat = amountSeat;
        this.fromPlance = fromPlance;
        this.toPlance = toPlance;
        this.starTime = starTime;
        this.endTime = endTime;
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmountSeat() {
        return amountSeat;
    }

    public void setAmountSeat(String amountSeat) {
        this.amountSeat = amountSeat;
    }

    public String getFromPlance() {
        return fromPlance;
    }

    public void setFromPlance(String fromPlance) {
        this.fromPlance = fromPlance;
    }

    public String getToPlance() {
        return toPlance;
    }

    public void setToPlance(String toPlance) {
        this.toPlance = toPlance;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "----Plane---" + "\n" +
                "id: " + id + "\n" +
                " name: " + name + "\n" +
                " amountSeat: " + amountSeat + "\n" +
                " fromPlance: " + fromPlance + "\n" +
                " toPlance: " + toPlance + "\n" +
                " starTime: " + starTime +"\n" +
                " endTime: " + endTime + "\n" +
                " fare: " + fare;
    }
    public String toFile1(){
        return id + "," + name + "," + amountSeat + "," + fromPlance + "," + toPlance + "," + starTime + "," + endTime + "," + fare;
    }
}
