package Plane;

import Ticket.Ticket;

import java.util.Scanner;

public class PlaneManagementMenu {
    PlaneManagement planeManagement = PlaneManagement.getPlaneManagement();
    Scanner sc = new Scanner(System.in);

    public void menu(){
        int choice = 0;
        do {
            System.out.println("*******************************************************************");
            System.out.println(" *                      ----Menu----                               *");
            System.out.println("*               1. Thêm danh sách máy bay:                        *");
            System.out.println(" *               2. Sửa thông tin máy bay qua ID:                  *");
            System.out.println("*               3. Xóa danh sách máy bay thông qua ID:            *");
            System.out.println(" *               4. Tìm kiếm thông tin máy bay qua ID:             *");
            System.out.println("*               5. Lấy số lượng danh sách máy bay:                *");
            System.out.println(" *               6. Kiểm tra danh sách máy bay thông qua ID:       *");
            System.out.println("*               7. In danh sách sách máy bay:                     *");
            System.out.println(" *               8. Đọc file:                                      *");
            System.out.println("*               0. Thoát khỏi chương trình!                       *");
            System.out.println(" *             ---Vui lòng bạn hay lựa chọn   ---                  *");
            System.out.println("*******************************************************************");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> addMaybay();
                case 2 -> fixMaybayById();
                case 3 -> xoaMaybayById();
                case 4 -> searchById();
                case 5 -> laySoluongMB();
                case 6 -> checkPlaneById();
                case 7 -> inDanhSachMB();
                case 8 -> planeManagement.readFromFile();
                default -> System.out.println("Lựa chọn không hợp lệ ");

            }

        }while (choice != 0);
    }
    private void addMaybay(){
        System.out.println("Thêm id  máy bay: ");
        String id = sc.nextLine();
        while (planeManagement.checkPlaneById(id)){
            System.out.println("Id đã tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Thêm tên máy bay: ");
        String name = sc.nextLine();
        System.out.println("Thêm số lượng ghê:");
        String amountSeat = sc.nextLine();
        System.out.println("Thêm điểm xuất phát: ");
        String fromPlance = sc.nextLine();
        System.out.println("Thêm điểm đến : ");
        String toPlance = sc.nextLine();
        System.out.println("Thêm thời gian khởi hành: ");
        String starTime = sc.nextLine();
        System.out.println("Thêm thời gian đến: ");
        String endTime = sc.nextLine();
        System.out.println("Thêm giá vé:");
        Double fare = sc.nextDouble();

        Plane plane = new Plane(id, name, amountSeat, fromPlance, toPlance, starTime, endTime,fare);
        planeManagement.addMayBay(plane);

    }
    private void fixMaybayById(){
        System.out.println("Nhập ID bạn muốn thay đổi ");
        String id = sc.nextLine();
        while (!planeManagement.checkPlaneById(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại ");
            id = sc.nextLine();
        }
        if(planeManagement.checkPlaneById(id)){
            System.out.println("Nhập tên mới máy bay lại: ");
            String name = sc.nextLine();
            System.out.println("Nhập số lượng chỗ ngồi trên máy bay: ");
            String amountSeat = sc.nextLine();
            System.out.println("Nhập lại điểm xuất phát của máy bay ");
            String fromPlance = sc.nextLine();
            System.out.println("Nhập lại điểm đến của máy bay: ");
            String toPlance = sc.nextLine();
            System.out.println("Nhập lại thời gian đi: ");
            String starTime = sc.nextLine();
            System.out.println("Nhập lại thời gian đến: ");
            String endTime = sc.nextLine();
            System.out.println("Nhập lại giá vé: ");
            Double fare = sc.nextDouble();

            planeManagement.suaMaybayById(id, name, amountSeat, fromPlance, toPlance, starTime, endTime, fare);
        }else {
            System.out.println(" Không tìm thấy maý bay này! Hãy thử một lần nữa nha");
        }
    }
    private void xoaMaybayById(){
        System.out.println("Hãy nhập ID mà bạn muốn xóa đi: ");
        String id = sc.nextLine();
        while (!planeManagement.checkPlaneById(id)) {
            System.out.println("Không tìm thấy ID trong danh sách! Vui lòng bạn hãy nhập lại:");
            id = sc.nextLine();
        }if(planeManagement.checkPlaneById(id)){
            System.out.println(planeManagement.xoaMaybayById(id));
        }
    }
    private void searchById() {
        System.out.println("Hãy nhập ID bạn muốn tìm kiếm: ");
        String id = sc.nextLine();
        while (!planeManagement.checkPlaneById(id)) {
            System.out.println("Không tìm thấy ID trong danh sách! Vui lòng bạn hãy nhập lại:");
             id = sc.nextLine();
        }if(planeManagement.checkPlaneById(id)){
            System.out.println(planeManagement.timKiemById(id).toString());
        }
    }
    private void laySoluongMB(){
        System.out.println("Số lượng máy bay: " + planeManagement.laySoluongMB());
    }

    private void inDanhSachMB(){
        planeManagement.inDanhSachMB();
    }


    private void checkPlaneById(){
        System.out.println("Hãy nhập ID ban muốn kiểm tra đi nào: ");
        String id = sc.nextLine();
        System.out.println(planeManagement.timKiemById(id));
    }

}
