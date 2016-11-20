/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import BDD.UtilisateurBDD;
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
            return Response.status(Response.Status.OK).entity("Cette e-mail est déja utilisé").build(); 
        }

    
    /**
     * PUT method for updating or creating an instance of UtilisateurResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
