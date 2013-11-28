<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
                <c:if  test="${!empty articleList}">
	                <div class="content_context" id="feed_view">                 	
			                <c:forEach items="${articleList}" var="article">
								<div class="poster">
									<div class="channel_cat">
										<form:form action="deletearticle.html" method="POST" commandName="article">
										   <input type="hidden" value="${article.articleId}" name="articleId" />
										   <input type="submit" value="X" />
										</form:form>
									</div>								
									<div class="pub_date">${article.getPubDate().getTime()}</div>
									<c:set var="length" value="${fn:length(article.title)}" />
									
									<c:choose>
										<c:when test="${length > 40}">
											<c:set var="substring" value="${fn:substring(article.title,0,70)}" />
											<a href="#"><c:out value="${substring}" />...</a>	
										</c:when>
										<c:otherwise>
											<a href="#">${article.title}</a>
										</c:otherwise>
									</c:choose>
									</br><div id="middle-poster">${article.description}</div>				
										
								</div>
							</c:forEach>						
					</div>
				</c:if>  
        </div> 
   	</div>
   	<div id="content-iframe">
   		<iframe width="1250px" height="550px"></iframe> 
   		<div id = "close-iframe"><button>Close</button></div>
   	</div>
	  	
<%@ include file="footer.jsp" %>  
 
  	<div id="filter">
		<jsp:useBean id="now" class="java.util.Date" />
		<form method="post" action="filterarticles.html">		
			<table>
				<tr>
					<td>Category: </td>
					<td colspan="3"><select name="catId">
						  <c:if  test="${!empty catList}">
						  	<c:forEach items="${catList}" var="category">
						  	  	<option value="${category.categoryId}">${category.feedChannel.getChannelName()} - ${category.getCategoryName()} </option> 
						  	</c:forEach>
						  </c:if>
					   </select> 
	                </td>
				</tr>
				<tr>
					<td>Start Date: </td>
					<td><input name="startDate" type="text" class="datepicker"  />	</td>
				</tr>
				<tr>
					<td>End Date: </td>
					<td><input name="endDate" type="text" class="datepicker"  />	</td>				
				</tr>
				<tr>
					<td>Limit: </td>
					<td>
						<select name="limit">
							<option value="50">50</option>
							<option value="100">100</option>
							<option value="200">200</option>
							<option value="200">500</option>
							<option value="200">1000</option>
						</select>
					</td>			
				</tr>				
				<tr><td><input type="submit" value="Submit"/></td></tr>
			</table>																					
		</form>
	</div>
  </body>
</html>