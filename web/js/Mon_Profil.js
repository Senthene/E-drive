function hide(){
    var form = document.getElementById("modifier");
    var paragraphe = document.getElementById("paragraphe");
    if(form.style.display == "none" && paragraphe.style.display == "block"){
        form.style.display = "block";
        paragraphe.style.display = "none";
        var monobjet_json = sessionStorage.getItem("objet");
        var profil = JSON.parse(monobjet_json);
        
        document.getElementById('nom').value = profil.nom;
        document.getElementById('prénom').value = profil.prenom;
        document.getElementById('email').value = profil.mail;
        document.getElementById('mdp').value = profil.mdp;
        document.getElementById('téléphone').value = profil.numeroTel; 
        document.getElementById('addresse').value  = profil.adresse;
        document.getElementById('cp').value  = profil.codePostale;

    }   
    else {
        form.style.display = "none"; 
        paragraphe.style.display = "block";
    }
}
function MAJProfil(){
    
   var nomOK = verif_champ(document.getElementById('nom'));
   var prénomOK = verif_champ(document.getElementById('prénom'));
   var mailOk = verifMail(document.getElementById('email'));
   var adresseOK = verif_champ(document.getElementById('addresse'));
   var mdpOK = verif_champ(document.getElementById('mdp'));
   var cpOK = verif_champ(document.getElementById('cp'));
   var téléphoneOK = verif_champ(document.getElementById('téléphone'));
   
    if(nomOK && prénomOK && mailOk && adresseOK && cpOK && téléphoneOK && mdpOK ){
        var nom = document.getElementById('nom').value;
        var prénom = document.getElementById('prénom').value;
        var email = document.getElementById('email').value;
        var mdp = document.getElementById('mdp').value;
        var téléphone = document.getElementById('téléphone').value;
        var adresse = document.getElementById('addresse').value;
        var cp = document.getElementById('cp').value;

        var xmlhttp = new XMLHttpRequest();
        var dep = cp.substr(0,2);
        var url = "http://localhost:8080/E-DRIVE/webresources/Moniteur/MiseAJour";
        xmlhttp.open('PUT',url,true);
        xmlhttp.setRequestHeader("Content-type", "application/json");
        var data = JSON.stringify({"email":email,"nom":nom,"prenom":prénom,"mdp":mdp,"numeroTel":parseInt(téléphone),"adresse":adresse,"codePostale":parseInt(cp), "departement":parseInt(dep)});
       
        xmlhttp.send(data);
        xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4 ) {
                   if ( xmlhttp.status == 200) {
                       var resp = eval( "(" +  xmlhttp.responseText + ")"); 
  
                       if(resp.resultat == 'Succès'){
                            Connexion(email, mdp);
                            ChargementProfil();
                       }
                       
                   }

                 }              
        };
    }
    else {
      alert("Veuillez remplir correctement tous les champs");
   } 
}

function AjouterOfffe(){
    
    var monobjet_json = sessionStorage.getItem("objet");
    var profil = JSON.parse(monobjet_json);

   var email = profil.mail; 
    
   var cpOK = verif_champ(document.getElementById('ajoutcp'));
   var prixOK = verif_champ(document.getElementById('Prix'));
   var HdébutOk = verif_champ(document.getElementById('HDebut'));
   var HfinOK = verif_champ(document.getElementById('HFin'));
   var DateOK = verif_champ(document.getElementById('Date'));
   
    if(prixOK && HdébutOk && HfinOK && DateOK && cpOK ){
        var cp = document.getElementById('ajoutcp').value;
        var Prix = document.getElementById('Prix').value;
        var Hdébut = document.getElementById('HDebut').value;
        var HFin = document.getElementById('HFin').value;
        var Date = document.getElementById('Date').value;

        var xmlhttp = new XMLHttpRequest();
        var dep = cp.substr(0,2);
        var url = "http://localhost:8080/E-DRIVE/webresources/Offre/Ajouter";
        xmlhttp.open('POST',url,true);
        xmlhttp.setRequestHeader("Content-type", "application/json");
        var data = JSON.stringify({"email":email,"cp":parseInt(cp),"Prix":parseInt(Prix),"Hdébut":Hdébut,"HFin":HFin,"Date":Date});
       
        xmlhttp.send(data);
        xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4 ) {
                   if ( xmlhttp.status == 200) {
                       var resp = eval( "(" +  xmlhttp.responseText + ")"); 
  
                       if(resp.resultat == 'Succès'){
                           
                           document.getElementById('offreAjout').click();
                       }
                       
                   }

                 }              
        };
    }
    else {
      alert("Veuillez remplir correctement tous les champs");
   } 
}

//******************************************************************************
//                          VERIFICATION DES CHAMPS
//******************************************************************************

// Vérification du champs Texte
function verif_champ(champ) {
    if (champ.value == "") {
        //alert("Le champs "+champ+" n'est pas renseigné");
        surligne(champ, true);
        return false;
    }
    surligne(champ, false);
    return true;
}
// Vérification du champs Email
function verifMail(champ){
    var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
    if(!regex.test(champ.value))
    {
       surligne(champ, true);
       return false;
    }
    else
    {
        return true;
    } 
}
//Fonction qui souligne le input en rouge
function surligne(champ, erreur) {
   if(erreur)
      champ.style.backgroundColor = "#fba";
   else
      champ.style.backgroundColor = "";
}

function affCach(cache, id, reponse){
    if (cache){
        document.getElementById(id).style.display = "none";
        document.getElementById(id).innerHTML = "";
    } 
    else {
        document.getElementById(id).style.display = "inline";
        document.getElementById(id).innerHTML = reponse;
    }
}
function génèreImage(champ){
    if (champ.value == "Moniteur"){
        document.getElementById("Eleve").style.display = "none";
        document.getElementById("Moniteur").style.display = "block";
    } 
    else {
        document.getElementById("Eleve").style.display = "block";
        document.getElementById("Moniteur").style.display = "none";
    }
}

function ChargementProfil(){
    var monobjet_json = sessionStorage.getItem("objet");
    var profil = JSON.parse(monobjet_json);
   
    document.getElementById('NomPrenom').innerHTML  = profil.nom + " " + profil.prenom;
    document.getElementById('Email').innerHTML  = profil.mail;
   // document.getElementById('mdp').value = profil.mdp;
    document.getElementById('Numero').innerHTML  = profil.numeroTel;
    document.getElementById('Addresse').innerHTML   = profil.adresse;
    document.getElementById('cp').innerHTML   = profil.codePostale;
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Offre/ListeOffre/"+profil.mail;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
         
               if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                    var resp = eval( "(" +  xmlhttp.responseText + ")"); 
                    console.log(resp);
                    var compteur = 0;
                    var s="";
                    while(compteur < resp.length){
                        
                        var date = resp[compteur].date;
                        console.log(resp);
                         console.log("date =" + date);
                        var heureDebut = resp[compteur].heureDebut;
                        var heureFin = resp[compteur].heureFin;
                        var statut = resp[compteur].etatActuel;
                        var prix = resp[compteur].prix;
                        var id = resp[compteur].id;
    
                  s = s + "<li> <div class=\"row intro-tables\"><div class=\"col-md-4\"><div class=\"intro-table intro-table-first-hover\"><h5 class=\"white heading hide-hover\"> "+date+ "</h5><div class=\"bottom\"><h4 class=\"white heading small-heading no-margin regular\">Le cours a lieu de "+heureDebut+" "+"à "+heureFin+ " <br><b>Pour seulement "+prix+" €</b></br><i><br>Offre " +statut+"</i></br></h4> <a onclick = \"supprimerOffre("+id+")\" class=\"btn btn-white-fill expand \">Supprimer</a></div></div></div><\li>" ;
                        //SCRIPT POUR AFFICHER
                      compteur ++;
                    }
                        var elem = document.getElementById('listeOffre');
                                                //if (nom != null){
                                            elem.innerHTML= s;
                  }
                  
                
                         
                  /* test : alert (resp[0].nom);
                   console.log(resp.length);
                      console.log(resp);
                      console.log(resp[0].nom);
                      alert(resp[0].nom);
                      console.log(resp[1].voiture.modele);
                      alert(resp[1].voiture.modele) */
                  
                    if (resp.echec != null) {
                       // alert(resp.echec);
                    }
                 }
                 else {
                    //alert("Error ->" + xmlhttp.responseText);
                 }
              }
        
    
    
}
function supprimerOffre(id){
    alert("success "+ id);
            var xmlhttp = new XMLHttpRequest();

     var url = "http://localhost:8080/E-DRIVE/webresources/Offre/Supression/"+id;
        xmlhttp.open('DELETE',url,true);
       
       
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4 ) {
                   if ( xmlhttp.status == 200) {
                       alert("VOtre offre à été supprimé"); 
  
                       if(resp.resultat == 'Succès'){
                           
                           document.getElementById('offreAjout').click();
                       }
                       
                   }

                 }              
};
}
//************************************************************
//                      Supression d'un profil
//*************************************************************
function SuppProfil(){
    var monobjet_json = sessionStorage.getItem("objet");
    var profil = JSON.parse(monobjet_json);
    var email = profil.mail;
    

        var xmlhttp = new XMLHttpRequest();

        var url = "http://localhost:8080/E-DRIVE/webresources/Utilisateur/Suppresion/";
        xmlhttp.open('DELETE',url,true);
     
        xmlhttp.send(email);
        xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                    var resp = eval( "(" +  xmlhttp.responseText + ")"); 
                    
                    if(resp.resultat == 'Succès'){
                        //sessionStorage.clear();
                    }
                 }
              }
        };

    
}
