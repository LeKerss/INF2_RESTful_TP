package TP_RESTful;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kersa
 */
@Path("etudiants")
public class RestEtudiant {

    @Context
    private UriInfo context;
    private ListeEtudiant listeEtudiant;
    
    /**
     * Retrieves representation of an instance of TP_RESTful.RestEtudiants
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public Etudiant getEtudiant(@PathParam("id") int id) {
        System.out.println("getEtudiant(id) procedure call at " + new Date());

        if (listeEtudiant == null){
            return null;
        }
        return listeEtudiant.consulterEtudiant(id);
    }
    
    /**
     * Retrieves representation of an instance of TP_RESTful.RestEtudiants
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Etudiant[] getEtudiant() {
        System.out.println("getEtudiant() procedure call at " + new Date());        
        if (listeEtudiant == null){
            return null;
        }
        return listeEtudiant.consulterListeEtudiant();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public Etudiant putEtudiant(@PathParam("id") int id, Etudiant etudiant) {
        System.out.println("postEtudiant() procedure call at " + new Date());
        if (listeEtudiant == null){
            return null;
        }
        return listeEtudiant.modifierEtudiant(id, etudiant);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public int postEtudiant(Etudiant etudiant) {
        System.out.println("postEtudiant() procedure call at " + new Date());
        if (listeEtudiant == null){
            listeEtudiant = new ListeEtudiant();
        }
        return listeEtudiant.ajouterEtudiantDansListe(etudiant);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public boolean deleteEtudiant(@PathParam("id") int id) {
        System.out.println("deleteEtudiant() procedure call at " + new Date());
        if (listeEtudiant == null){
            return false;
        }
        return listeEtudiant.supprimerEtudiant(id);
    }
    
}