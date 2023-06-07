package Plane;

import Ticket.TicketManagementMenu;

import java.util.Scanner;

public class MainPlane {
    public static void main(String[] args) {
        PlaneManagementMenu planeManagementMenu = new PlaneManagementMenu();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("                 Xin chào!             ");
            System.out.println("                  0  _  0              ");
            System.out.println("      Hãy chọn 1 để vào menu nào        ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> planeManagementMenu.menu();
                default -> System.out.println("Lựa chọn không hợp lệ ");
            }
        }while(choice !=0);
    }
}
