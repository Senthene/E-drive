/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import BDD.UtilisateurBDD;
import Modèles.Moniteur;
import Modèles.Utilisateur;
import com.google.gson.Gson;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response.Status;

    

/**
 * REST Web Service
 *
 * @author Abdelkarim
 */
@Path("Utilisateur")
public class UtilisateurResource {

    @Context
    private UriInfo context;
    private boolean res;
    private ArrayList <Utilisateur> utilisateur;
    Utilisateur uti;

    /**
     * Creates a new instance of UtilisateurResource
     */
    public UtilisateurResource() {
        utilisateur  = new ArrayList<Utilisateur>();
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

    /**
     * Retrieves representation of an instance of serveur.UtilisateurResource
     * @return an instance of java.lang.String
     */
    
    /*
    @GET // Vérifie si l'adressse email existe deja.
    @Path("Vérification/{mail}")
    @Produces(MediaType.TEXT_HTML)
    public Response getEmail(@PathParam("mail") String mail){
        res =UtilisateurBDD.VérifieEmail(mail);
        if (res){
            //Si l'email existe pas
            return Response.status(Response.Status.OK).entity("").build();

        }
        else {
            return Response.status(Response.Status.OK).entity("ok").build(); 
        }
    }
*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)//Connexion
    @Path("Connexion/{mail}/{mdp}")
    public Response getUtilisateur(@PathParam("mail") String mail, @PathParam("mdp") String passe) {
        utilisateur = UtilisateurBDD.GenerateUtilisateur(mail, passe);
        String json = new Gson().toJson(utilisateur);
        json =json.replace("\"", "'");
        json =json.replace("[", "");
        json =json.replace("]", "");
        return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
    }
    

    /**
     * PUT method for updating or creating an instance of UtilisateurResource
     * @param content representation for the resource
     /*
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("Compte/Création/{mail}/{mdp}/{type}/{nom}/{prenom}/{dateNaissance}/{téléphone}/{adresse}/{codePostale}/{département}")
    public Response getInscription(@PathParam("mail") String mail, 
                            @PathParam("mdp") String mdp, 
                            @PathParam("type") String type, 
                            @PathParam("nom") String nom, 
                            @PathParam("prenom") String prenom,
                            @PathParam("téléphone") int téléphone,
                            @PathParam("dateNaissance") String dateNaissance,
                            @PathParam("adresse") String adresse,
                            @PathParam("codePostale") int codePostale,
                            @PathParam("département") int département){
        //Vérification des champs
        
        uti = new Utilisateur();
        res= uti.inscription(mail, mdp, type, nom, prenom, dateNaissance, téléphone, adresse, codePostale, département);
        
        //moniteur.add(new Moniteur(mail, mdp, type, nom, prenom, dateNaissance, téléphone, adresse, codePostale, département, dateInscription, exprérience, voiture, offres));       
        //return Response
      //.status(Status.OK)
      //.entity("Bienvenue "+ nom)
      //.build();
        return null;
    }
*/

}

