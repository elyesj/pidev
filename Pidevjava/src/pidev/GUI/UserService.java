/**
* @Project: AllForKids
* @Classe: UserServce
* @Date: 14 mars 2018
* @Time: 00:02:42
*
* @author Lauris
*/



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pidev.entities.user;
import pidev.utils.myconnexionpi;


public class UserService {
    
    String path = "";
    public static int id;
    private static int workload = 12;
    Connection cn = myconnexionpi.getInstance().getConnection();
    
    public int getId(){
        return id;
    }
    
    
    public int login(String username, String password) {
        try {
            String requete = "SELECT * FROM `fos_user` where `username`=? and enabled=1";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setString(1, username);
            ResultSet res = st.executeQuery();
            
            if(res.last()){
                if(checkPassword(password, res.getString("password"))){
                    id = res.getInt("id");
                    return 1;
                }
            }
            else{
                return 0;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
        return 0;
    }
    
    
    public Boolean register(user user) throws SQLException, FileNotFoundException{

        String requete = "INSERT INTO user (username,username_canonical,email,email_canonical,enabled,password,roles,nom,prenom,date_naissance,adresse,cin,sexe) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = cn.prepareStatement(requete);

        st.setString(1, user.getUsername());
        st.setString(2, user.getUsername());
        st.setString(3, user.getEmail());
        st.setString(4, user.getEmail());
        st.setString(5, "1");
        st.setString(6, user.getPassword());
        st.setString(7, user.getRoles());
        st.setString(8, user.getNom());
        st.setString(9, user.getPrenom());
        st.setString(10, String.valueOf(user.getDateNaissance()));
        st.setString(11, user.getAdresse());
                st.setString(12, user.getCin());
                        st.setString(13, user.getSexe());


        
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        st.setBinaryStream(12, fis, (int)file.length());
        

        return st.executeUpdate() == 1;
            
    }
    
    
    public void updateUser(user user) throws SQLException, FileNotFoundException{

        String requete = "UPDATE fos_user SET nom=?, prenom=?, date_naissance=?, adresse=?, image=? WHERE id=?";
        PreparedStatement st = cn.prepareStatement(requete);
        
        st.setString(1, user.getNom());
        st.setString(2, user.getPrenom());
        st.setString(3, String.valueOf(user.getDateNaissance()));
        st.setString(4, user.getAdresse());
        
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        st.setBinaryStream(5, fis, (int)file.length());

        st.executeUpdate();
        
        System.out.println("User modifié");
        
    }
    
    
    
    public user getUser(int id) throws SQLException {
        user user = new user();

        String requete = "select * from `fos_user` where `id`=?";
        PreparedStatement st = cn.prepareStatement(requete);
        st.setString(1, String.valueOf(id));
        ResultSet res = st.executeQuery();

        while(res.next()){
            System.out.println(res.getString("username"));
            user.setId(res.getInt("id"));
            user.setUsername(res.getString("username"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setRoles(res.getString("roles"));
            user.setEmail(res.getString("email"));
            user.setAdresse(res.getString("adresse"));
            user.setDateNaissance(res.getDate("date_naissance").toLocalDate());
           
        }

        return user;
    }
    
    
    
    public int verifierUsername(String username) throws SQLException {
        String requete = "SELECT * FROM `fos_user` where `username`=?";
        PreparedStatement st = cn.prepareStatement(requete);
        st.setString(1, username);
        ResultSet res = st.executeQuery();
        
        if(res.last()){
            return 1;
        }
        else{ //no user with this username
            return 0;
        }
    }

    public int verifierEmail(String mail) throws SQLException {
        String requete = "SELECT * FROM `fos_user` where `email`=?";
        PreparedStatement st = cn.prepareStatement(requete);
        st.setString(1, mail);
        ResultSet res = st.executeQuery();
        
        if(res.last()){
            return 1;
        }
        else{ //no user with this username
            return 0;
        }
    }

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        System.out.println(salt);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2y$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

}




/**
*@Lau82 © 2018
*/
