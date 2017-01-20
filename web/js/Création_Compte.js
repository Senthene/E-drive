//Vérification lors de l'ensemble des champs du formulaire
function Inscription()
{
   var nomOK = verif_champ(document.getElementById('nom'));
   var prénomOK = verif_champ(document.getElementById('prénom'));
   var mailOk = verifMail(document.getElementById('email'));
   var adresseOK = verif_champ(document.getElementById('addresse'));
   var mdpOK = verif_champ(document.getElementById('mdp'));
   var mdp2OK = verif_champ(document.getElementById('mdp2'));
   var cpOK = verif_champ(document.getElementById('cp'));
   var téléphoneOK = verif_champ(document.getElementById('téléphone'));
   
   if(nomOK && prénomOK && mailOk && adresseOK && cpOK && téléphoneOK && mdpOK && mdp2OK){
        var mdp = document.getElementById('mdp').value;
        var mdp2 = document.getElementById('mdp2').value;
        if (mdp == mdp2)
            CreationCompte();
        else
        {
        alert("Les mots de passes renseignés ne sont identiques");
        return false; 
        }
   }
   else
   {
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}

function CreationCompte() {

    //Récupération du Statut du profil
    var radios = document.getElementsByName('Type');
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            var type =radios[i].value;
            break;
        }
    }
    var nom = document.getElementById('nom').value;
    var prénom = document.getElementById('prénom').value;
    var dateNaissance = document.getElementById('naissance').value;
    var email = document.getElementById('email').value;
    var mdp = document.getElementById('mdp').value;
    var téléphone = document.getElementById('téléphone').value;
    //var expérience = document.getElementById('expérience').value;
    var adresse = document.getElementById('addresse').value;
    var cp = document.getElementById('cp').value;

    var xmlhttp = new XMLHttpRequest();
    var dep = cp.substr(0,2);
    var url = "http://localhost:8080/E-DRIVE/webresources/Utilisateur/Inscription";
    xmlhttp.open('POST',url,true);
    xmlhttp.setRequestHeader("Content-type", "application/json");
    var data = JSON.stringify({"email":email,"type":type,"nom":nom,"prenom":prénom,"dateNaissance":dateNaissance,"mdp":mdp,"numeroTel":parseInt(téléphone),"adresse":adresse,"codePostale":parseInt(cp), "departement":parseInt(dep)});
       
    xmlhttp.send(data);
    xmlhttp.onreadystatechange = function() {
         
                if (xmlhttp.readyState == 4 ) {
                   if ( xmlhttp.status == 200) {
                       var resp = eval( "(" +  xmlhttp.responseText + ")"); 
  
                       if(resp.resultat == 'Succès'){
                           var monobjet_json = JSON.stringify(data);
                           sessionStorage.setItem("objet",monobjet_json );
                           location.href="Profil.html";
                       }
                       
                   }

                 }              
    }
}

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
    
