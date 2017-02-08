package TP_RESTful;

import java.io.ByteArrayOutputStream;
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
import javax.xml.bind.JAXB;

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
    public String getEtudiant() {
        System.out.println("getEtudiant() procedure call at " + new Date());        
        if (listeEtudiant == null){
            listeEtudiant = new ListeEtudiant();
        }
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("john", "doe"));
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("Oui", "Oui"));
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("abcf", "dsze"));
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("dsrg", "dgre"));
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("cinq", "six"));
        listeEtudiant.ajouterEtudiantDansListe(new Etudiant ("haha", "huihu"));
        String aString = "";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        try{

            for(Etudiant e : listeEtudiant.consulterListeEtudiant())
            {
                JAXB.marshal(e, os);
                System.out.println(e.getFirstName());
            }

            aString = new String(os.toByteArray(),"UTF-8");

            //Ici dans aString la première balise de déclaration du fichier XML.
            //Il s'agit de retirer toutes les occurences de cette première balise sauf la première.
            int pos = aString.indexOf('>') +2;
            String sDcl = aString.subSequence(0, pos).toString();
            String sXml = aString.subSequence(0, aString.length()-1).toString();
            aString = sDcl + "<listeEtudiants>\n" + sXml.replace(sDcl, "") + "\n</listeEtudiants>";

        }catch (Exception e) {
            e.printStackTrace();
        }

        return aString;
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
    public String postEtudiant(Etudiant etudiant) {
        System.out.println("postEtudiant() procedure call at " + new Date());
        if (listeEtudiant == null){
            listeEtudiant = new ListeEtudiant();
        }
        return "<id>" + listeEtudiant.ajouterEtudiantDansListe(etudiant) + "</id>";
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public String deleteEtudiant(@PathParam("id") int id) {
        System.out.println("deleteEtudiant() procedure call at " + new Date());
        if (listeEtudiant == null){
            return "<deleted>" + false + "</deleted>";
        }
        return "<deleted>" + listeEtudiant.supprimerEtudiant(id) + "</deleted>";
    }
    
}