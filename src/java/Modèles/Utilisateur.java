                           
package Modèles;

import BDD.UtilisateurBDD;

/**
 *
 * @author Sénthène
 */
public class Utilisateur {
    
    private String nom;
    private String prenom;
    private String type;
    private String mdp;
    private int numeroTel;
    private String mail;
    private String adresse;
    private String departement;
    private int codePostale;
    private String dateNaissance;
    private String dateInscription;
    private String experience;

    
    public Utilisateur (String m, String mdp, String type, String n, String p, String dateNaissance, int tel, String a, int c, String d, String dateInscription){
     
        this.mail = m;
        this.mdp= mdp;
        this.type = type;
        this.nom =n;
        this.prenom = p;
        this.dateNaissance = dateNaissance;
        this.numeroTel = tel;
        this.adresse = a;
        this.codePostale = c;
        this.departement = d;
        this.dateInscription = dateInscription;

        
    }
    
    public Utilisateur() {
        
        this.nom = "";
        this.prenom = "";
        this.type="";
        this.mail="";
        this.dateNaissance="";
        this.numeroTel=0;
        this.adresse = "";
        this.dateInscription = "";
        experience ="";

    }
    
    public boolean inscription(String mail, String mdp1, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d){
//        if(isEmpty(mail) && isEmpty(mdp1) && isEmpty(mdp2) && isEmpty(type) && isEmpty(nom) && isEmpty(prenom) && isEmpty(dateNaissance) && isEmpty(a)){
//                return false;

            UtilisateurBDD.Inscription(mail, mdp1, type, nom, prenom, dateNaissance, tel, a, c, d);
            return true;
        
    }
    
    
    // Setter
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setEmail(String mail){
        this.mail = mail;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }    
    public void setTelephone(int telephone){
        this.numeroTel = telephone;
    }
    public void setDateInscription(String dateInscription){
        this.dateInscription = dateInscription;
    }
    public void setDateNaissance(String dateNaissance){
        this.dateNaissance = dateNaissance;
    }
    // Getter
    public String getDateNaissance(){
        return dateNaissance;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getEmail(){
        return mail;
    }
    public String getAdresse(){
        return adresse;
    }
    public int getTelephone(){
        return numeroTel;
    }
    public String getDateInscription(){
        return dateInscription;
    }
    
    public String toJSON() {
        return "{'nom':'" + this.nom + "', 'prenom':'" + this.prenom + "'}\n";
    }
}
