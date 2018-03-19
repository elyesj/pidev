/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pidev.entities.Abonnement;
import pidev.entities.artisan;
import pidev.entities.boutique;
import pidev.utils.myconnexionpi;

/**
 *
 * @author MBM info
 */
public class myservicespi {
    Connection cn= myconnexionpi.getInstance().getConnection();
    
    
    public void ajouterBoutique(boutique b) {

        try {
            String insert = "INSERT INTO boutique (adresse,numtel,nom_bout,image)VALUES (?,?,?,?);";
            PreparedStatement st1 = cn.prepareStatement(insert);
             st1.setString(1,b.getAdresse());
             st1.setString(2,b.getNumtel());
             st1.setString(3,b.getNombout());
             st1.setString(4,b.getImage());

            st1.executeUpdate();
            System.out.println("boutique " + b.getNombout() + " ajoutée !!!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public void ajouterNote(boutique b) {

        try { // LES var declaré dans le try ne sont vue que dans le try, et inversement pour en dhors du try
            String requete = "INSERT INTO boutique(adresse,nom_bout,numtel,image) VALUES('" + b.getAdresse() + "','" + b.getNombout()+ "','" + b.getNumtel() + "','" + b.getImage() + "')"; //MAJUSCULE NON OBLIGATOIRE 
            Statement st = cn.createStatement(); // import java.sql.Statement
            st.executeUpdate(requete);
            System.out.println("note ajoutée");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
    
     
/*     public void ajouterboutique2 (boutique b){
         
         try {
             String requete="insert into Personne (adresse,numtel,nombout,image,user_id) values (?,?,?,?,?)";
             PreparedStatement st =cn.prepareStatement(requete);
         
             st.setString(1,b.getAdresse());
             st.setString(2,b.getNumtel());
             st.setString(3,b.getNombout());
             st.setString(4,b.getImage());
             
            
             st.executeUpdate(requete);
             System.out.println("boutique ajoutée");
         } catch (SQLException ex) {
System.err.print(ex.getMessage());         }
    }*/
     public List<boutique>listerboutiques(){
       List<boutique>mylist=new ArrayList<boutique>();
         try {
         
           String requete2="select * from boutique";
           Statement st2=cn.createStatement();
           
           ResultSet rs =st2.executeQuery(requete2);
           while(rs.next()){
               boutique b=new boutique();
               b.setId(rs.getInt(1));
               b.setNombout(rs.getString(2));
               b.setAdresse(rs.getString("Adresse"));
               b.setNumtel (rs.getString(3));
            
             b.setImage(rs.getString(4));
               mylist.add(b);
           }}
       
        catch (SQLException ex) {
           Logger.getLogger(myservicespi.class.getName()).log(Level.SEVERE, null, ex);
                  }
         return mylist;}
      
    public void supprimerBoutique(int id) {
            String delete = "DELETE FROM `souklemdina`.`boutique` WHERE id= ?" ;

        try {
      
            PreparedStatement st2 = cn.prepareStatement(delete);
            st2.setInt(1, id);
            st2.executeUpdate();
       System.out.print("boutique supprimé");

        } catch (SQLException e) {

            System.err.println("SQLException: " + e.getMessage());
        }

    }
    
  public void ModifierBoutique(boutique b,int id) {

        try {
            String update = "UPDATE boutique  SET nom_bout = ?, numtel = ? , adresse = ?, image = ? WHERE id = ? ;";

            PreparedStatement statement2 = cn.prepareStatement(update);
            statement2.setString(1, b.getNombout());
            statement2.setString(2, b.getNumtel());
            statement2.setString(3, b.getAdresse());
            statement2.setString(4, b.getImage());
            statement2.setInt(5, id);
           

            statement2.executeUpdate();
            System.err.println("boutique modifier");
        } catch (SQLException e) {
            System.err.println("boutique " + b.getId() + " non modifiee");
            System.out.println(e.getMessage());
        }

    }  
  
    public List<boutique> rechercherBoutique(String nombout) {

        List<boutique> ls = new ArrayList<boutique>();
        boutique b = new boutique();
        try {
            String select = "SELECT * FROM boutique WHERE nom_bout = '" + nombout + "' ";
            Statement statement1 = cn.createStatement();
            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                b.setId(result.getInt("id"));
                b.setNombout(result.getString("nombout"));
                b.setAdresse(result.getString("adresse"));
                b.setNumtel(result.getString("numtel"));
                b.setImage(result.getString("image"));
               
                ls.add(b);

            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }
        return ls;

    }
    
    
    
    
    
    
    public void ajouterArtisan(artisan a) {

        try {
            String insert = "INSERT INTO artisan (adresse,numtel,nomart,image)VALUES (?,?,?,?);";
            PreparedStatement st1 = cn.prepareStatement(insert);
             st1.setString(1,a.getAdresse());
             st1.setString(2,a.getNumtel());
             st1.setString(3,a.getNomart());
             st1.setString(4,a.getImage());

            st1.executeUpdate();
            System.out.println("artisan " + a.getNomart() + " ajoutée !!!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
    
    
     
     
     public List<artisan>listerartisans(){
       List<artisan>list=new ArrayList<artisan>();
         try {
         
           String requete2="select * from artisan";
           Statement st2=cn.createStatement();
           
           ResultSet rs =st2.executeQuery(requete2);
           while(rs.next()){
               artisan a=new artisan();
               a.setId(rs.getInt(1));
               a.setNomart(rs.getString(2));
               a.setAdresse(rs.getString("Adresse"));
               a.setNumtel (rs.getString(3));
            
             a.setImage(rs.getString(4));
               list.add(a);
           }}
       
        catch (SQLException ex) {
           Logger.getLogger(myservicespi.class.getName()).log(Level.SEVERE, null, ex);
                  }
         return list;}
      
    public void supprimerartisan(int id) {
  String delete = "DELETE FROM `souklemdina`.`artisan` WHERE id= ?" ;
        try {
          
           
            PreparedStatement st2 = cn.prepareStatement(delete);
             st2.setInt(1, id);
             st2.executeUpdate();
            
          System.out.print("artisan supprimé");

        } catch (SQLException e) {

            System.err.println("SQLException: " + e.getMessage());
        }

    }
    
    
    
    
    
    
  public void Modifierartisan(artisan a,int id) {

        try {
            String update = "UPDATE artisan  SET nomart = ?, numtel = ? , adresse = ?, image = ? WHERE id = ? ;";

            PreparedStatement statement2 = cn.prepareStatement(update);
            statement2.setString(1, a.getNomart());
            statement2.setString(2, a.getNumtel());
            statement2.setString(3, a.getAdresse());
            statement2.setString(4, a.getImage());
             statement2.setInt(5, id);
           

            statement2.executeUpdate();
             System.err.println("artisan modifier");

        } catch (SQLException e) {
            System.err.println("artisan" + a.getId() + " non modifiee");
            System.out.println(e.getMessage());
        }

    }  
  
    public List<artisan> rechercherartisan(String nomart) {

        List<artisan> ls = new ArrayList<artisan>();
       artisan a = new artisan();
        try {
            String select = "SELECT * FROM artisan WHERE nomart = '" + nomart + "' ";
            Statement statement1 = cn.createStatement();
            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                a.setId(result.getInt("id"));
                a.setNomart(result.getString("nomart"));
                a.setAdresse(result.getString("adresse"));
                a.setNumtel(result.getString("numtel"));
                a.setImage(result.getString("image"));
               
                ls.add(a);

            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }
        return ls;

    }
    
    public void ajouterAbonnement(Abonnement ab)
    {
        String req="INSERT INTO `Abonnement`(`id`,`id_user`, `id_boutique`) VALUES (?,?,?)";
        
        try{
          
        
        
        PreparedStatement statemnt =cn.prepareStatement(req);
       statemnt.setInt(1,ab.getId());
        statemnt.setInt(2,ab.getId_user());
        statemnt.setInt(3,ab.getId_boutique() );
        
      
        statemnt.executeUpdate();
            System.out.println("abonnement ajouté");
        }catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }
    }
    public void supprimerAbonnement(int id_user , int id_boutique)
    {
        String req="DELETE FROM `Abonnement` WHERE id_user=? and id_boutique=?";
        try{
        PreparedStatement statement=cn.prepareStatement(req);

        statement.setInt(1, id_user);
          statement.setInt(2, id_boutique);
          
        statement.executeUpdate();
         System.out.println("abonnement supprimé");
        }catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLSTATE: " + e.getSQLState());
            System.err.println("VnedorError: " + e.getErrorCode());
        }
}
    
    
     public List<Abonnement> GetAbonnementsByuserId(int id) throws SQLException {

        List<Abonnement> listAbonnement = new ArrayList<Abonnement>();
        Abonnement abonnement = new Abonnement();
         
   
       
      
            String req = "SELECT * FROM Abonnement WHERE id_user=?";
             PreparedStatement pst=cn.prepareStatement(req);
        
            pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Abonnement abonnement1 = new Abonnement();
            abonnement1.setId_user(rs.getInt("iduser"));
            abonnement1.setId_boutique(rs.getInt("idboutique"));
                   listAbonnement.add(abonnement1); }
        
        return listAbonnement;

    }
    
     public List<Abonnement> GetAbonnementsByMembreId(int id) throws SQLException {

        List<Abonnement> listAbonnement = new ArrayList<Abonnement>();
        Abonnement abonnement = new Abonnement(id, id);
        
            String req = "SELECT * FROM Abonnement WHERE id_user=?";
            PreparedStatement pst=cn.prepareStatement(req);
            pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Abonnement abonnement1 = new Abonnement();
            abonnement1.setId_user(rs.getInt("iduser"));
            abonnement1.setId_boutique(rs.getInt("idboutique"));
                   listAbonnement.add(abonnement1); }
        
        return listAbonnement;

    }
     
      public boolean isAbonne(int id_user,int id_boutique) throws SQLException {
            String req="SELECT * FROM Abonnement WHERE id_user=? and id_boutique=?";
   
        PreparedStatement pst=cn.prepareStatement(req);
      
          
            pst.setInt(1, id_user);
            pst.setInt(2, id_boutique);
        ResultSet rs = pst.executeQuery();
           
            
            
        while (rs.next()) {
            return true;
        }

        return false;

    }
    
}