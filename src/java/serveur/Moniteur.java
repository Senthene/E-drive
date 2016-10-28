/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.util.ArrayList;

/**
 *
 * @author Sénthène
 */
public class Moniteur extends Utilisateur {
    
    private int experience;
    private Voiture voiture;
    private ArrayList <Offre> offres;

    public Moniteur(String n, String p, int tel, String m, String a, String d, int c, String u, String mdp, int age, int e, Voiture v, ArrayList <Offre> o) {
        super(n, p, tel, m, a, d, c, u, mdp, age);
        experience = e;
        voiture = v;
        offres = o;
    }
    
    public void ajoutOffre(Offre o){
        offres.add(o);
    }
       
}
    

