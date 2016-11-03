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
    
    public Eleve(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, String d, String dateInscription, int nbc) {
        super(mail, mdp, type, nom, prenom, dateNaissance, tel, a, c, d, dateInscription);
        nbHeureCours = nbc;
    }

   

  
   
    
}