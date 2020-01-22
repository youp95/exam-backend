/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Member;
import entities.Rental;
import java.util.List;


/**
 *
 * @author Younes
 */
public class MemberDTO {
    
    private int id;
    
    private String name;
    private String signupDate;
    private int account;
    private List<RentalDTO> rentals;

    public MemberDTO(Member m) {
        this.name = m.getName();
        this.signupDate = m.getSignupDate();
        this.account = m.getAccount();
        for(Rental r : m.getRentals()){
            rentals.add(new RentalDTO(r));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public List<RentalDTO> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalDTO> rentals) {
        this.rentals = rentals;
    }
    
    
    
    
    
}
