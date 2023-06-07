package Ticket;

import Customer.Customer;
import Customer.CustomerManagement;
import Plane.Plane;
import Plane.PlaneManagement;

import static Plane.PlaneManagement.getPlaneManagement;


public class Ticket {
    private String id;
    private String type;
    private String bookingDate;
    private String flyDate;
    private String fromPlace;
    private String starTime;
    private String toPlace;
    private String arrivalTime;
    private String seat;
    private String boardingTime;
    private String oderFootPrink;
    private String luggage;
    private String fare;

    private String idPlane;
    private  String idCustomer;




    public Ticket() {
    }

    public Ticket(String id, String idCustomer, String idPlane, String type, String bookingDate, String flyDate, String fromPlace, String starTime,
                  String toPlace, String arrivalTime, String seat,
                  String boardingTime, String oderFootPrink, String luggage, String fare) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idPlane = idPlane;
        this.type = type;
        this.bookingDate = bookingDate;
        this.flyDate = flyDate;
        this.fromPlace = fromPlace;
        this.starTime = starTime;
        this.toPlace = toPlace;
        this.arrivalTime = arrivalTime;
        this.seat = seat;
        this.boardingTime = boardingTime;
        this.oderFootPrink = oderFootPrink;
        this.luggage = luggage;
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFlyDate() {
        return flyDate;
    }

    public void setFlyDate(String flyDate) {
        this.flyDate = flyDate;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getOderFootPrink() {
        return oderFootPrink;
    }

    public void setOderFootPrink(String oderFootPrink) {
        this.oderFootPrink = oderFootPrink;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(String idPlane) {
        this.idPlane = idPlane;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "-----Ticket----" +"\n"+
                "id: " + id + "\n" +
                " type: " + type + "\n" +
                "Customer: " + getCustomer() + "\n" +
                "Plane: " + getPlane() + "\n" +
                " bookingDate: " + bookingDate + "\n" +
                " flyDate='" + flyDate + "\n" +
                " fromPlace: " + fromPlace + "\n" +
                " starTime: " + starTime + "\n" +
                " toPlace: " + toPlace + "\n" +
                " arrivalTime: " + arrivalTime + "\n" +
                " seat: " + seat +  "\n" +
                " boardingTime: " + boardingTime +"\n" +
                " oderFootPrink: " + oderFootPrink + "\n" +
                " luggage: " + luggage + "\n" +
                " fare: " + fare + "\n" ;
    }

    private String getPlane() {
        PlaneManagement planeManagement = getPlaneManagement();
        Plane plane = planeManagement.timKiemById(idPlane);
        String result = plane.getName();
        return result;
    }

    private String getCustomer() {
        CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

        Customer customer = customerManagement.timKhachhang(this.idCustomer);
        String result = customer.getName() + ", " + customer.getAge() +  ", " + customer.getSex();
        return result;
    }

    public String toFile2(){
        return  id + "," + idCustomer + ","  +idPlane + "," + type + ","  + bookingDate + ","+flyDate + ","
                + fromPlace + "," + starTime + ","+ toPlace
                + "," + arrivalTime + "," + seat + ","  + boardingTime + "," + oderFootPrink + "," + luggage + "," + fare;
    }
}
