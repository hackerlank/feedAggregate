<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
                <c:if  test="${!empty feedList}">
	                <div class="content_context" id="feed_view">                 	
			                <c:forEach items="${feedList}" var="feed">
								<div class="poster">
									<div class="channel_cat">${feed.feedChannel.channelName} - ${feed.feedCategory.categoryName}<a href="addfavorite/${feed.getItemId()}/add.html"><img src="http://i40.tinypic.com/10pumno.jpg" alt="favorite" height="25" width="25"> </a></div>
									<div class="pub_date">${feed.getPubDateConverted().getTime()}</div>
									<c:set var="length" value="${fn:length(feed.title)}" />
									
									<c:choose>
										<c:when test="${length > 40}">
											<c:set var="substring" value="${fn:substring(feed.title,0,50)}" />
											<a href="${feed.guid}"><c:out value="${substring}" />...</a>	
										</c:when>
										<c:otherwise>
											<a href="${feed.guid}">${feed.title}</a>
										</c:otherwise>
									</c:choose>
									</br><div id="middle-poster"><a href="${feed.guid}">Read more...</a></div>				 
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
		<form method="post" action="filterfeeds.html">		
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
							<option value="10">10</option>
							<option value="25">25</option>						
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