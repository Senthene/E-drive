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
                           
                           alert(resp.resultat);
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

    
}