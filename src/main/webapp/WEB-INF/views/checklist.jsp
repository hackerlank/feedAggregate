<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
	                <div class="content_context" id="feed_view">                 	
								<div class="poster">							
									<div class="pub_date">${article.getPubDate().getTime()}</div>
									<a href="#">Checklist of The Week</a>
										<iframe src="https://skydrive.live.com/embed?cid=FEF3DDE627EB1A5B&resid=FEF3DDE627EB1A5B%21449&authkey=ACmZCTpOT3nPXUw&em=2" width="840" height="460" frameborder="0" scrolling="no"></iframe>
									</br><div id="middle-poster">
										
									</div>				
										
								</div>						
					</div>
        </div> 
   	</div>

	  	
<%@ include file="footer.jsp" %>  
 
