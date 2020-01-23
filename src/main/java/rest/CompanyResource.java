/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Bike;
import entities.Member;
import entities.Rental;
import errorhandling.NotFoundException;
import facades.CompanyFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Younes
 */
@Path("company")
public class CompanyResource {
    
     private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
     private static final CompanyFacade FACADE = CompanyFacade.getCompanyFacade(EMF);
     private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;
    
    @Context
    SecurityContext securitycontext;
    
    

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"status\":\"ok\"}";
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addbike")
    public String addBike(String jsonString) {
        Bike bike = GSON.fromJson(jsonString, Bike.class);
        return GSON.toJson(FACADE.addBike(bike));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addrental")
    public String addRental(String jsonString) {
        Rental rental = GSON.fromJson(jsonString, Rental.class);
        return GSON.toJson(FACADE.addRental(rental));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addmember")
    public String addMember(String jsonString) {
        Member member = GSON.fromJson(jsonString, Member.class);
        return GSON.toJson(FACADE.addMember(member));
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletebike/{id}")
    public String deleteBike(@PathParam("id") Long id) throws NotFoundException {
        return GSON.toJson(FACADE.deleteBike(id));
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleterental/{id}")
    public String deleteRental(@PathParam("id") Long id) throws NotFoundException {
        return GSON.toJson(FACADE.deleteRental(id));
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletemember/{id}")
    public String deleteMember(@PathParam("id") Long id) throws NotFoundException {
        return GSON.toJson(FACADE.deleteMember(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allbikes")
    public String getAllBikes() {
        return GSON.toJson(FACADE.getAllBikes());
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allrentals")
    public String getAllRentals() {
        return GSON.toJson(FACADE.getAllRentals());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbyaddress/{address}")
    public String getBikesByAddress(@PathParam("address") String address) {
        return GSON.toJson(FACADE.getBikesByAddress(address));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbydate/{date}")
    public String getBikesByDate(@PathParam("date") String date) {
        return GSON.toJson(FACADE.getBikesByDate(date));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbike/{bike}")
    public String getBikeDetails(@PathParam("id") int id) {
        return GSON.toJson(FACADE.getBikeDetails(id));
    }
    
    
}
