/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fournisseur de connexion à la base de données.
 * @author Mathieu
 */
public class FC
{
    private static final String URL = "jdbc:mysql://localhost:3306/m2l";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    
    // objet de connexion à la base de données    
    private static Connection connexion = null;
        
    /**
     * Etablit et retourne la connexion à la base de données.
     * @return
     * @throws SQLException exception SQL levée en cas de problème de connexion à la base
     */
    public static Connection getConnexion() throws SQLException
    {
        if (connexion != null)
        {
            return connexion;
        }
        else
        {
            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);            
            return connexion;                        
        }
    } 
    
    public FC()
    {        
    }
}
