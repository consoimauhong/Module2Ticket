package Customer;

import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementMenu {
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

        Scanner sc = new Scanner(System.in);
        public void menu(){
            int choice = 0;
            do {
                System.out.println("*******************************************************************");
                System.out.println(" *                     ----Menu----                              *");
                System.out.println("*          1. Thêm khách hàng                                     *");
                System.out.println(" *         2. Sửa khách hàng theo mã id                          *");
                System.out.println("*          3. Xóa từng khách hàng ra khỏi danh sách dựa vào mã id *");
                System.out.println(" *         4. Xóa danh sách                                      *");
                System.out.println("*          5. Tìm khách hàng theo mã id                           *");
                System.out.println(" *         6. Lấy số lượng  khách hàng                           *");
                System.out.println("*          7. Kiểm tra danh sách rỗng                             *");
                System.out.println(" *         8. In ra danh sách                                    *");
                System.out.println("*          9. Đọc file                                            *");
                System.out.println(" *         0. Thoát khỏi chương trình                            *");
                System.out.println("*          +++Vui long bạn hãy lựa chọn+++                        *");
                System.out.println(" *****************************************************************");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1 -> addCustomer();
                    case 2 -> fixById();
                    case 3 -> removeCustomer();
                    case 4 -> removeList();
                    case 5 -> searchById();
                    case 6 -> getAmount();
                    case 7 -> checkNull();
                    case 8 -> disPlay();
                    case 9 -> customerManagement.readFromFile();
                    default -> System.out.println("Lựa chọn không hợp lệ" +
                                                  "Vui lòng lựa chọn lại! ");
                }
            }while(choice !=0);
        }

    private void addCustomer() {// khởi tạo phương thức
        System.out.println("Thêm khách hàng ");
        System.out.println("Thêm id khách hàng  ");
        String id = sc.nextLine();
        while (customerManagement.kTraID(id)){
            System.out.println("Id đã tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi khách hàng: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập giới tính khách hàng: ");
        String sex = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String number = sc.nextLine();
        System.out.println("Nhập địa chỉ vào");
        String address = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(id, name, age, sex, number, address, email);
        customerManagement.add(customer);
    }

    private void disPlay(){
            if(customerManagement.kiemTraDanhSachrong()) System.out.println("Danh sách rỗng!");
            else customerManagement.inDanhsachKhachhang();

    }
    private void checkNull(){
        System.out.println("Danh sách rỗng: " + customerManagement.kiemTraDanhSachrong());
    }

    private void getAmount(){
        System.out.println("Số lượng khách hàng: " + customerManagement.laySoluongKh());
    }
    private void removeList(){
        System.out.println("Danh sách khách hàng đã xóa hết");
            customerManagement.xoaAllDanhSach();

    }

    private void removeCustomer(){
        System.out.println("Nhập id khách hàng muốn xóa: ");
        String id = sc.nextLine();
        while (!customerManagement.kTraID(id)){
            System.out.println("Id không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
       customerManagement.xoaKhachHang(id);
        System.out.println("Bạn đã xóa thành công");
    }

    private void searchById() {
        System.out.println("Nhập id muốn tìm kiếm: ");
        String id = sc.nextLine();
        while (!customerManagement.kTraID(id)){
            System.out.println("Id không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println(customerManagement.timKhachhang(id));

    }
    private void fixById(){
        System.out.println("Nhập id khách hàng muốn thay đổi: ");
        String id = sc.nextLine();
        while (!customerManagement.ktTontaiKhachHang(id)){
            System.out.println("ID nhập không tồn tại ! Vui lòng hãy nhập lại");
            id = sc.nextLine();
        }
        if (customerManagement.ktTontaiKhachHang(id)){
            System.out.println("Nhập tên mới: ");
            String name = sc.nextLine();
            System.out.println("Nhập địa chỉ mới: ");
            String address = sc.nextLine();
            System.out.println("Nhập tuổi mới: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập số điện thoại mới: ");
            String phone = sc.nextLine();
            System.out.println("Nhập email mới: ");
            String email = sc.nextLine();

            customerManagement.suaKhachHanng(id, name, address, age, phone, email);
        }
    }

//    public java.util.List<Customer> readDataFromFile(String path){
//        java.util.List<Customer> customers = new ArrayList<>();
//        try{
//            FileInputStream fis = new FileInputStream(path);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            customers = (List<Customer>) ois.readObject();
//            fis.close();
//            ois.close();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return customers;
//    }

}
