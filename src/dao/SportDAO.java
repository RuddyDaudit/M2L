/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import m2l.Sport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import m2l.LigneStatistique;
import java.sql.PreparedStatement;

/**
 * Classe d'accès aux données de la table Sport.
 * @author Mathieu
 */
public class SportDAO
{
    /**
     * Récupère un sport à partir de son identifiant.
     * @param idSport L'id du sport
     * @return le sport
     */
    public static Sport getSport(String idSport)
    {
        Sport sport = null;
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    String requete = "SELECT sport.* FROM sport "
            + " WHERE sport.id = '" + idSport + "'";
            
            ResultSet res = stmt.executeQuery(requete);	    
	    if ( res.next() ) 
            {
                String id, nom;

                id = res.getString("sport.id");
                nom = res.getString("sport.nom");

                sport = new Sport(id, nom);                                               
            }	    
	    res.close();
	    stmt.close();	    
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}        
        return sport;
    }
    
    /**
     * Récupère la liste des sports classés par nom.
     * @return la liste des sports classés par nom
     */
    public static ArrayList<Sport> getSports()
    {        
        ArrayList<Sport> liste = new ArrayList<Sport>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();
            String requete = "SELECT * FROM sport ORDER BY nom ";
	    ResultSet res = stmt.executeQuery(requete);
	    
	    while (res.next()) 
            {
                String id = res.getString("id");
                String nom = res.getString("nom");
                Sport unSport = new Sport(id, nom);                               
                liste.add(unSport);
            }	    
	    res.close();
	    stmt.close();	    
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}
	return liste;
    }
    
    /**
     * Récupère le nombre de sports.
     * @return le nombre de sports.
     */
    public static int getNbSports()
    {        
        int nb = 0;
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT count(*) as nbr FROM sport");
	    
	    if (res.next()) 
            {                
                //nb = res.getInt(1); // ok
                nb = res.getInt("nbr"); // ok                
            }
	    
	    res.close();
	    stmt.close();	    
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}
	return nb;
    }    
    
        /**
     * Récupère la liste des adhérents (classés par nom) pour un sport donné.
     * @return la liste des adhérents classés par nom.
     */
    public static ArrayList<LigneStatistique> getNbAdherentsParSport()
    {        
        ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT sport.nom ,count(*) as nbr "
                    + " FROM pratiquer,sport "
                    + " WHERE pratiquer.idSport = sport.id"
                    + " GROUP BY sport.nom");
	    
	    while (res.next()) 
            {
                String nom = res.getString("sport.nom");
                int nbr = res.getInt("nbr");
                LigneStatistique ligneStat = new LigneStatistique(nom, nbr);                                              
                liste.add(ligneStat);
            }	    
	    res.close();
	    stmt.close();	    
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}
	return liste;
    }



    // méthode qui réalise l'insertion d'un sport à partir des paramètres id et nom.
    public static boolean insererSport(String id, String nom)
    {        
        boolean succes = false;
        try
	  {	    	    
	      // requête préparée d'insertion dans la table sport
            String requete = "INSERT INTO sport VALUES (?, ?) ";
                                               
            // Objet PreparedStatement : représente une instruction SQL préparée
            PreparedStatement stmt = FC.getConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
	    
            // 1er paramètre : l'id 
            stmt.setString(1, id);
            // 2ème paramètre : le nom
            stmt.setString(2, nom);            
                        
            // exécution de la requête paramétrée (préparée)           
            stmt.executeUpdate();	    	    	    
            
	      stmt.close();
            // l'insertion s'est bien passée :            
            succes = true;
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}
        return succes;
    }
   }
