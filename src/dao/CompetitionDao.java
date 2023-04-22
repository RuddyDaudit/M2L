/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import m2l.Competition;
import m2l.LigneStatistique;

/**
 *
 * @author ruddy
 */
public class CompetitionDao {
    public static ArrayList<Competition> getCompetitions(){
        ArrayList<Competition> liste = new ArrayList<Competition>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT * FROM competition ORDER BY libelle ");
	    
	    while (res.next()) 
            {
                int id = res.getInt("id");
                String libelle = res.getString("libelle");
                String lieu= res.getString("lieu");
                Date dateCompetition = res.getDate("dateCompetition");
                Competition uneCompetition = new Competition(id, libelle, lieu,dateCompetition);                               
                liste.add(uneCompetition);
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
   public static ArrayList<Competition> rechercherCompetition (String idSport)
    {   
        ArrayList<Competition> liste = new ArrayList<Competition>();
        
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    String sql = "SELECT competition.*, concerner.idSport " 
                + " FROM competition "                     
                + " INNER JOIN concerner ON competition.id = concerner.idCompetition"
                + " WHERE concerner.idSport = '"+idSport+"'"                     
                + " ORDER BY competition.libelle";
            System.out.println(sql);
            ResultSet res = stmt.executeQuery(sql);
	    
	    while (res.next()) 
            {
                int id = res.getInt("competition.id");
                String libelle = res.getString("competition.libelle");
                String lieu = res.getString("competition.lieu");
                Date dateCompetition = res.getDate("competition.dateCompetition");
                Competition uneCompetition = new Competition(id,libelle,lieu,dateCompetition);                               
                liste.add(uneCompetition);
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
   public static int CompetitionDate(int date){
       int nb = 0;
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT count(*) as co FROM competition where dateCompetition LIKE '"+date+"-%'");
	    
	    if (res.next()) 
            {                
                //nb = res.getInt(1); // ok
                nb = res.getInt("co"); // ok                
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
   public static ArrayList<Competition> getCompetitionPourSport(String idSport)
    {        
        ArrayList<Competition> liste = new ArrayList<Competition>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT competition.* FROM competition, sport, concerner "
                    + " WHERE competition.id = concerner.idCompetition"
                    + " AND concerner.idSport = sport.id"
                    + " AND sport.id = '" + idSport + "'");

	    while (res.next()) 
            {
                int id = res.getInt("competition.id");
                String libelle = res.getString("competition.libelle");
                String lieu = res.getString("competition.lieu");
                Date dateCompet = res.getDate("competition.dateCompetition");
                Competition uneCompetition = new Competition(id, libelle, lieu, dateCompet);                               
                liste.add(uneCompetition);
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
   public static ArrayList<LigneStatistique> getResultat(String idSport){
      ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT competition.libelle,participer.classement,participer.points FROM competition INNER JOIN participer ON competition.id=participer.idCompetition"
                    + " WHERE participer.idAdherent '" + idSport + "'");

	    while (res.next()) 
            {
                String libelle = res.getString("competition.libelle");
                int pos = res.getInt("participer.classement");
                int pts = res.getInt("participer.points");
                LigneStatistique uneCompetition = new LigneStatistique(libelle,pos,pts);                               
                liste.add(uneCompetition);
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
   public static ArrayList<LigneStatistique> getNbCompetParSport(){
        ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT sport.nom ,COUNT(participer.idSport)as NB FROM sport INNER JOIN participer ON sport.id = participer.idSport GROUP BY participer.idSport ");
	    
	    while (res.next()) 
            {
                String name = res.getString("sport.nom");
                String idSp = res.getString("participer.idSport");
                LigneStatistique uneCompetition = new LigneStatistique(name,idSp);                               
                liste.add(uneCompetition);
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
    public static ArrayList<LigneStatistique> getResultatParCompetition(String id){
        ArrayList<LigneStatistique> liste = new ArrayList<LigneStatistique>();
        try
	{	    	    
	    Statement stmt = FC.getConnexion().createStatement();	    
	    ResultSet res = stmt.executeQuery("SELECT adherent.nom,adherent.prenom,participer.classement,participer.points FROM adherent INNER JOIN participer ON adherent.id = participer.idAdherent WHERE participer.idCompetition = '"+ id +"'  ORDER BY participer.classement ");
	    
	    while (res.next()) 
            {
                String name = res.getString("adherent.nom");
                int clas = res.getInt("participer.classement");
                int pts = res.getInt("participer.points");
                LigneStatistique uneCompetition = new LigneStatistique(name,clas,pts);                               
                liste.add(uneCompetition);
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
   }
   
