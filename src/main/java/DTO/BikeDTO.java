/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Rental;
import entities.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Younes
 */
public class BikeDTO {
    
    private int id;
    private String make;
    private String size;
    private String gender;
    private int gears;
    private int dayPrice;
    private StorageDTO storageDTO;
    private List<RentalDTO> rentals = new ArrayList();

    public BikeDTO(Bike b) {
        this.make = b.getMake();
        this.size = b.getSize();
        this.gender = b.getGender();
        this.gears = b.getGears();
        this.dayPrice = b.getDayPrice();
        this.storageDTO = new StorageDTO(b.getStorage());
        for(Rental r : b.getRentals()){
            rentals.add(new RentalDTO(r));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public StorageDTO getStorageDTO() {
        return storageDTO;
    }

    public void setStorageDTO(StorageDTO storageDTO) {
        this.storageDTO = storageDTO;
    }

    public List<RentalDTO> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalDTO> rentals) {
        this.rentals = rentals;
    }
    
    
    
    
    
}
