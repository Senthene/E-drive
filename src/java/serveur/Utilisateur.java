/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

/**
 *
 * @author Sénthène
 */
public class Utilisateur {
    
    private String nom;
    private String prenom;
    private String mdp;
    private int numeroTel;
    private String mail;
    private String adresse;
    private String departement;
    private int codePostale;
    private int age;
    
    public Utilisateur (String n, String p, int tel, String m, String a, String d, int c, String u, String mdp, int age){
     
        nom =n;
        prenom = p;
        numeroTel = tel;
        mail = m;
        adresse = a;
        departement = d;
        codePostale = c;
        this.mdp= mdp;
        this.age = age;
        }
}
