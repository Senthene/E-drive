
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
    
    private ArrayList <Utilisateur> moniteur;
     private ArrayList <Utilisateur> utilisateur;

    /**
     * Creates a new instance of UtilisateurServices
     */
    public MoniteurServices() {
        
        moniteur = new ArrayList<Utilisateur>();
        utilisateur  = new ArrayList<Utilisateur>();

    }

    /**
     * Retrieves representation of an instance of WebServices.UtilisateurServices
     * @return an instance of java.lang.String
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        String s= "{\"Utilisateur\":[";
        int cpt = 0;
        for (Utilisateur l : moniteur){
            if(cpt ==0)
                s+=l.toJSON();
            else
                s+=", "+l.toJSON();
            cpt++;     
        }

        return s+"]}\n";


    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUtilisateur() {
        
        utilisateur = UtilisateurBDD.GenerateUtilisateur();
        String json = new Gson().toJson(utilisateur);
        return json;
    }
      
    /**
     * PUT method for updating or creating an instance of UtilisateurServices
     * @param content representation for the resource
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    */
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
    @POST
    @Path("{mail}/{mdp}/{type}/{nom}/{prenom}/{dateNaissance}/{téléphone}/{adresse}/{codePostale}/{département}/{exprérience}/{dateInscription}")
    @Produces(MediaType.TEXT_PLAIN) 
    public Response getInfo(@PathParam("mail") String mail, 
                            @PathParam("mdp") String mdp, 
                            @PathParam("type") String type, 
                            @PathParam("nom") String nom, 
                            @PathParam("prenom") String prenom,
                            @PathParam("dateNaissance") String dateNaissance,
                            @PathParam("adresse") String adresse,
                            @PathParam("codePostale") String codePostale,
                            @PathParam("département") String département,
                            @PathParam("exprérience") String exprérience,
                            @PathParam("dateInscription") String dateInscription){
        
        return Response
      .status(Status.OK)
      .entity("<bonjour>Bonjour ENSMA de la part de " + mail + "</bonjour>")
      .build();
    }
}
