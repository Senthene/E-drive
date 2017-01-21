
package serveur;
import BDD.MoniteurBDD;
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
import org.json.JSONException;
import org.json.JSONObject;

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
    private static final String SUCCESS_RESULT="{'resultat' : 'Succès'}";
    private static final String FAILURE_RESULT="{'resultat' : 'Echec'}";
    private boolean res;
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
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
 /*   @GET // This method process GET request from client
    @Path("{uniqueId}")
    @Produces(MediaType.APPLICATION_JSON) // Sends JSON
    public String getDOnnees(@PathParam("uniqueId") int id){
        // UniqueId représente l'id envoyé par le client
        if ( id >= 0 && id < moniteur.size())
            return moniteur.get(id).toJSON();
        else
            return "{\"nom\" : \"Inconnu\", \"prenom\" : \"Inconnu\"}";
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Recherche/{codePostale}/{departement}")
    public Response getRecherche(@PathParam("codePostale") int codepostale,@PathParam("departement") int departement){
        moniteur = MoniteurBDD.rechercheMoniteur(codepostale, departement);
        String json = new Gson().toJson(moniteur);
      //  json =json.replace("\"", "'");
        //json =json.replace("[", "");
        //json =json.replace("]", "");
        return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
       
    }
    
    // Mise à jour d'un profil Moniteur
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("MiseAJour")
    public Response MAJProfilMoniteur(String s) throws JSONException {
        
       JSONObject jsonObj = new JSONObject(s);

       //Inscription(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d)
        res = MoniteurBDD.UpdateProfilMoniteur(jsonObj.getString("email"), jsonObj.getString("mdp"), jsonObj.getString("nom"), jsonObj.getString("prenom"), jsonObj.getInt("numeroTel"), jsonObj.getString("adresse"), jsonObj.getInt("departement"), jsonObj.getInt("codePostale"));
        if (res == true){
            return Response.status(200).entity(SUCCESS_RESULT).type(MediaType.APPLICATION_JSON).build();
        }
        else {
            return Response.status(200).entity(FAILURE_RESULT).type(MediaType.APPLICATION_JSON).build();
        }   
    }
    
    

    

}

