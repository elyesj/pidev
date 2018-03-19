/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.tests;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import static org.omg.CORBA.AnySeqHelper.insert;
import pidev.entities.Abonnement;
import pidev.entities.artisan;
import pidev.entities.boutique;
import pidev.services.myservicespi;
import pidev.utils.myconnexionpi;



/**
 *
 * @author MBM info
 */
public class Mainclasspi {
    public static void main(String[] args) {
//    Etudiant e1=Etudiant.getInstance();
//    Etudiant e2=Etudiant.getInstance();
//
//    System.out.println(e1.hashCode()+"-"+e2.hashCode());
           myservicespi ms=new myservicespi();
           boutique b=new boutique();
           artisan a=new artisan();
          b.setId(100);
           b.setNombout("taraji");
           b.setAdresse("bardo");
           b.setNumtel("24504923");
           b.setImage("ohhhhh");
//
//           ms.ajouterNote(b);
          ms.ajouterBoutique(b);
//           System.out.println(ms.listerboutiques());
//              System.out.println(ms.listerartisans());
     //   ms.ModifierBoutique(b,b.getId());
//          ms.supprimerBoutique(14);
          
//            a.setId(14);
//          a.setNomart("yasss");
//           a.setAdresse("bardo");
//           a.setNumtel("65952888");
//           a.setImage("taraji");
//           ms.Modifierartisan(a,a.getId());
//           ms.ajouterArtisan(a);
//         ms.supprimerartisan(14);
//         
//        String nombout = null;
//           ms.rechercherBoutique(nombout);
//           ms.ajouterboutique2(b);


		
//Abonnement ab=new Abonnement();
//ab.setId_boutique(9);
//ab.setId_user(10);
//
//
// //ms.ajouterAbonnement(ab);
//   ms.supprimerAbonnement(10, 9);         

}
          
    }

