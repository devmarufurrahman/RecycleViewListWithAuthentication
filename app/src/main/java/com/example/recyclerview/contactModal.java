package com.example.recyclerview;

public class contactModal {
    int img;
     String name;
     String number ;

    public contactModal(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public contactModal( String name, String number) {

        this.name = name;
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
