package Customer;

import Customer.CustomerManagement;
import Customer.CustomerManagementMenu;
import Plane.PlaneManagementMenu;
import Ticket.TicketManagementMenu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("                 Xin chào!             ");
            System.out.println("                  0  _  0              ");
            System.out.println("      Hãy chọn 1 để vào menu nào        ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> customerManagementMenu.menu();
                default -> System.out.println("Lựa chọn không hợp lệ!");

            }
        } while (choice != 0);

//        List<Customer> studentDataFromFile = customerManagementMenu.readDataFromFile("test.csv");
//        for (Customer customer : studentDataFromFile){
//            System.out.println(customer);
//        }
    }

}