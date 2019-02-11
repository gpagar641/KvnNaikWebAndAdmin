 
		$(document).ready(function(){
  			$(window).scroll(function(){
  				var scroll = $(window).scrollTop();
	  				if (scroll > 000)
	  				 {
	     						$(".navbar").css("top" , "-10px");
	     				}

	  				else
	  				{
		   						$(".navbar").css("top" , "00px");
		 			 }
  				})
		})
 
		$(document).ready(function(){
  $(window).scroll(function(){
  	var scroll = $(window).scrollTop();
	  if (scroll > 200) {
	    $(".navbar-nav").css("background" , "");
	  }

	  else{
		  $(".navbar-collapse").css("background" , "#f4e8c7");  	
		  $(".nav-item").css("color" , "#f4e8c7 !important");  
	  }
  })
})
	 
		$(document).ready(function(){
  $(window).scroll(function(){
  	var scroll = $(window).scrollTop();
	  if (scroll < 200) {
	    $(".navbar-nav").css("background" , "");
	  }

	  else{
		  $(".navbar-collapse").css("background" , "#f4e8c7");  
		 
		/*   $("a").removeClass("text-white"); */
		  //$(".nav-item").css("color" , "#000 !important");  
		 
	  }
  })
})
		 
