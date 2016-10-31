/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèles;

/**
 *
 * @author Sénthène
 */
public class Eleve extends Utilisateur{
    
    private int nbHeureCours;

    public Eleve(String n, String p, int tel, String m, String a, String d, int c, String u, String mdp, String dateNaissance, String dateInscription, int nbc) {
        super(m, mdp, n, p, dateNaissance, tel, a, c, d, dateInscription);
        nbHeureCours = nbc;
    }

   

  
   
    
}
