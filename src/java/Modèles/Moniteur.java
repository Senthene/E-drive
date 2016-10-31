/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèles;

import java.util.ArrayList;

/**
 *
 * @author Sénthène
 */
public class Moniteur extends Utilisateur {
    
    private int experience;
    private Voiture voiture;
    private ArrayList <Offre> offres;

    public Moniteur(String n, String p, int tel, String m, String a, String d, int c, String mdp, String dateNaissance, String dateInscription, int e, Voiture v, ArrayList <Offre> o) {
        super(m, mdp, n, p, dateNaissance, tel, a, c, d, dateInscription);
        experience = e;
        voiture = v;
        offres = o;
    }
    
    public void ajoutOffre(Offre o){
        offres.add(o);
    }
       
}
    

