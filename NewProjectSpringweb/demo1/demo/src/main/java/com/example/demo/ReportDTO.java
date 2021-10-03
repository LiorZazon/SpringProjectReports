package com.example.demo;

import java.io.Serializable;

public class ReportDTO {

    public int id;
    public String license_plate;
    public int driver_id;
    public int speed;


    public ReportDTO(int id, String license_plate, int driver_id, int speed) {
        this.id = id;
        this.license_plate = license_plate;
        this.driver_id = driver_id;
        this.speed = speed;
    }

    public ReportDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public int getDriver_id(){
        return driver_id;
    }

    public void setDriver_id(int driver_id){
        this.driver_id = driver_id;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "ReportDTO{" +
                "id=" + id +
                ", license_plate='" + license_plate + '\'' +
                ", driver_id=" + driver_id +
                ", speed=" + speed +
                '}';
    }


}
