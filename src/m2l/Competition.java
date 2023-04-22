/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l;
import java.util.Date;
/**
 *
 * @author ruddy
 */
public class Competition {
    private int id;
    private String libelle;
    private String lieu;
    private Date dateCompetition;
    
    public Competition(){}
    public Competition(int id,String libelle,String lieu,Date dateCompetition){
        this.id = id;
        this.libelle = libelle;
        this.lieu = lieu;
        this.dateCompetition = dateCompetition;
    }
    public int getid(){
        return this.id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public String getLieu(){
        return this.lieu;
    }
    public Date getDate(){
        return this.dateCompetition;
                
    }
    public void setId(int id){
        this.id = id;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public void setLieu(String lieu){
        this.lieu = lieu;
    }
    public void setDat(Date dateCompetition){
        this.dateCompetition = dateCompetition;
    }
    public String toString(){
        return ("l'id est : "+this.id+" le libellé est : "+ this.libelle +" le lieu est :"+ this.lieu +" la date est : "+ this.dateCompetition);
    }
}
