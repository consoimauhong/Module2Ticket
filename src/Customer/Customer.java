package Customer;

import java.io.Serializable;

public class Customer implements Serializable {
    private String id;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String address;
    private String email;

    public Customer() {
    }

    public Customer(String id, String name, int age, String sex, String phone, String address, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "----Customer----" + "\n" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "age: " + age + "\n"+
                "sex: " + sex + "\n" +
                "phone: " + phone + "\n" +
                "address: " + address + "\n" +
                "email: " + email + "\n" ;
    }
    public String toFile(){
        return id + "," + name  + "," + age + "," + sex + "," + phone + "," + address + "," + email ;
    }
}
