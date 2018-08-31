package com.example.uptech.newpharma.pharmacy_directory;

/**
 * Created by uptech on 04/08/2018.
 */

public class pharmacy_dicrectory_const {
    int image;
    String name;
    String phone;
    String address;

    public pharmacy_dicrectory_const(int image, String name, String phone) {
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.address= address;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
