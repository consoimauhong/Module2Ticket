import Customer.CustomerManagementMenu;
import Plane.PlaneManagementMenu;
import Ticket.TicketManagementMenu;

import java.util.Scanner;

public class TotalMenu {
    public static void main(String[] args) {

        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        PlaneManagementMenu planeManagementMenu = new PlaneManagementMenu();
        TicketManagementMenu ticketManagementMenu = new TicketManagementMenu();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("----Menu----");
            System.out.println("1. Menu CustomerList : ");
            System.out.println("2. Menu PlaneList : ");
            System.out.println("3. Menu TicketList : ");
            System.out.println("0. Exit!");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> customerManagementMenu.menu();
                case 2 -> planeManagementMenu.menu();
                case 3 -> ticketManagementMenu.Menu();
                default -> System.out.println("Thoát chương trình! ");
            }
        }while(choice !=0);
    }
}
