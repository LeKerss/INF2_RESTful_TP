/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RESTful;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kersa
 */
@XmlRootElement
public class ListeEtudiant {
    private Map<Integer, Etudiant> maListe;
    private int count;
    
    public ListeEtudiant() {
        maListe = new HashMap<Integer, Etudiant>();
        count = 0;
        
    }
    /**
     * Ajouter un etudiant dans la liste s'il n'est pas déjà dedans
     * @param e etudiant a ajouter
     * @return nouvel id de l'etudiant, -1 sinon
     */
    public int ajouterEtudiantDansListe(Etudiant e){
        return (maListe.putIfAbsent(count, e) != null) ? count++ : -1 ;
    }
    
    /**
     * Supprimer un etudiant de la liste
     * @param id l'id de l'etudiant a supprimer
     * @return true s'il a été supprimé, false s'il n'existait pas
     */
    public boolean supprimerEtudiant(int id) {
        return (maListe.remove(id) != null);
    }
    
    /**
     * Retourne l'etudiant correspondant à l'id passé en paramètre
     * @param id l'id de l'étudiant souhaité
     * @return l'etudiant souhaité
     */
    public Etudiant consulterEtudiant(int id) {
        return maListe.get(id);
    }
    
    /**
     * Permet de récupérer une liste des etudiants
     * @return tableau d'étudiants
     */
    public Etudiant[] consulterListeEtudiant() {
        return (Etudiant[])maListe.values().toArray();
    }
    
    /**
     * Permet de modifier un étudiant déjà dans la base à partir de son ID
     * @param id id de l'étudiant qu'on souhaite modifier
     * @param e nouvel étudiant
     * @return l'ancien étudiant si l'id est trouvé, null sinon.
     */
    public Etudiant modifierEtudiant(int id, Etudiant e) {
        return maListe.replace(id, e);
    }
    
    
}
