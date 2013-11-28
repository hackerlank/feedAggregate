<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="paycheck_new">	                
	                		<div class="poster">
								<a href="#">New Vocabulary</a>
								<div id="middle-poster">
									
								<form:form method="post" action="addvocabulary.html" commandName="vocabulary">
									
										<table id="editorELRTE">
											<tr>
												<td><form:label path="term">Term</form:label></td>
												<td><form:input path="term" id="term"/></td> 
												<td width="70%"><div id="term-translate">Translate: </div></td>
															
												
											</tr>										
											<tr>
												<td><form:label path="pronoun">Pronoun</form:label></td>
												<td><form:input path="pronoun" /></td> 
											</tr>
											<tr>
												<td><form:label path="definition">Definition</form:label></td>
												<td colspan="3"><form:textarea path="definition" class="editor" /></td>
											</tr>
											<tr>
												<td><form:label path="vocabularyCategory.categoryId">Category</form:label></td>
												<td><form:select path="vocabularyCategory.categoryId">
													  <c:if  test="${!empty catList}">
													  	<c:forEach items="${catList}" var="category">
													  	  	<form:option value="${category.categoryId}" label="${category.getCategoryName()}" /> 
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

