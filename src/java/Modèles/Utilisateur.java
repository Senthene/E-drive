
package Modèles;

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
    private String dateNaissance;
    private String dateInscription;
    
    public Utilisateur (String m, String mdp, String n, String p, String dateNaissance, int tel, String a, int c, String d, String dateInscription){
     
        this.mail = m;
        this.mdp= mdp;
        this.nom =n;
        this.prenom = p;
        this.dateNaissance = dateNaissance;
        this.numeroTel = tel;
        this.adresse = a;
        this.codePostale = c;
        this.departement = d;       
        
    }
    
    public Utilisateur() {
        
        this.nom = "";
        this.prenom = "";
        this.mail="";
        this.dateNaissance="";
        this.numeroTel=0;
        this.adresse = "";
        this.dateInscription = "";
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
