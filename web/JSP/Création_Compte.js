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
            var mdp2 = document.getElementById('mdp2').value;
            var téléphone = document.getElementById('téléphone').value;
            var expérience = document.getElementById('expérience').value;
            var adresse = document.getElementById('adresse').value;
            var cp = document.getElementById('cp').value;
            
            //Vérifie email
            var res = verifEmail(email);
            
           //Si le mail est déja utiliser !
           
            if ((type=null) && (nom=null) && (prénom=null) && (dateNaissance=null) && (email=null) && (mdp=null) && (mdp2=null) && (téléphone=null) && (expérience=null) && (adresse=null) && (cp=null)){
                return alert("Veuillez remplir les champs manquants");
            }
            else {
                var xmlhttp = new XMLHttpRequest();
                var dep = cp.substr(0,2);
                var url = "http://localhost:8080/E-drive/webresources/Moniteur/Compte/"+email+"/"+mdp+"/"+type+"/"+nom+"/"+prénom+"/"+dateNaissance+"/"+téléphone+"/"+adresse+"/"+cp+"/"+dep+"/"+expérience;
                console.log(url);
                xmlhttp.open('POST',url,true);
                xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xmlhttp.onerror = onError;
                xmlhttp.send(null);
                
            }
}
function onError(e) {
  alert("Une erreur " + e.target.status + " s'est produite au cours de la réception du document.");
}
//Vérification lors de l'ensemble des champs du formulaire
function verifForm(f)
{
   var nomOK = verif_champ(f.nom);
   var prénomOK = verif_champ(f.prénom);
   var mailOk = verifMail(f.email);
   var adresseOK = verif_champ(f.adresse);
   var mdpOK = verif_champ(f.mdp);
   var mdp2OK = verif_champ(f.mdp2);
   var cpOK = verif_champ(f.cp);
   var téléphoneOK = verif_champ(f.téléphone);
   
   if(nomOK && prénomOK && mailOk && adresseOK && cpOK && téléphoneOK && mdpOK && mdp2OK){
        var mdp = document.getElementById('mdp').value;
        var mdp2 = document.getElementById('mdp2').value;
        if (mdp == mdp2)
            return true;
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
       surligne(champ, false);
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
function verifEmail(email){
    
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/E-drive/webresources/Moniteur/Connexion/"+email;
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if ( xmlhttp.status == 200) {
                return true;
            }
            else
                alert("Error ->" + xmlhttp.responseText);
        }
    };
}
