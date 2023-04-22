/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l;

import dao.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.sql.PreparedStatement;

/**
 *
 * @author Mathieu
 */
public class Program
{
    // scanner utile pour la saisi
    // déclaré comme statique afin d'être utilisé dans toutes les méthodes de la classe
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {		
        // choix de l'utilisateur
	char choix = ' ';
	while (choix != 'Q')
	{
            // affichage du menu
	    afficherMenu();
            // lettre choisie par l'utilisateur
	    choix = sc.nextLine().charAt(0);

	    switch (choix)
	    {
		case '1':
		    // affichage des sports
                    afficherSports();
		    break;

		case '2':
                    // affichage des adhérents
		    afficherAdherents();              
		    break;

		case '3':
		    // à compléter
		    afficherCompetition();
                    break;

		case '4':
		    afficherNombreSports();
		    break;

		case '5':
		    afficherNombreAdherent();
		    break;

		case '6':
		    afficherAdherentsPourSport();
		    break;
                case '7':
                    afficherRechercheAdherent();
                    break;
                case '8':
                    afficherCompetitionAnnee();    
                    break;
                case'9' :   
                    afficherGroupeAherent();
                    break;
		case 'Q':
		    System.out.println("au revoir");
		    break;

		default:
		    System.out.println("mauvais choix");
		    break;
	    }
        }        
    }
    
    /**
     * Affichage du menu.
     */
    public static void afficherMenu()
    {
	System.out.println("\n**** menu ****\n");
	System.out.println("1 - Afficher la liste des sports");
	System.out.println("2 - Afficher la liste des adhérents");
	System.out.println("3 - Afficher la liste des compétitions");
	System.out.println("4 - Afficher le nombre de sports");
	System.out.println("5 - Afficher le nombre d'adhérents");
	System.out.println("6 - Rechercher des Adherents pour un sport");
	System.out.println("7 - Rechercher un adherent");
        System.out.println("8 - Nombre de competition pour une année");
        System.out.println("9 - Nombre d'adherent par sport");
        System.out.println("Q - Quitter \n");
    }
    
    //
    // Méthodes métier
    //
    /**
     * Affichage des sports.
     */
    public static void afficherSports()
    {
        ArrayList<Sport> lesSports = SportDAO.getSports();
        for (Sport unSport : lesSports)
        {
            System.out.println(unSport);
        }
    }
        
    /**
     * Affichage des adhérents.
     */
    public static void afficherAdherents()
    {
        ArrayList<Adherent> lesAdher = AdherentDAO.getAdherents();
        for (Adherent unAdherent : lesAdher)
        {
            System.out.println(unAdherent);
        }
    }
    public static void afficherCompetition(){
        ArrayList<Competition>lesCompet = CompetitionDao.getCompetitions();
        for(Competition uneCompet : lesCompet){
            System.out.println(uneCompet);
        }
    }
    
    public static void afficherNombreSports()
    {
        int nb = SportDAO.getNbSports();
        System.out.println("Nombre de sports : " + nb);        
    }    
    
    public static void afficherNombreAdherent(){
        int na = AdherentDAO.getNBAdherent();
        System.out.println("Nombre d'adherent : " + na);
    }
    public static void afficherGroupeAherent(){
        ArrayList<LigneStatistique> ligneS = SportDAO.getNbAdherentsParSport();
            for(LigneStatistique uneLs : ligneS){
                System.out.println(uneLs.toString());
            }
    }
    public static void afficherAdherentsPourSport()
    {        
        System.out.println("Saisissez le code d'un sport \n" );
        String idSport = sc.nextLine();
        ArrayList<Adherent> lesAdher = AdherentDAO.getAdherentsPourSport(idSport);
        if (lesAdher.size() == 0)
        {
            System.out.println("Pas d'adhérent pour ce sport. \n" );
        }
        else
        {
            for (Adherent unAdherent : lesAdher)
            {
                System.out.println(unAdherent);
            }
        }
    }
    public static void  rechercherCompetition(){
        System.out.println("Quelle Competition rechercher vous : ");
        Scanner sc = new Scanner(System.in);
        String motCle = sc.nextLine();
        ArrayList<Competition> lesCo = CompetitionDao.rechercherCompetition(motCle);
        System.out.println(lesCo);
    }
    public static void afficherCompetitionAnnee(){
     System.out.println("Veuillez choisir l'anée");
     Scanner sc = new Scanner(System.in);
     int d = sc.nextInt();
     int da;
     da = CompetitionDao.CompetitionDate(d);
     System.out.println(da);
    }    
    public static void afficherRechercheAdherent(){     
        System.out.println("Saisissez un mot clé \n" );
        String mot = sc.nextLine(); 
        ArrayList<Adherent> lesAdherents = AdherentDAO.getAdherentPourMot(mot); 
        if ( lesAdherents.isEmpty() ) 
        { 
            System.out.println("Pas d'adherent pour ce mot. \n" );
        } 
        else  
            for (Adherent unAdherent : lesAdherents ) 
            { 
                System.out.println(unAdherent);  
            }
    }
    public static void afficherRechercheCompetition()
    {        
        System.out.println("Saisissez le code d'un sport \n" );
        String idSport = sc.nextLine();
        ArrayList<Competition> lesCompets = CompetitionDao.getCompetitionPourSport(idSport);
        if (lesCompets.isEmpty())
        {
            System.out.println("Pas de compétition pour ce sport. \n" );
        }
        else
        {
            for (Competition uneCompetition : lesCompets)
            {
                System.out.println(uneCompetition);
            }
        }
    }
    public static void afficherNombreAdherentParAns()
    {
        System.out.println("Saisissez une année \n" );
        String nombre = sc.nextLine(); 
        int nb = AdherentDAO.getNbAdherentParAns(nombre);
        System.out.println("Nombre d'adhérents pour l'année saisie : " + nb);        
    }    
    
    public static void getResultat()
    {
        afficherRechercheAdherent();
        System.out.println("Saisissez l'id d'un sportif\n" );
        String id = sc.nextLine(); 
        ArrayList<LigneStatistique> listeInfo = CompetitionDao.getResultat(id);
        for (LigneStatistique liste : listeInfo)
        {
                System.out.println(liste);
        }
    }
    public static void getNbCompetitionParSport()
    {
        ArrayList<LigneStatistique> listeCompet = CompetitionDao.getNbCompetParSport();
        for (LigneStatistique liste : listeCompet)
        {
                System.out.println(liste);
        }
    }
    public static void getClassementParCompetition() // D
    {
        afficherCompetition();
        System.out.println("Saisissez l'id d'une compétition\n" );
        String id = sc.nextLine(); 
        ArrayList<LigneStatistique> listeCompet = CompetitionDao.getResultatParCompetition(id);
        for (LigneStatistique liste : listeCompet)
        {
                System.out.println(liste);
        }
    }
    
    public static void getMeilleurParCompetition() // E
    {
        ArrayList<LigneStatistique> listeCompet = CompetitionDao.getMeilleurParCompetition();
        for (LigneStatistique liste : listeCompet)
        {
                System.out.println(liste);
        }
    }
    
    public static void getNombrePtsParAdherent() // F
    {
        ArrayList<LigneStatistique> listeAdherent = AdherentDAO.getListeAdherentAvecCompetition();
        for (LigneStatistique liste : listeAdherent)
        {
                System.out.println(liste);
        }
        System.out.println("Saisissez l'id d'un sportif\n" );
        String id = sc.nextLine(); 
        ArrayList<LigneStatistique> listeC = CompetitionDao.getNbTotalPtsParAdherent(id);
        for (LigneStatistique liste : listeC)
        {
            System.out.print(liste.getValeur1() + " a participé à " + liste.getValeur2() + " compétitions et a un total de " + liste.getValeur3() + " points.");
        }
    }
    
    public static void CreerSport() // G
    {
        
        System.out.println("Saisissez l'id du sport \n" );
        String id = sc.nextLine();
        System.out.println("Saisissez le nom du sport \n" );
        String nom = sc.nextLine();
        SportDAO.insererSport(id, nom);
        
        if( SportDAO.insererSport(id, nom) == true )
            System.out.println("Le sport " + nom + " a bien été créer.");
    }
    
    public static void CreerAdherent()
    {
        System.out.println("Saisissez le nom de l'adhérent \n" );
        String nom = sc.nextLine();
        System.out.println("Saisissez le prenom de l'adhérent \n" );
        String prenom = sc.nextLine();
        System.out.println("Saisissez l'adresse de l'adhérent");
        String adresse = sc.nextLine();
        System.out.println("Saisissez le numéro de téléphone de l'adhérent");
        int tel = Integer.parseInt(sc.nextLine());
        System.out.println("Saisissez le jour de naissance de l'adhérent");
        int jour = Integer.parseInt(sc.nextLine());
        System.out.println("Saisissez le mois de naissance de l'adhérent");
        int mois = Integer.parseInt(sc.nextLine());
        System.out.println("Saisissez l'année de naissance de l'adhérent");
        int annee = Integer.parseInt(sc.nextLine());
        Date dateNaissance = new Date(annee-1900,mois,jour);
        System.out.println("Saisissez le departement de l'adhérent");
        String departement = sc.nextLine();
        
        afficherSports();
        System.out.println("Saisissez l'id d'un sport pratiqué");
        String id = sc.nextLine();
        int actif = 1;
        
        
       AdherentDAO.insererAdherent(nom, prenom, adresse, tel, dateNaissance, Integer.parseInt(departement));
       AdherentDAO.insererPratique(id, actif);
        
    }
    
}
