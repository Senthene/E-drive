/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import BDD.UtilisateurBDD;
import Modèles.Utilisateur;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Abdelkarim
 */


@Path("Utilisateur")
public class UtilisateurResource {

    @Context
    private UriInfo context;
    private ArrayList <Utilisateur> utilisateur;
    
    

    /**
     * Creates a new instance of UtilisateurResource
     */
    public UtilisateurResource() {
        utilisateur  = new ArrayList<Utilisateur>();
    }

    /**
     * Retrieves representation of an instance of serveur.UtilisateurResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UtilisateurResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)//Connexion
    @Path("Connexionn/{mail}/{mdp}")
    public Response getUtilisateur(@PathParam("mail") String mail, @PathParam("mdp") String passe) {
        utilisateur = UtilisateurBDD.GenerateUtilisateur(mail, passe);
        String json = new Gson().toJson(utilisateur);
        json =json.replace("\"", "'");
        json =json.replace("[", "");
        json =json.replace("]", "");
        if(json.isEmpty()){
            json="{'reponse':'Votre compte nexiste pas'}";
        }
        return Response.status(200).entity(json).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET").type(MediaType.APPLICATION_JSON).build();
    }    

}
