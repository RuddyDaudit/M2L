/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l;

/**
 *
 * @author Mathieu
 */
public class Sport
{
    private String id;
    private String nom;
    
    public Sport()
    {
        
    }
    
    public Sport(String id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public String toString()
    {
        return id + " - " + nom;
    }
}
