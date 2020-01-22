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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.WebApplicationException;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CompanyFacade implements ICompanyFacade{

    private static CompanyFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CompanyFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CompanyFacade getCompanyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CompanyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public BikeDTO addBike(Bike b) {
    EntityManager em = getEntityManager();
        try {
            Bike bike = new Bike(b.getId(), b.getMake(), b.getGender(), b.getGears(), b.getDayPrice());
            em.getTransaction().begin();
            em.persist(bike);
            em.getTransaction().commit();
            return new BikeDTO(bike);
        } finally {
            em.close();
        }
    }

    @Override
    public RentalDTO addRental(Rental r) {
        EntityManager em = getEntityManager();
        try {
            Rental rental = new Rental(r.getId(), r.getDate());
            em.getTransaction().begin();
            em.persist(rental);
            em.getTransaction().commit();
            return new RentalDTO(rental);
        } finally {
            em.close();
        }
    }

    @Override
    public MemberDTO addMember(Member m) {
         EntityManager em = getEntityManager();
        try {
            if(m.getName() != null){
                throw new WebApplicationException("Member already signed up", 302);
            }
            Member member = new Member(m.getId(), m.getName(), m.getSignupDate(), m.getAccount());
            em.getTransaction().begin();
            em.persist(member);
            em.getTransaction().commit();
            return new MemberDTO(member);
        } finally {
            em.close();
        }
    }

    
    @Override
    public StorageDTO addStorage(Storage s) {
       EntityManager em = getEntityManager();
        try {
            Storage storage = new Storage(s.getId(), s.getAddress(), s.getCapacity());
            em.getTransaction().begin();
            em.persist(storage);
            em.getTransaction().commit();
            return new StorageDTO(storage);
        } finally {
            em.close();
        }
    }

    @Override
    public BikeDTO editBike(Bike b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RentalDTO editRental(Rental r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BikeDTO deleteBike(long id) throws NotFoundException {
    EntityManager em = emf.createEntityManager();
        try{
            Bike b = em.find(Bike.class, id);
            if(b == null) throw new NotFoundException("Bike with id " + id + " doesnt exist.");
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            return new BikeDTO(b);
        }finally{
            em.close();
        }
    }

    @Override
    public RentalDTO deleteRental(long id) throws NotFoundException {
         EntityManager em = emf.createEntityManager();
        try{
            Rental r = em.find(Rental.class, id);
            if(r == null) throw new NotFoundException("Rental with id " + id + " doesnt exist.");
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            return new RentalDTO(r);
        }finally{
            em.close();
        }
    }

    @Override
    public MemberDTO deleteMember(long id) throws NotFoundException {
         EntityManager em = emf.createEntityManager();
        try{
            Member m = em.find(Member.class, id);
            if(m == null) throw new NotFoundException("Member with id " + id + " doesnt exist.");
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
            return new MemberDTO(m);
        }finally{
            em.close();
        }
    }

    @Override
    public List<BikeDTO> getAllBikes() {
            EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT new entities.dto.BikeDTO(bike) FROM Bike bike", BikeDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<RentalDTO> getAllRentals() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT new entities.dto.RentalDTO(rental) FROM Rental rental", RentalDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<BikeDTO> getBikesByLocation(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BikeDTO> getBikesByDay(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BikeDTO getBikeDetails(Bike b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RentalDTO chooseRental(Rental r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void payRental() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortBikes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
