<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Vincent KO Center</title>
    <!-- <link rel="stylesheet" type="text/css" href="static/style/style.css" media="screen" /> -->
   <!--  <link rel="stylesheet" type="text/css" href="static/style/core.css" media="screen"/> -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/style/core_theme.css'/>" />
	<script src="<c:url value='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js' />" ></script>
     <script type="text/javascript" src="<c:url value='/static/js/feed_content_slidedown.js' /> "></script> 
    <script type="text/javascript">

	    /*feed_UI*/
	    $(document).ready(function(){
	      $(".link_feed").click(function(){
	    	var jslt;
	    	var element = $(this).attr("id");
	
	    	if(element=="feedList") {

	    	}

	    	else if (element=="feedList1") {

	    	}
	    	
	    	else if (element=="feedList1_1") {

	    	}

	    	else if (element=="feedList1_2") {

	    	}

	    	else if (element=="feedList7") {

	    	}
	    	
	    	else if (element=="feedList7_13") {

	    	}

	    	else if (element=="feedList7_14") {

	    	}

	    	else if (element=="feedList7_15") {

	    	}
	    	
	    	else jslt="";

/*     		$("#content_context").html(jslt);
    			
    		$("h2").each(function() {
        		$(this).html(unescape($(this).text()));
            }); 	 */
            
    		$("#body_section").fadeIn(600);
	    	
	      });

		  /* CLOSE CONTENT */
	      $("#closebutton").click(function(){
	    	$("#body_section").fadeOut(600);
	      });

	  	  /* CLOSE CONTENT WHEN MOUSE AWAY */
/* 	      $("#body_section").mouseleave(function(){
	    	$("#body_section").fadeOut(1300);
	      }); */
	      
	    });
	
	
	
	    /*top_nav */
	    $(function() {
	      if ($.browser.msie && $.browser.version.substr(0,1)<7)
	      {
	    	$('li').has('ul').mouseover(function(){
	    		$(this).children('ul').css('visibility','visible');
	    		}).mouseout(function(){
	    		$(this).children('ul').css('visibility','hidden');
	    		});
	      }
	    }); 


    </script>
</head>

<body>  
	<!-- HEADDER ***************************************************************************************************** --> 

   
    <div id="header"> 
    
        <nav id="menu-wrap">    
            <ul id="menu">
                <li><a href="index.html">Home</a></li>
        
                <li>
                    <a href="feed.html" class="link_feed" id="feedList">News Feed</a>
                    <ul>
                        <li>
                            <a href="cnn.html" class="link_feed" id="feedList1">CNN</a>
                            <ul>
                                <li><a href="cnntopstories.html" class="link_feed" id="feedList1_1">Top Stories</a></li>        
                                <li><a href="cnnbusiness.html" class="link_feed" id="feedList1_2">Business</a></li>
                            </ul>				
                        </li>
                        <li>
                            <a href="aolrealestate.html" class="link_feed" id="feedList7">AOL Real Estate</a>        
                            <ul>
                                <li><a href="realestatemain.html" class="link_feed" id="feedList7_13">Real Estate - Main</a></li>
                                <li><a href="realestatehowto.html" class="link_feed" id="feedList7_14">Real Estate - How-To</a></li> 
                                <li><a href="realestateforclosures.html" class="link_feed" id="feedList7_15">Forclosures</a></li>                                                                
                            </ul>				
                        </li>                        
                        <li>
                            <a href="#">Investopedia</a>        
                            <ul>
                                <li><a href="#">Term of Day</a></li>
                                <li><a href="#">Article</a></li>
                            </ul>				
                        </li>
        
                        <li>
                            <a href="#">Reuters</a> 				
                        </li>
                        <li>
                            <a href="#">NYT</a>				
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="link_main">Music</a>
				</li>
                <li>
                    <a href="#" class="link_main">Video</a>
				</li> 
                <li><a href="#" class="link_main">Gallery</a></li>                               
                <li><a href="#" class="link_main" id="about">About</a></li>
                <li><a href="#" class="link_main">Contact</a></li>
            </ul>
        </nav>
        
        <div id="body_section">
                <div id="content">
                    <div id="top_content"></div>
                    <div id="middle_content"></div>
                    <div id="bottom_content"></div>
                </div>
                <div id="content_context">
				      <div class="poster">
				        	<h1>Welcome to Vincent KO Center!</h1>
							<h2>Here are my little profile:</h2>
				            <h2>Vincent Kim Oan<br />
				            Born: 12/10/1989 in Ha Tien, Vietnam<br />
				            Nationality: Vietnamese &amp; Chinese<br />
							</h2>
				        	<h2>Languages:  English &amp; Vietnamese</h2>
				            <h2>Education: Bachelor of Computer Science and minor in Information Technology </h2>
				            <h2>Skills: Computer troubleshooting/assembling/networking/programming/engineering, graphic designing, photo retouching/enhancing, web designing/developing.</h2>			
				            <h2>Habits: Enjoying the nature, listening to classical instrumental, swimming on the ocean, singing karaoke, playing soccer<br />
				            </h2>
				            <h3></h3>
				        </div> 
                </div>  
                <button id="closebutton">X</button>
        </div> 
   	</div>
   	<div id="bottom_bar">
    </div>
    <div id="footer">
        <div id="credit">  Copy Right @ 2013 - Current | Developed By: Vincent Oan | Designed By: Vincent Oan | All Right Reserves. 
        </div> 
	</div>
 -->   
    <!-- /HEADDER **************************************************************************************************** --> 
    
    <!-- CONTENT ***************************************************************************************************** 
    <div id="top_content"></div>
    <div id="middle_content">
    	<div id="banner"></div>
      <div id="poster">
         
        </div>--> 
 <!--        
    	<div id="navigation">
        	<div id="top_nav">Navigation</div>
            <div id="middle_nav">
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>
            <a href="">Link 1</a>

            </div>
            <div id="bottom_nav"></div>
        </div>
    </div>
    -->
    <!-- /CONTENT **************************************************************************************************** --> 
    
    <!-- FOOTER ****************************************************************************************************** 
	<div id="footer"></div>
	<div id="bottom_content"></div>
	<div id="mirror"></div>
	<div id="credit"></div>--> 
  <!-- /FOOTER ***************************************************************************************************** --> 
    

</body>
</html>
