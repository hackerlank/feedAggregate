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
									<div class="channel_cat">${feed.feedChannel.channelName} - ${feed.feedCategory.categoryName}</div>
									<div class="pub_date">${feed.getPubDateConverted().getTime()}</div>
									<c:set var="length" value="${fn:length(feed.title)}" />
									
									<c:choose>
										<c:when test="${length > 40}">
											<c:set var="substring" value="${fn:substring(feed.title,0,70)}" />
											<a href="${feed.guid}"><c:out value="${substring}" />...</a>	
										</c:when>
										<c:otherwise>
											<a href="${feed.guid}">${feed.title}</a>
										</c:otherwise>
									</c:choose>
									</br><div id="middle-poster">${feed.description}</div>				
										
								</div>
							</c:forEach>						
					</div>
				</c:if>  
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

