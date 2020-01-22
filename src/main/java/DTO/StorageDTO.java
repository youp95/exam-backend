/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Storage;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author Younes
 */
public class StorageDTO {
    
    private int id;
    private String address;
    private int capacity;
    private List<BikeDTO> bikeDTO;

    public StorageDTO(Storage s) {
        this.id = s.getId();
        this.address = s.getAddress();
        this.capacity = s.getCapacity();
        
        for (Bike b : s.getBikes()){
            bikeDTO.add(new BikeDTO(b));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<BikeDTO> getBikeDTO() {
        return bikeDTO;
    }

    public void setBikeDTO(List<BikeDTO> bikeDTO) {
        this.bikeDTO = bikeDTO;
    }
    
    

    
    
    
}
