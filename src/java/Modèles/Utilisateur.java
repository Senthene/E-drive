
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
    private int age;
    private String dateInscription;
    
    public Utilisateur (String n, String p, int tel, String m, String a, String d, int c, String u, String mdp, int age, String dateInscription){
     
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
    
    public Utilisateur() {
        
        this.nom = "";
        this.prenom = "";
        this.mail="";
        this.age=0;
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
    public void setAge(int age){
        this.age = age;
    }
    // Getter
    public int getAge(){
        return age;
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
