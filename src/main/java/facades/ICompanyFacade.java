/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.BikeDTO;
import DTO.MemberDTO;
import DTO.RentalDTO;
import DTO.StorageDTO;
import entities.Bike;
import entities.Member;
import entities.Rental;
import entities.Storage;
import errorhandling.NotFoundException;
import java.util.List;

/**
 *
 * @author Younes
 */
public interface ICompanyFacade {
    
    
    
   
   public BikeDTO addBike(Bike b);
   public RentalDTO addRental(Rental r);
   public MemberDTO addMember(Member m);
   public StorageDTO addStorage(Storage s);
   public BikeDTO editBike(Bike b);
   public RentalDTO editRental(Rental r);
   public BikeDTO deleteBike(long id) throws NotFoundException;
   public RentalDTO deleteRental(long id)throws NotFoundException;
   public MemberDTO deleteMember(long id)throws NotFoundException;
   public List<BikeDTO> getAllBikes();
   public List<RentalDTO> getAllRentals();
   public List<BikeDTO> getBikesByAddress(String address);
   public List<BikeDTO> getBikesByDay(String date);
   public BikeDTO getBikeDetails(int id);
   public RentalDTO chooseRental(Rental r);
   public void payRental();
   public void sortBikes();
   
  
   
   
   
    
}
