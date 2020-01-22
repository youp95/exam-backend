/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Member;
import entities.Rental;

/**
 *
 * @author Younes
 */
public class RentalDTO {
    
    private int id;
    private String date;
    private MemberDTO memberDTO;
    private BikeDTO bikeDTO;

    public RentalDTO(Rental r) {
        this.id = r.getId();
        this.date = r.getDate();
        this.memberDTO = new MemberDTO(r.getMember());
        this.bikeDTO = new BikeDTO(r.getBike());
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public BikeDTO getBikeDTO() {
        return bikeDTO;
    }

    public void setBikeDTO(BikeDTO bikeDTO) {
        this.bikeDTO = bikeDTO;
    }
    
    
    
    
}
