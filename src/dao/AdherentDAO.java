/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import m2l.Adherent;
import m2l.LigneStatistique;
import java.util.Calendar;
import java.sql.PreparedStatement;

/**
 * Classe d'accès aux données de la table Adherent.
 * @author Mathieu
 */
public class AdherentDAO
{
    /**
     * Récupère la liste des adhérents classés par nom.
     * @return la liste des adhérents classés par nom.
     */
    public static ArrayList<Adherent> getAdherents()
    {        
        ArrayList<Adherent> liste = new ArrayList<Adherent>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT * FROM adherent ORDER BY nom ");
	    
	    while (res.next()) 
            {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse = res.getString("adresse");
                String tel = res.getString("tel");
                Date dateNaissance = res.getDate("dateNaissance");
                int departement = res.getInt("departement");
                Adherent unAdherent = new Adherent(id, nom, prenom, adresse, tel, dateNaissance, departement);                               
                liste.add(unAdherent);
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
     * Récupère la liste des adhérents (classés par nom) pour un sport donné.
     * @return la liste des adhérents classés par nom.
     */
    public static ArrayList<Adherent> getAdherentsPourSport(String idSport)
    {        
        ArrayList<Adherent> liste = new ArrayList<Adherent>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT adherent.* FROM adherent, pratiquer "
                    + " WHERE pratiquer.idAdherent = adherent.id"
                    + " AND pratiquer.idSport = '" + idSport + "'"
                    + " ORDER BY nom ");
	    
	    while (res.next()) 
            {
                int id = res.getInt("adherent.id");
                String nom = res.getString("adherent.nom");
                String prenom = res.getString("adherent.prenom");
                String adresse = res.getString("adherent.adresse");
                String tel = res.getString("adherent.tel");
                Date dateNaissance = res.getDate("adherent.dateNaissance");
                int departement = res.getInt("adherent.departement");
                Adherent unAdherent = new Adherent(id, nom, prenom, adresse, tel, dateNaissance, departement);                               
                liste.add(unAdherent);
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
    /*public static ArrayList<Adherent> getCnbAdherentSport()
    {
                ArrayList<Adherent> liste = new ArrayList<Adherent>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT sport.nom ,count(pratiquer.*) as adh "
                    + " FROM pratiquer,sport "
                    + " WHERE pratiquer.idSport = sport.id"
                    + " GROUP BY sport.nom ");
	    
	    while (res.next()) 
            {
                int id = res.getInt("adherent.id");
                String nom = res.getString("adherent.nom");
                String prenom = res.getString("adherent.prenom");
                String adresse = res.getString("adherent.adresse");
                String tel = res.getString("adherent.tel");
                Date dateNaissance = res.getDate("adherent.dateNaissance");
                int departement = res.gsetInt("adherent.departement");
                Adherent unAdherent = new Adherent(id, nom, prenom, adresse, tel, dateNaissance, departement);                               
                liste.add(unAdherent);
            }	    
	    res.close();
	    stmt.close();	    
	}
	catch (Exception exc)
	{
	    exc.printStackTrace();
	}
	return liste;
    }*/
    public static int getNBAdherent()
    {        
        int nb = 0;
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT count(*) as nbi FROM adherent");
	    
	    if (res.next()) 
            {                
                //nb = res.getInt(1); // ok
                nb = res.getInt("nbi"); // ok                
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
    public static ArrayList<Adherent> getAdherentPourMot(String mot)
    {        
        ArrayList<Adherent> liste = new ArrayList<Adherent>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT * FROM adherent"
                    + " WHERE nom like '%" + mot + "%'"
                    + " order by id asc");

	    
	    while (res.next()) 
            {
                int id = res.getInt("adherent.id");
                String nom = res.getString("adherent.nom");
                String prenom = res.getString("adherent.prenom");
                String adresse = res.getString("adherent.adresse");
                String tel = res.getString("adherent.tel");
                Date dateNaissance = res.getDate("adherent.dateNaissance");
                int departement = res.getInt("adherent.departement");
                Adherent unAdherent = new Adherent(id, nom, prenom, adresse, tel, dateNaissance, departement);                               
                liste.add(unAdherent);
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
     public static int getNbAdherentParAns(String année)
    {        
        int nb = 0;
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT count(*) as nbr FROM competition"
                    + " WHERE dateCompetition like '" + année + "-%'");
	    if (res.next()) 
            {                
                nb = res.getInt("nbr");              
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
     public static ArrayList<LigneStatistique> getNbAdherentsParSport()
    {        
        ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("Select sport.nom,count(pratiquer.idAdherent) as nbr\n" +
                                                "from adherent, pratiquer, sport\n" +
                                                "where adherent.id = pratiquer.idAdherent\n" +
                                                    "and pratiquer.idSport = sport.id\n" +
                                                    "group by idSport");
	    while (res.next()) 
            {
                String nom = res.getString("nom");
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

public static ArrayList<LigneStatistique> getResultat(String id)
    {        
        ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("select points, classement, competition.libelle\n" +
                                                "from participer, competition\n" +
                                                "where participer.idCompetition = competition.id\n" +
                                                "and participer.idAdherent = " + id);
	    while (res.next()) 
            {
                String libelle = res.getString("libelle");
                int classement = res.getInt("classement");
                int points = res.getInt("points");

                LigneStatistique ligneStat = new LigneStatistique(libelle, classement, points);                               
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
        public static boolean insererAdherent(int id,String nom,String prenom,String adresse,String tel,Date dateNaissance,int departement){        
        boolean succes = false;
        try
	  {	    	    
	      // requête préparée d'insertion dans la table sport
            String requete = "INSERT INTO adherent VALUES (?, ?, ?, ?, ?, ?, ?) ";
                                               
            // Objet PreparedStatement : représente une instruction SQL préparée
            PreparedStatement stmt = FC.getConnexion().prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);

            // représente la date de naissance
              Calendar cal = Calendar.getInstance();
            // laDate est la date de naissance de type java.util.Date passée en paramètre
            // de la méthode insererAdherent
            cal.setTime(dateNaissance);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);    
            java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime()); 

	    
            // 1er paramètre : l'id 
            stmt.setString(1, null);
            // 2ème paramètre : le nom
            stmt.setString(2, nom);            
            //6eme parametre : date
            stmt.setString(3, prenom);            
            //6eme parametre : date
            stmt.setString(2, adresse);            
            //6eme parametre : date
            stmt.setString(2, tel);            
            //6eme parametre : date
            stmt.setDate(6, sqlDate);  
            
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
