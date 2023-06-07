package Ticket;

import Customer.CustomerManagement;
import Plane.PlaneManagement;

import java.util.Scanner;

public class TicketManagementMenu {
    TicketManagement ticketManagement = TicketManagement.getTicketManagement();
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    PlaneManagement planeManagement = PlaneManagement.getPlaneManagement();

    Scanner sc = new Scanner(System.in);
     public void Menu(){
         int choice = 0;
         do {
             System.out.println("*******************************************************************");
             System.out.println(" *                      ----Menu----                               *");
             System.out.println("*               1. Thêm thông tin vé                              *");
             System.out.println(" *               2. Sửa thông tin vé bay qua id:                   *");
             System.out.println("*               3. Xóa thông tin vé bay qua id :                  *");
             System.out.println(" *               4. Tìm kiếm thông tin vé bay qua id:              *");
             System.out.println("*               5.Lấy số lượng vé máy bay:                        *");
             System.out.println(" *               6. Kiểm tra thông tin vé bay qua id:              *");
             System.out.println("*               7. Hiển thị thông tin vé bay:                     *");
             System.out.println(" *               8. Đọc file:                                      *");
             System.out.println("*               0. Thoát khỏi chương trình!                       *");
             System.out.println(" *             ---Vui lòng bạn hay lựa chọn   ---                  *");
             System.out.println("*******************************************************************");

             choice = sc.nextInt();
             sc.nextLine();
             switch (choice){
                 case 1 -> addTicket();
                 case 2 -> fixById();
                 case 3 ->  removeList();
                 case 4 -> searchById();
                 case 5 -> getTicketAmount();
                 case 6 ->checkById();
                 case 7 ->disPlay();
                 case 8 -> ticketManagement.readFromFile();
                 default -> System.out.println("Lựa chọn của bạn không hợp lệ! Vui long bạn thao tác lại");

             }
         }while (choice != 0);
     }
     //khoi tao phuong thức
    private void addTicket(){
        System.out.println("Thêm thông tin vé: ");
        System.out.println("Thêm id vé máy bay: ");
        String id = sc.nextLine();
        while (ticketManagement.kiemtraVe(id)){
            System.out.println("Id đã tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Nhập ID khách hàng: ");
        String idCustomer = sc.nextLine();
        while (!customerManagement.kTraID(idCustomer)){
            System.out.println("Id không tồn tại! Vui lòng nhập lại: ");
            idCustomer = sc.nextLine();
        }
        System.out.println("Nhập ID máy bay: ");
        String idPlane = sc.nextLine();
        while (!planeManagement.checkPlaneById(idPlane)){
            System.out.println("Id khhong tồn tại! Vui lòng nhập lại: ");
            idPlane = sc.nextLine();
        }
        System.out.println("Thêm loại vé máy bay: ");
        String type = sc.nextLine();
        System.out.println("Thêm ngày đặt vé: ");
        String bookingDate = sc.nextLine();
        System.out.println("Thêm ngày bay: ");
        String flyDate = sc.nextLine();
        System.out.println("Thêm nơi khởi hành: ");
        String fromPlace = sc.nextLine();
        System.out.println("Thêm thời gian khởi hành: ");
        String starTime = sc.nextLine();
        System.out.println("Thêm điểm đến:  ");
        String toPlace = sc.nextLine();
        System.out.println("Thêm thời gian đến: ");
        String arrivalTime = sc.nextLine();
        System.out.println("Thêm vị trí chỗ ngồi:");
        String seat = sc.nextLine();
        System.out.println("Thêm thời gian bay dự kiến: ");
        String boardingTime = sc.nextLine();
        System.out.println("Thêm oderFoodPrink: ");
        String oderFoodPrink = sc.nextLine();
        System.out.println("Thêm hành lý: ");
        String luggage = sc.nextLine();
        System.out.println("Thêm giá vé: ");
        String fare = sc.nextLine();

        Ticket ticket = new Ticket(id, idCustomer, idPlane, type, bookingDate, flyDate, fromPlace, starTime,
                toPlace, arrivalTime, seat, boardingTime, oderFoodPrink, luggage, fare);
        ticketManagement.add(ticket);
    }
    private void fixById(){
        System.out.println("Nhập id vé muốn thay đổi: ");
        String id = sc.nextLine();
        while (!ticketManagement.kiemtraVe(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại");
            id = sc.nextLine();
        }
        if(ticketManagement.kiemtraVe(id)){
            System.out.println(ticketManagement.kiemtraVe(id));
            System.out.println("Thay đổi Id Khách hàng: ");
            String idCustomer = sc.nextLine();
            while (!customerManagement.kTraID(idCustomer)){
                System.out.println("Id không tồn tại! Nhập lại id: ");
                idCustomer = sc.nextLine();
            }
            System.out.println("Thay đổi Id máy bay : ");
            String idPlane = sc.nextLine();
            while (!planeManagement.checkPlaneById(idPlane)){
                System.out.println("Id đẫ toond tại! Vui lòng nhập lại: ");
                idPlane = sc.nextLine();
            }
            System.out.println("Thay đổi loại vé máy bay: ");
            String type = sc.nextLine();
            System.out.println("Thay đổi ngày đặt vé: ");
            String bookingDate = sc.nextLine();
            System.out.println("Thay đổi nơi khởi hành: ");
            String fromPlace = sc.nextLine();
            System.out.println("Thay đổi thời gian khởi hành: ");
            String starTime = sc.nextLine();
            System.out.println("Thay đổi điểm đến:  ");
            String toPlace = sc.nextLine();
            System.out.println("Thay đổi thời gian đến: ");
            String arrivalTime = sc.nextLine();
            System.out.println("Thay đổi vị trí chỗ ngồi:");
            String seat = sc.nextLine();
            System.out.println("Thay đổi thời gian bay dự kiến: ");
            String boardingTime = sc.nextLine();
            System.out.println("Thay đổi oder :");
            String oderFoodPrink = sc.nextLine();
            System.out.println("Thay đổi hành lý: ");
            String luggage = sc.nextLine();
            System.out.println("Thay đổi giá vé: ");
            String fare = sc.nextLine();
            ticketManagement.suaTicket(id, idCustomer, idPlane, type, bookingDate, fromPlace, starTime, toPlace,
                    arrivalTime, seat, boardingTime, oderFoodPrink, luggage, fare);
        }
    }
    private void removeList(){
        System.out.println("Nhập id khách hàng muốn xóa: ");
        String id = sc.nextLine();
        while (!ticketManagement.kiemtraVe(id)){
            System.out.println("ID không tồn tại!Nhập lại id muốn xoá: ");
            id = sc.nextLine();
        }
        ticketManagement.xoaVe(id);
        System.out.println(" Đã xóa thành công ");
    }
    private void searchById(){
        System.out.println("Nhập id muốn tìm kiếm: ");
        String id = sc.nextLine();
        while(!ticketManagement.kiemtraVe(id)){
            System.out.println("ID không tồn tại! Nhập lại ID muốn tiềm kiếm: ");
            id = sc.nextLine();
        }
        System.out.println(ticketManagement.timKem(id));
    }
   private void getTicketAmount(){
       System.out.println("Số lượng vé đang có la: " + ticketManagement.getAmount());
   }
    private void checkById(){
        System.out.println("Nhập Id vé  muốn kiểm tra: ");
        String id = sc.nextLine();
        while (!ticketManagement.kiemtraVe(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println(ticketManagement.timKem(id));
    }
    private void disPlay(){
         ticketManagement.inVebay();
    }
}
