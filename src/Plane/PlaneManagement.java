package Plane;

import Customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneManagement {
    private static List<Plane> planeList;
    private PlaneManagement(){
        planeList = new ArrayList<>();
    }
    private static final PlaneManagement planeManagement = new PlaneManagement();
    public static PlaneManagement getPlaneManagement(){
        readFromFile();
        return planeManagement;
    }
    //1 thêm danh sách may bay
    public void addMayBay(Plane plane){
        planeList.add(plane);
        saveToFile();

    }
    //2 sửa thông tin máy bay theo ID
    public void suaMaybayById(String id, String name,String amountSeat, String fromPlance, String toPlance, String starTime, String endTime, Double fare) {
        for (Plane plane : planeList) {
            if (plane.getId().equals(id)) {
                plane.setName(name);
                plane.setAmountSeat(amountSeat);
                plane.setFromPlance(fromPlance);
                plane.setToPlance(toPlance);
                plane.setStarTime(starTime);
                plane.setEndTime(endTime);
                plane.setFare(fare);
                saveToFile();
            }
        }
    }
        //3 xóa thông tin máy bay theo ID
        public boolean xoaMaybayById (String id){
            for (Plane plane : planeList) {
                if (plane.getId().equals(id)) {
                    planeList.remove(plane);
                    saveToFile();
                    return true;
                }
            }
            return false;
        }
        //4 tìm kiếm thông tin máy bay theo ID
        public Plane timKiemById (String id){
            for (Plane plane : planeList) {
                if (plane.getId().equals(id)) {
                    return plane;
                }
            }
            return null;
        }
        //5 lấy số lượng danh sách plane
        public int laySoluongMB () {
            return this.planeList.size();
        }
        //6 kiểm tra thông tin máy bay qua ID?
        public boolean checkPlaneById (String id){
            for (Plane plane : planeList) {
                if (plane.getId().equals(id)) {
                    return true;
                }
            }
            return false;
        }
        //7 in danh sách máy bay
        public void inDanhSachMB () {
            for (Plane MB : planeList) {
                System.out.println(MB.toString());
            }
        }
        public void saveToFile(){
        try{
            FileWriter fileWriter = new FileWriter("plane.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Plane p: planeList){
                bufferedWriter.write(p.toFile1());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void readFromFile(){
        planeList.clear();
        try {
            FileReader fileReader = new FileReader("plane.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;//chuoi rỗng
            while ((line = bufferedReader.readLine()) != null){//đọc từng dòng cho đến cuối
                Plane plane = handleLine(line);
                planeList.add(plane);
//                System.out.println(plane);
            }
            bufferedReader.close();
            fileReader.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static Plane handleLine(String line){
        String[] strings = line.split(",");
        return new Plane(strings[0],strings[1], strings[2], strings[3], strings[4], strings[5], strings[6],Double.parseDouble(strings[7]));
    }

}
