/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import BDD.UtilisateurBDD;
import Modèles.Utilisateur;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Sénthène
 */
@Path("generic")
public class Offre {

    @Context
    private UriInfo context;
    private static final String SUCCESS_RESULT="{'resultat' : 'Succès'}";
    private static final String FAILURE_RESULT="{'resultat' : 'Echec'}";
    private boolean res;

    /**
     * Creates a new instance of Offre
     */
    public Offre() {
    }

    /**
     * Retrieves representation of an instance of serveur.Offre
     * @return an instance of java.lang.String
     */
    
    /**
     * PUT method for updating or creating an instance of Offre
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    //Création d'une offre
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Ajouter")
    public Response Inscription(String s) throws JSONException{

    
        JSONObject jsonObj = new JSONObject(s);
        
       //Inscription(String mail, String mdp, String type, String nom, String prenom, String dateNaissance, int tel, String a, int c, int d)
        res = UtilisateurBDD.Inscription(jsonObj.getString("email"), jsonObj.getString("mdp"), jsonObj.getString("type"), jsonObj.getString("nom"), jsonObj.getString("prenom"), jsonObj.getString("dateNaissance"), jsonObj.getInt("numeroTel"), jsonObj.getString("adresse"), jsonObj.getInt("codePostale"), jsonObj.getInt("departement"));
        if (res == true){
            return Response.status(200).entity(SUCCESS_RESULT).type(MediaType.APPLICATION_JSON).build();
        }
        else {
            return Response.status(200).entity(FAILURE_RESULT).type(MediaType.APPLICATION_JSON).build();
        }        
    }
}
