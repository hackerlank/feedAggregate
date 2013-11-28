<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
                <c:if  test="${!empty vocabularyList}">
	                <div class="content_context" id="feed_view">                 	
			                <c:forEach items="${vocabularyList}" var="vocabulary">
								<div class="poster">
									<div class="channel_cat">
										<form:form action="deletevocabulary.html" method="POST" commandName="vocabulary">
										   <input type="hidden" value="${vocabulary.vocabId}" name="vocabId" />
										   <input type="submit" value="X" />
										</form:form>
									</div>								
									<div class="pub_date">${vocabulary.getPubDate().getTime()}</div>
									<c:set var="length" value="${fn:length(vocabulary.term)}" />
									
									<c:choose>
										<c:when test="${length > 40}">
											<c:set var="substring" value="${fn:substring(vocabulary.title,0,70)}" />
											<a href="#"><c:out value="${substring}" />...</a>	
										</c:when>
										<c:otherwise>
											<a href="#">${vocabulary.term} - [${vocabulary.pronoun}]</a>
										</c:otherwise>
									</c:choose>
									</br><div id="middle-poster">${vocabulary.definition}</div>				
										
								</div>
							</c:forEach>						
					</div>
				</c:if>  
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

