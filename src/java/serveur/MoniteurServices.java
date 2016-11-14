
package serveur;
import BDD.UtilisateurBDD;
import Modèles.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * REST Web Service
 *
 * @author Abdelkarim
 */
@Path("Moniteur")
public class MoniteurServices {
    
    @Context
    private UriInfo context;
    private String type;
    private ArrayList <Moniteur> moniteur;
    private ArrayList <Utilisateur> utilisateur;
    private Voiture voiture;
    private ArrayList <Offre> offres;
    Moniteur moni;
    private boolean res = true;
    /**
     * Creates a new instance of UtilisateurServices
     */
    public MoniteurServices() {
        
        moniteur = new ArrayList<Moniteur>();
        utilisateur  = new ArrayList<Utilisateur>();
        offres = new ArrayList<Offre>();
        voiture = new Voiture();
        type = "Moniteur";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUtilisateur(@PathParam("mail") String mail) {
        utilisateur = UtilisateurBDD.GenerateUtilisateur(mail);
        String json = new Gson().toJson(utilisateur);
        return json;
    }
    @GET // Vérifie si l'adresse email existe déja
    @Path("Connexion/{mail}")
    @Produces(MediaType.TEXT_PLAIN) // Sends JSON
    public boolean getEmail(@PathParam("mail") String mail){
        return UtilisateurBDD.VérifieEmail(mail);
    }
    
    @GET // This method process GET request from client
    @Path("{uniqueId}")
    @Produces(MediaType.APPLICATION_JSON) // Sends JSON
    public String getDOnnees(@PathParam("uniqueId") int id){
        // UniqueId représente l'id envoyé par le client
        if ( id >= 0 && id < moniteur.size())
            return moniteur.get(id).toJSON();
        else
            return "{\"nom\" : \"Inconnu\", \"prenom\" : \"Inconnu\"}";
    }
    @GET // This method process GET request from client
    @Path("Connexion/{mail}/{mdp}")
    @Produces(MediaType.TEXT_PLAIN) // Sends JSON
    public boolean getDOnnees(@PathParam("mail") String mail,
                              @PathParam("mdp") String mdp ){
        return UtilisateurBDD.Connexion(mail, mdp);
    }
    

    @POST
    @Consumes("application/x-www-form-urlencoded")

    @Path("Compte/{mail}/{mdp}/{type}/{nom}/{prenom}/{dateNaissance}/{téléphone}/{adresse}/{codePostale}/{département}/{exprérience}")
    public Response getInscription(@PathParam("mail") String mail, 
                            @PathParam("mdp") String mdp, 
                            @PathParam("type") String type, 
                            @PathParam("nom") String nom, 
                            @PathParam("prenom") String prenom,
                            @PathParam("téléphone") int téléphone,
                            @PathParam("dateNaissance") String dateNaissance,
                            @PathParam("adresse") String adresse,
                            @PathParam("codePostale") int codePostale,
                            @PathParam("département") int département,
                            @PathParam("exprérience") int exprérience){
        //Vérification des champs
        
        moni = new Moniteur();
        res= moni.inscription(mail, mdp, type, nom, prenom, dateNaissance, téléphone, adresse, codePostale, département, exprérience);
        
        //moniteur.add(new Moniteur(mail, mdp, type, nom, prenom, dateNaissance, téléphone, adresse, codePostale, département, dateInscription, exprérience, voiture, offres));       
        //return Response
      //.status(Status.OK)
      //.entity("Bienvenue "+ nom)
      //.build();
        return null;
    }
    


}
