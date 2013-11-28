<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    
    <title>Vincent KO Center</title>

	<!-- CkEditor Style-->
	<link rel="stylesheet" type="text/css" media="screen" charset="utf-8" href="<c:url value='/static/ckeditor/contents.css'/>" />
	
	<!-- Main Theme -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/style/core_theme.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/style/table_style.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/style/nice_menu1.css'/>" />
    <link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
	 <script type="text/javascript" src="<c:url value='/static/js/feed_content_slidedown.js' /> "></script> 
	 
	<!-- ELRTE Editor -->
	<link rel="stylesheet" type="text/css" media="screen" charset="utf-8" href="<c:url value='/static/style/jquery-ui-1.8.13.custom.css'/>" />
	<link rel="stylesheet" type="text/css" media="screen" charset="utf-8" href="<c:url value='/static/style/elrte.min.css'/>" />
	<script src="<c:url value='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js' />" ></script>
	<script src="<c:url value='http://code.jquery.com/jquery-1.9.1.js' />" ></script>
	<script src="<c:url value='http://code.jquery.com/ui/1.10.3/jquery-ui.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/js/jquery-1.6.1.min.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/js/jquery-ui-1.8.13.custom.min.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/js/elrte.min.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/js/elrte.en.js' />" ></script>

    <!-- CkEditor -->
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/ckeditor/ckeditor.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/ckeditor/style.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/ckeditor/config.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/ckeditor/build-config.js' />" ></script>
	<script type="text/javascript" charset=UTF-8 src="<c:url value='/static/ckeditor/adapters/jquery.js' />" ></script>
    
    <%@ include file="vocabulary_shuffle_js.jsp" %>
    <%@ include file="inventory_slide_toggle_js.jsp" %>
    <script type="text/javascript" charset=UTF-8">
    	
		/*Transition between pages*/
/* 	    $(document).ready(function() {
	        $("body").css("display", "none");
	     
	        $("body").fadeIn(400);
	     
	        $("a").click(function(event){
	            event.preventDefault();
	            linkLocation = this.href;
	            $("body").fadeOut(700, redirectPage);     
	        });
	             
	        function redirectPage() {
	            window.location = linkLocation;
	        }
	    }); */

	    /* CLOSE CONTENT WHEN MOUSE AWAY */
/* 	    $(function() {
	  	 
	  	  $("#menu-wrap").mouseenter(function(){
		      	    	$("#body_section").fadeOut(1000);
		  });	 
	    
	  	  $("#menu-wrap").mouseleave(function(){
		      	    	$("#body_section").fadeIn(1000);
		  });
	    }); */

		/*Translate*/		
	    $().ready(function() {
	    	$( '#term' ).change(function() {
	    		$( '#term-translate' ).html($( '#term' ).val());
	    	});
	    });

	    /*Content Iframe*/
	    $().ready(function() {
	    	$("#content-iframe").hide();
	    	$( '.poster a' ).click(function(e) {
	    		e.preventDefault();
	    		$( '.channel_cat a' ).unbind('click');
		    	var src = $(this).attr("href");
	    		$("#content-iframe iframe").attr("src", src);
	    		$("#content-iframe").show();
	    	});
	    	$( '#close-iframe button' ).click(function(e) {
	    		$("#content-iframe").hide();
	    	});
	    });
	    
		/*CKEditor*/		
	    $().ready(function() {
	    	$( 'textarea.editor' ).ckeditor();
	    });		
	    
	    /*Editor*/
	    $().ready(function() {
	        var opts = {
	            lang         : 'en',   // set your language
	            styleWithCSS : 0,
	            height       : 200,
	            width		 : 720,
	            toolbar      : 'maxi'
	        };
	        // create editor
	        $('#editor').elrte(opts);

	        // or this way
	        // var editor = new elRTE(document.getElementById('our-element'), opts);
	    });
	    
	    /*Date Picker*/
	    $(function() {
	    	$( ".datepicker" ).datepicker();
	    	});

	    /*Event Reminder*/
	    $(function() {
	    	<c:if  test="${!empty eventList}">
	    		<c:forEach items="${eventList}" var="event">
	    			alert('Reminder: <c:out value="${event.title}" />');
	    		</c:forEach>
	    	</c:if>
	    	<c:if  test="${!empty eventEffectiveList}">
	    		<c:forEach items="${eventEffectiveList}" var="eventEffective">
	    			alert('Effective: <c:out value="${eventEffective.title}" />');
	    		</c:forEach>
    		</c:if>
	    });
    	   	   
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