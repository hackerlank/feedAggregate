<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="feed_channel_new">	                
	                		<div class="poster">
								<a href="#">New Feed Channel</a>
								<div id="middle-poster">
									
								<form:form method="post" action="addfeedchannel.html" commandName="channel">
									
										<table id="editorELRTE">
											<tr>
												<td><form:label path="channelName">Channel Name</form:label></td>
												<td><form:input path="channelName" /></td> 
											</tr>																																									
											<tr>
												<td colspan="2">
													<input type="submit" value="Add"/>
												</td>
											</tr>
										</table>	
									</form:form>
									
								</div>
									
							</div>	
					</div>
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

