/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RESTful;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kersa
 */
@XmlRootElement(name = "etudiant")
public class Etudiant {
    
    @XmlElement
    public String firstName;
    
    @XmlElement
    public String lastName;

    public Etudiant (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * @return the firstName
     */
    public String getNom() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setNom(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getPrefirstName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setPrefirstName(String lastName) {
        this.lastName = lastName;
    }
    
}
