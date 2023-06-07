package Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private static List<Customer> customerList;//khai bao danh sach k.hang

    private CustomerManagement(){// khoi tao doi tuong de ep tu List thanh ArrayList
        customerList = new ArrayList<>();
    }
    private static final CustomerManagement customerManagement = new CustomerManagement();
    public static CustomerManagement getCustomerManagement(){
        readFromFile();
        return customerManagement;
    }
    //1 them danh sach khach hang

    public void add(Customer customer){//phuong thuc them co doi tuong la k.hang co ten k.hang
        customerList.add(customer);//them thi truyen cuctomer
//        writeToFile("test.csv", customerList);
        saveToFile();
    }
    //2 in danh sach khach hang
    public void inDanhsachKhachhang(){
        for (Customer Danhsach : customerList) {
            System.out.println(Danhsach);
        }
    }
    //3 kiem tra xem danh sach khach hang co rỗng hay không
    public boolean kiemTraDanhSachrong(){
         return this.customerList.isEmpty();
    }
    // 4 lây ra số lượng khách hàng trong DS
    public int laySoluongKh(){
       return this.customerList.size();

    }
    //5 xoa all DS
    public void xoaAllDanhSach(){
        this.customerList.removeAll(customerList);
    }
    //6 kiêm tra khach hang dựa trên mã khách hàng
    public boolean ktTontaiKhachHang(String id){
        for (Customer customer : customerList){
            if(customer.getId().equals(id)){
//                System.out.println(customer);
                return true;
            }
        }
       return false;
    }
    // 7 xoa KH ra khỏi DS dựa vao ID
    public boolean xoaKhachHang(String id){
        for (Customer customer : customerList){
            if (customer.getId().equals(id)){
                customerList.remove(customer);
                saveToFile();
                return true;
            }
        }
        return false;
    }
    //8 tìm kiếm KH theo ID:
    public Customer timKhachhang(String id){
        for (Customer customer : customerList){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }
    //9 suaKhachHAng:
    public void suaKhachHanng(String id,String name, String address, int age, String phone, String email){
        //kiem tra khach hang ton tai k
        for(Customer customer : customerList){
            if(customer.getId().equals(id)){
                customer.setName(name);
                customer.setAddress(address);
                customer.setAge(age);
                customer.setPhone(phone);
                customer.setEmail(email);
                saveToFile();
            }
        }
    }

    public boolean kTraID(String id){
        if(customerList.size()> 0){
            for (Customer customer: customerList){
                if(customer.getId().equals(id)){
                    return true;
                }
            }
        }
        return false;
    }

//    public void writeToFile(String path, List<Customer> customers) {
//        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(customers);
//            oos.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void saveToFile(){
        try {
            FileWriter fileWriter = new FileWriter("customers.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer c : customerList){
                bufferedWriter.write(c.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            throw new RuntimeException(e);

        }
    }
    public static void readFromFile(){
        customerList.clear();
        try {
            FileReader fileReader = new FileReader("customers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                Customer customer = handleLine(line);
                customerList.add(customer);
//                System.out.println(customer);
            }
            bufferedReader.close();
            fileReader.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static Customer handleLine(String line){
        String[] strings = line.split(",");
        return new Customer(strings[0],strings[1], Integer.parseInt(strings[2]), strings[3], strings[4], strings[5], strings[6]);
    }
}

