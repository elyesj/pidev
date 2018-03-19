/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author MBM info
 */
public class boutique {
   public int id;
 public String adresse;
 public String numtel;
 public String nombout;
 public String image;
 public int userid;

    public boutique() {
    }

    public boutique(int id, String adresse, String numtel, String nombout, String image, int userid) {
        this.id = id;
        this.adresse = adresse;
        this.numtel = numtel;
        this.nombout = nombout;
        this.image = image;
        this.userid = userid;
    }
     public boutique(String adresse, String numtel, String nombout, String image) {
      
        this.adresse = adresse;
        this.numtel = numtel;
        this.nombout = nombout;
        this.image = image;
       
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getNombout() {
        return nombout;
    }

    public void setNombout(String nombout) {
        this.nombout = nombout;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

       public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "boutique{" + "id=" + id + ", adresse=" + adresse + ", numtel=" + numtel + ", nombout=" + nombout + ", image=" + image + ", user_id=" + userid + '}';
    }
  
}
