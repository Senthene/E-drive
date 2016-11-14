function CreationCompte() {
            var xmlhttp = new XMLHttpRequest();
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

            var url = "http://localhost:8080/ServiceUberPermis/webresources/Moniteur/"+email+"/"+type+"/"+nom+"/"+prénom+"/"+dateNaissance+"/"+téléphone+"/27 Rue des Noisetiers/93240/93/20/13-11-2016";
            alert(url);
            xmlhttp.open('POST',url,true);
            //xmlhttp.send(null);
            xmlhttp.onreadystatechange = function() {
                   if (xmlhttp.readyState == 4) {
                      if ( xmlhttp.status == 200) {
                           var res = eval( "(" +  xmlhttp.responseText + ")");
                           alert(res.nom);
                     }
                     else
                           alert("Error ->" + xmlhttp.responseText);
                  }
            };
}    
