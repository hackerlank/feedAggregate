<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="feed_category_new">	                
	                		<div class="poster">
								<a href="#">New Feed Category</a>
								<div id="middle-poster">
									
								<form:form method="post" action="addfeedcategory.html" commandName="category">
									
										<table id="editorELRTE">
											<tr>
												<td><form:label path="categoryName">Category Name</form:label></td>
												<td><form:input path="categoryName" /></td> 
											</tr>	
											<tr>
												<td><form:label path="fileName">File Name</form:label></td>
												<td><form:input path="fileName" /></td> 
											</tr>												
											<tr>
												<td><form:label path="feedChannel.channelId">Channel</form:label></td>
												<td><form:select path="feedChannel.channelId">
													  <c:if  test="${!empty chList}">
													  	<c:forEach items="${chList}" var="channel">
													  	  	<form:option value="${channel.channelId}" label="${channel.getChannelName()}" /> 
													  	</c:forEach>
													  </c:if>
												    </form:select>
								                </td>
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

