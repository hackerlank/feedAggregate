<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
				<div class="content_context" id="feed_view"> 
                <c:if  test="${!empty vocabularyList}">
                	<c:set var="vocabId" value="0" />
                	<c:forEach items="${vocabularyList}" var="vocabulary">
                		<c:set var="vocabId" value="${vocabId+1}" />                	
						<div class="vocab_shuffle_front" id="front<c:out value="${vocabId}"/>">
							</br><h2>${vocabulary.term}</h2>
							<h3>[${vocabulary.pronoun}]</h3>
<!-- 							<a href="#"><img src="http://i41.tinypic.com/29giezt.jpg" height="35" width="150"></a> -->
							<a href="#" class="show" id="show<c:out value="${vocabId}"/>">Show</a>	
							<a href="#" class="shuffle" id="shuffle<c:out value="${vocabId}"/>">Shuffle</a>							
						</div>		
						<div class="vocab_shuffle_back" id="back<c:out value="${vocabId}"/>">
							</br><h2>${vocabulary.definition}</h2>
						</div>										
					</c:forEach>
				</c:if> 
				</div> 
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

