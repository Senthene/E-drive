/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import Modèles.Utilisateur;
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
 * @author Sénthène
 */
@Path("generic")
public class Offre {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Offre
     */
    public Offre() {
    }

    /**
     * Retrieves representation of an instance of serveur.Offre
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("recherche/{codePostale}/{departement}")
    public Response getRecherche(@PathParam("codePostale") int codepostale,@PathParam("departement") int departement){
        //Vérification des champs
        
        
        //moniteur.add(new Moniteur(mail, mdp, type, nom, prenom, dateNaissance, téléphone, adresse, codePostale, département, dateInscription, exprérience, voiture, offres));       
        //return Response
      //.status(Status.OK)
      //.entity("Bienvenue "+ nom)
      //.build();
        return null;
    }

    /**
     * PUT method for updating or creating an instance of Offre
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
