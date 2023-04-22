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
public class ParticipationCompetition extends Competition{
    private int point;
    private int classement;
    public ParticipationCompetition(int id,String libelle,String lieu,Date dateCompetition,int point,int classement){
        super(id,libelle,lieu,dateCompetition);
        this.point = point;
        this.classement = classement;
    }
}
