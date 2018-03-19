/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MBM info
 */
public class myconnexionpi {
    public  Connection cnx;

    static myconnexionpi instance;

    private myconnexionpi() {
        try {
            String url = "jdbc:mysql://localhost:3306/souklemdinafinal";
            String login = "root";
            String pwd = "";
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());

        }
    }
    
 public Connection getConnection() {
        return cnx;
    }

   
    public static myconnexionpi getInstance() {
        if (instance == null) {

            instance = new myconnexionpi();
        }
        return instance;
    }
}
