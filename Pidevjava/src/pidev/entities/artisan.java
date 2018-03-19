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
public class artisan {
     public int id;
 public String adresse;
 public String numtel;
 public String nomart;
 public String image;
 public int user_id;

    public artisan() {
    }

    public artisan(int id, String adresse, String numtel, String nomart, String image, int user_id) {
        this.id = id;
        this.adresse = adresse;
        this.numtel = numtel;
        this.nomart = nomart;
        this.image = image;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "artisan{" + "id=" + id + ", adresse=" + adresse + ", numtel=" + numtel + ", nomart=" + nomart + ", image=" + image + ", user_id=" + user_id + '}';
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

    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
