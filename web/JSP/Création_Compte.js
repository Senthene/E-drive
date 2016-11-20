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
    var expérience = document.getElementById('expérience').value;
    var adresse = document.getElementById('adresse').value;
    var cp = document.getElementById('cp').value;

    var xmlhttp = new XMLHttpRequest();
    var dep = cp.substr(0,2);
    var url = "http://localhost:8080/E-drive/webresources/Moniteur/Compte/"+email+"/"+mdp+"/"+type+"/"+nom+"/"+prénom+"/"+dateNaissance+"/"+téléphone+"/"+adresse+"/"+cp+"/"+dep+"/"+expérience;
    xmlhttp.open('POST',url,true);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlhttp.send(null);
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
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-drive/webresources/Utilisateur/Connexion/"+champ.value;
        xmlhttp.open('GET',url,false);
        xmlhttp.send(null);
        if (xmlhttp.status == 200) {
            if (xmlhttp.responseText=="") {
                affCach(true, "checkEmail", xmlhttp.responseText);
                surligne(champ, false);
                return true;
            }            
            else
                affCach(false, "checkEmail", xmlhttp.responseText);
                surligne(champ, true);
                return false;
        }            
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
