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
public class Abonnement {
     public int id;
 public int id_user;
 public int id_boutique;

    public Abonnement(int id, int id0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_boutique() {
        return id_boutique;
    }

    public void setId_boutique(int id_boutique) {
        this.id_boutique = id_boutique;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", id_user=" + id_user + ", id_boutique=" + id_boutique + '}';
    }
 

    public Abonnement() {
    }

}
