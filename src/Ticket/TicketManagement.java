package Ticket;

import Plane.Plane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketManagement {
    private static List<Ticket> TicketList; // khai bao danh sach vé

     private TicketManagement(){// khoi tạo đối tượng list ép thành array list;
         TicketList = new ArrayList<>();
     }
     public static final TicketManagement ticketManagement = new TicketManagement();
     public static TicketManagement getTicketManagement(){
         readFromFile();
         return ticketManagement;
     }


     //1 them thong tin chuyen bay
    public void add(Ticket ticket){
         TicketList.add(ticket);
         saveToFile();
    }


    // 2tim kiem thong tin chyen bay qua id
    public Ticket timKem(String id){
         for(Ticket ticket: TicketList){
             if(ticket.getId().equals(id)){
                 return ticket;
             }
         }
         return null;

    }
    //3 sua thong tin chuyen bay qua id
    public void suaTicket(String id, String idCustomer, String idPlane, String type, String bookingDate, String fromPlace, String starTime, String toPlace, String arrivalTime,
                          String seat, String boardingTime, String oderFoodPrink, String luggage, String fare ){
         for (Ticket ticket : TicketList){
             if(ticket.getId().equals(id)){
                 ticket.setIdCustomer(idCustomer);
                 ticket.setIdPlane(idPlane);
                 ticket.setType(type);
                 ticket.setBookingDate(bookingDate);
                 ticket.setFromPlace(fromPlace);
                 ticket.setStarTime(starTime);
                 ticket.setToPlace(toPlace);
                 ticket.setArrivalTime(arrivalTime);
                 ticket.setSeat(seat);
                 ticket.setBoardingTime(boardingTime);
                 ticket.setOderFootPrink(oderFoodPrink);
                 ticket.setLuggage(luggage);
                 ticket.setFare(fare);
                 saveToFile();
             }
         }
    }
    //4 xoa thong tin chuyen bay
    public boolean xoaVe(String id){
         for(Ticket ticket: TicketList){
             if(ticket.getId().equals(id)){
                 TicketList.remove(ticket);
                 saveToFile();
                 return true;
             }
         }
         return false;
    }
    //5 kiem tra thong tin chuyen bay
    public boolean kiemtraVe(String id){
         if(TicketList.size() > 0){
             for(Ticket ticket: TicketList){
                 if(ticket.getId().equals(id)){
                     return true;
                 }
             }
         }
         return false;
    }
    //6 hien thi thong tin chuyen bay
    public void inVebay(){
         for(Ticket DSve: TicketList){
             System.out.println(DSve.toString());
         }
    }
    //7 lấy số lượng
    public int getAmount(){
         return this.TicketList.size();
    }
    public void saveToFile(){
        try{
            FileWriter fileWriter = new FileWriter("ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Ticket t: TicketList){
                bufferedWriter.write(t.toFile2());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void readFromFile(){
        TicketList.clear();
        try {
            FileReader fileReader = new FileReader("ticket.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;//chuoi rỗng
            while ((line = bufferedReader.readLine()) != null){//đọc từng dòng cho đến cuối
                Ticket ticket = handleLine(line);
                TicketList.add(ticket);
//                System.out.println(ticket);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static Ticket handleLine(String line){
        String[] strings = line.split(",");
        return new Ticket(strings[0],strings[1], strings[2], strings[3], strings[4], strings[5], strings[6],
                strings[7],strings[8],strings[9],strings[10],strings[11],strings[12], strings[13], strings[14]);
    }
}
