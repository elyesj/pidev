/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;


import java.sql.Date;


/**
 *
 * @author MBM info
 */
public class reclamation {
  public int id_reclamation;
public int produitp;
public int id_user;
public Date date;
public String description;

    public reclamation() {
    }

    public reclamation(int id_reclamation, int produitp, int id_user, Date date, String description) {
        this.id_reclamation = id_reclamation;
        this.produitp = produitp;
        this.id_user = id_user;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", produitp=" + produitp + ", id_user=" + id_user + ", date=" + date + ", description=" + description + '}';
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getProduitp() {
        return produitp;
    }

    public void setProduitp(int produitp) {
        this.produitp = produitp;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
