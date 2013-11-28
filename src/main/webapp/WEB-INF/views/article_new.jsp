<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="paycheck_new">	                
	                		<div class="poster">
								<a href="#">New Article</a>
								<div id="middle-poster">
									
									<form:form method="post" action="addarticle.html" commandName="article">
									
										  <table id="editorELRTE">
											<tr>
												<td><form:label path="title"><spring:message code="label.articletitle"/></form:label></td>
												<td><form:input path="title" /></td> 
											</tr>										
											<tr>
												<td><form:label path="description"><spring:message code="label.articledescription"/></form:label></td>
												<td><form:textarea path="description" class="editor" /></td> 
											</tr>			
											<tr>
												<td><form:label path="feedCategory.categoryId">Category</form:label></td>
												<td><form:select path="feedCategory.categoryId">
													  <c:if  test="${!empty catList}">
													  	<c:forEach items="${catList}" var="category">
													  	  	<form:option value="${category.categoryId}" label="${category.feedChannel.getChannelName()} - ${category.getCategoryName()}" /> 
													  	</c:forEach>
													  </c:if>
												    </form:select>
								                </td>
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
													<input type="submit" value="<spring:message code="label.payCheckSubmit"/>"/>
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

