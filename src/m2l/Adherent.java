/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l;

import java.util.Date;

/**
 *
 * @author Mathieu
 */
public class Adherent
{
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private Date dateNaissance;
    private int departement; 

    public Adherent()
    {
        
    }
    
    public Adherent(int id, String nom, String prenom, String adresse,
            String tel, Date dateNaissance, int departement)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.departement = departement;
    }
    
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse()
    {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    /**
     * @return the tel
     */
    public String getTel()
    {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel)
    {
        this.tel = tel;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance()
    {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance)
    {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the departement
     */
    public int getDepartement()
    {
        return departement;
    }

    /**
     * @param departement the departement to set
     */
    public void setDepartement(int departement)
    {
        this.departement = departement;
    }
    
    /**
     * 
     */
    public String toString()
    {
        return id + " " + nom + " " + prenom ;
    }
}
