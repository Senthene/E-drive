jQuery(function($) {
	"use strict";
	// Author Code Here

	var owlPricing;
	var ratio = 2;

	// Window Load
	$(window).load(function() {
		// Preloader
		$('.intro-tables, .parallax, header').css('opacity', '0');
		$('.preloader').addClass('animated fadeOut').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() {
			$('.preloader').hide();
			$('.parallax, header').addClass('animated fadeIn').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function() {
				$('.intro-tables').addClass('animated fadeInUp').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');
			});
		});


		// Header Init
		if ($(window).height() > $(window).width()) {
			var ratio = $('.parallax').width() / $('.parallax').height();
			$('.parallax img').css('height', ($(window).height()) + 'px');
			$('.parallax img').css('width', $('.parallax').height() * ratio + 'px');
		}

		$('header').height($(window).height() + 80);
		$('section .cut').each(function() {
			if ($(this).hasClass('cut-top'))
				$(this).css('border-right-width', $(this).parent().width() + "px");
			else if ($(this).hasClass('cut-bottom'))
				$(this).css('border-left-width', $(this).parent().width() + "px");
		});

		// Sliders Init
		$('.owl-schedule').owlCarousel({
			singleItem: true,
			pagination: true
		});
		$('.owl-testimonials').owlCarousel({
			singleItem: true,
			pagination: true
		});
		$('.owl-twitter').owlCarousel({
			singleItem: true,
			pagination: true
		});

		// Navbar Init
		$('nav').addClass('original').clone().insertAfter('nav').addClass('navbar-fixed-top').css('position', 'fixed').css('top', '0').css('margin-top', '0').removeClass('original');
		$('.mobile-nav ul').html($('nav .navbar-nav').html());
		$('nav.navbar-fixed-top .navbar-brand img').attr('src', $('nav.navbar-fixed-top .navbar-brand img').data("active-url"));

		// Typing Intro Init
		$(".typed").typewriter({
			speed: 60
		});

		// Popup Form Init
		var i = 0;
		var interval = 0.15;
		$('.popup-form .dropdown-menu li').each(function() {
			$(this).css('animation-delay', i + "s");
			i += interval;
		});
		$('.popup-form .dropdown-menu li a').click(function(event) {
			event.preventDefault();
			$(this).parent().parent().prev('button').html($(this).html());
		});

		// Onepage Nav
		$('.navbar.navbar-fixed-top .navbar-nav').onePageNav({
			currentClass: 'active',
			changeHash: false,
			scrollSpeed: 400,
			filter: ':not(.btn)'
                        
		});
	});
	// Window Scroll
	function onScroll() {
		if ($(window).scrollTop() > 50) {
			$('nav.original').css('opacity', '0');
			$('nav.navbar-fixed-top').css('opacity', '1');
		} else {
			$('nav.original').css('opacity', '1');
			$('nav.navbar-fixed-top').css('opacity', '0');
		}
	}

	window.addEventListener('scroll', onScroll, false);

	// Window Resize
	$(window).resize(function() {
		$('header').height($(window).height());
	});

	// Pricing Box Click Event
	$('.pricing .box-main').click(function() {
		$('.pricing .box-main').removeClass('active');
		$('.pricing .box-second').removeClass('active');
		$(this).addClass('active');
		$(this).next($('.box-second')).addClass('active');
		$('#pricing').css("background-image", "url(" + $(this).data('img') + ")");
		$('#pricing').css("background-size", "cover");
	});

	// Mobile Nav
	$('body').on('click', 'nav .navbar-toggle', function() {
		event.stopPropagation();
		$('.mobile-nav').addClass('active');
	});

	$('body').on('click', '.mobile-nav a', function(event) {
		$('.mobile-nav').removeClass('active');
		if(!this.hash) return;
		event.preventDefault();
		if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
			event.stopPropagation();
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
			if (target.length) {
				$('html,body').animate({
					scrollTop: target.offset().top
				}, 1000);
				return false;
			}
		}
	});

	$('body').on('click', '.mobile-nav a.close-link', function(event) {
		$('.mobile-nav').removeClass('active');
		event.preventDefault();
	});

	$('body').on('click', 'nav.original .navbar-nav a:not([data-toggle])', function() {
		if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
			event.stopPropagation();
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
			if (target.length) {
				$('html,body').animate({
					scrollTop: target.offset().top
				}, 1000);
				return false;
			}
		}
	});

	function centerModal() {
		$(this).css('display', 'block');
		var $dialog = $(this).find(".modal-dialog"),
			offset = ($(window).height() - $dialog.height()) / 2,
			bottomMargin = parseInt($dialog.css('marginBottom'), 10);

		// Make sure you don't hide the top part of the modal w/ a negative margin
		// if it's longer than the screen height, and keep the margin equal to 
		// the bottom margin of the modal
		if (offset < bottomMargin) offset = bottomMargin;
		$dialog.css("margin-top", offset);
	}

	$('.modal').on('show.bs.modal', centerModal);

	$('.modal-popup .close-link').click(function(event){
		event.preventDefault();
		$('#modal1').modal('hide');
	});

	$(window).on("resize", function() {
		$('.modal:visible').each(centerModal);
	});
        
      
   /* else
    {
       alert("Veuillez remplir correctement tous les champs");
    }*/

});
  function recherche(){
    
        var recherche = document.getElementById('recherche').value;
        var codepostale;
        var departement;
        if (recherche.length == 2){
            codepostale = 0;
            departement = recherche;
        }
        else {
            codepostale = recherche;
            departement = 0;
        }
        
        
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Moniteur/Recherche/"+codepostale+"/"+departement;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
         
               if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                    var resp = eval( "(" +  xmlhttp.responseText + ")"); 
                    
                    var compteur = 0;
                    var s="";
                    while(compteur < resp.length){
                        
                        var nom = resp[compteur].nom;
                        // test console.log("nom =" + resp[compteur].nom);
                        var prenom = resp[compteur].prenom;
                        var type = resp[compteur].type;
                        var tel = resp[compteur].numeroTel;
                        var mail = resp[compteur].mail;
                        var adresse = resp[compteur].adresse;                
                        var codePostale = resp[compteur].codePostale;
                        var dateNaissance = resp[compteur].dateNaissance;
                        var experience = resp[compteur].experience;
                        var marque = resp[compteur].voiture.marque;
                        console.log("Marque de la voiture =" + resp[compteur].voiture.marque);
                        var modele = resp[compteur].voiture.modele;
                        console.log(modele);
                        var carburant = resp[compteur].voiture.carburant;
                        
                        var elem = document.getElementById('listeMoniteur');
                        if (nom != null){
                        
			
                        
                        
                    s = s + "<li> <div class=\"intro-table intro-table-second-hover\"><h5 class=\"white heading hide-hover\"><b>"+nom +" "+ prenom+"</b></h5><div class=\"bottom\"><h4 class=\"white heading small-heading no-margin regular\"><br>"+adresse+" "+codePostale+ "</br> <br><b>Voiture utilisés</b></br><br>"+marque+" "+modele+" "+carburant+"</br><br><i>"+experience+" cours donnés jusqu'à présent</i></br> </h4><a href=\"HTML/Offre.html \" class=\"btn btn-white-fill expand\">Consulter les offres</a></div></div><\li>" ;}
                        //SCRIPT POUR AFFICHER
                        
                        compteur ++;

                    }
                    elem.innerHTML= s;
                  /* test : alert (resp[0].nom);
                   console.log(resp.length);
                      console.log(resp);
                      console.log(resp[0].nom);
                      alert(resp[0].nom);
                      console.log(resp[1].voiture.modele);
                      alert(resp[1].voiture.modele) */
                  
                    if (resp.echec != null) {
                        alert(resp.echec);
                    }
                 }
                 else {
                    alert("Error ->" + xmlhttp.responseText);
                 }
              }
        };

    }
    
    
function consulterOffre(mail){
    
    
     //var recherche = document.getElementById('recherche').value;
     alert("test");
        
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/E-DRIVE/webresources/Offre/ListeOffre/"+mail;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
         
               if (xmlhttp.readyState == 4) {
                 if ( xmlhttp.status == 200) {
                    var resp = eval( "(" +  xmlhttp.responseText + ")"); 
                    
                    var compteur = 0;
                    var s="";
                    while(compteur < resp.length){
                        
                        var date = resp[compteur].dateCours;
                         console.log("nom =" + resp[compteur].dateCours);
                        var heureDebut = resp[compteur].heureDebut;
                        var heureFin = resp[compteur].heureFin;
                        var statut = resp[compteur].statut;
                        
                         var modele = resp[compteur].voiture.modele;
                       
                       
                        
                       // var elem = document.getElementById('listeMoniteur');
                        //if (nom != null){
                        
			
                        
                        
                   // s = s + "<li> <div class=\"intro-table intro-table-second-hover\"><h5 class=\"white heading hide-hover\"><b>"+nom +" "+ prenom+"</b></h5><div class=\"bottom\"><h4 class=\"white heading small-heading no-margin regular\"><br>"+adresse+" "+codePostale+ "</br> <br><b>Voiture utilisés</b></br><br>"+marque+" "+modele+" "+carburant+"</br><br><i>"+experience+" cours donnés jusqu'à présent</i></br> </h4><a href=\"consulterOffre("+mail+")\" class=\"btn btn-white-fill  expand\">Consulter les offres</a></div></div><\li>" ;}
                        //SCRIPT POUR AFFICHER
                        
                        compteur ++;

                    }
                    elem.innerHTML= s;
                  /* test : alert (resp[0].nom);
                   console.log(resp.length);
                      console.log(resp);
                      console.log(resp[0].nom);
                      alert(resp[0].nom);
                      console.log(resp[1].voiture.modele);
                      alert(resp[1].voiture.modele) */
                  
                    if (resp.echec != null) {
                        alert(resp.echec);
                    }
                 }
                 else {
                    alert("Error ->" + xmlhttp.responseText);
                 }
              }
        };
    
    
}
