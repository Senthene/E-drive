/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import BDD.UtilisateurBDD;
import Modèles.Moniteur;
import Modèles.Utilisateur;
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
    }

    /**
     * Retrieves representation of an instance of serveur.UtilisateurResource
     * @return an instance of java.lang.String
     */
    @GET // Vérifie si l'adressse email existe deja.
    @Path("Connexion/{mail}")
    @Produces(MediaType.TEXT_HTML)
    public Response getEmail(@PathParam("mail") String mail){
        res =UtilisateurBDD.VérifieEmail(mail);
        if (res){
            return Response.status(Response.Status.OK).entity("").build();
        }
            return Response.status(Response.Status.OK).entity("Cet e-mail est déja utilisé").build(); 
        }

    
    /**
     * PUT method for updating or creating an instance of UtilisateurResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("Compte/{mail}/{mdp}/{type}/{nom}/{prenom}/{dateNaissance}/{téléphone}/{adresse}/{codePostale}/{département}")
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
    


}

