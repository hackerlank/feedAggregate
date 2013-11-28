$(document).ready(function(){
	
	$(".feedlink").click(function() {
/*		alert("HII");*/
/*		$("body").fadeOut(700).delay(2000);
		$("body").fadeIn(700);*/
	});

	$(".link_main").click(function() {
		var jslt;
		var element = $(this).attr("id");
		
		if(element=="about") {
			jslt="";
			jslt+= '      <div class="poster"> ';
			jslt+= '        	<a href="#">Welcome to Vincent KO Center!</a> ';
			jslt+= '			<h2>Here are my little profile:</h2> ';
			jslt+= '            <h2><b>Vincent Kim Oan</b><br /> ';
			jslt+= '            Born: 12/10/1989 in Ha Tien, Vietnam<br /> ';
			jslt+= '            Nationality: Vietnamese &amp; Chinese<br /> ';
			jslt+= '			</h2> ';
			jslt+= '        	<h2>Languages:  English &amp; Vietnamese</h2> ';
			jslt+= '            <h2>Education: Bachelor of Computer Science and minor in Information Technology </h2> ';
			jslt+= '            <h2>Skills: Computer troubleshooting/assembling/networking/programming/engineering, graphic designing, photo retouching/enhancing, web designing/developing.</h2>			 ';
			jslt+= '            <h2>Habits: Enjoying the nature, listening to classical instrumental, swimming on the ocean, singing karaoke, playing soccer<br /> ';
			jslt+= '            </h2> ';
			jslt+= '            <h3></h3> ';
			jslt+= '        </div>';
		}
		
		$("#content_context").html(jslt);	    	
		$("#body_section").fadeIn(600);
	});
	
});




