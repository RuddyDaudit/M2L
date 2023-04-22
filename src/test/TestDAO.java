/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.*;
import java.util.Scanner;
import java.util.ArrayList;
import m2l.*;

/**
 *
 * @author ruddy
 */
public class TestDAO {
    public static void main(String[]args){
        ArrayList<Competition> competitions = CompetitionDao.getCompetitions();
        System.out.println(competitions.toString());
        System.out.println("Quelle Competition rechcecher vous : ");
        Scanner sc = new Scanner(System.in);
        String motCle = sc.nextLine();
        ArrayList<Competition> co = CompetitionDao.rechercherCompetition(motCle);
        System.out.println(co.toString());
    }
}
