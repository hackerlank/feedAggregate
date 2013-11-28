<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="vocabulary_category_new">	                
	                		<div class="poster">
								<a href="#">New Vocabulary Category</a>
								<div id="middle-poster">
									
								<form:form method="post" action="addvocabularycategory.html" commandName="vocabularycategory">
									
										<table id="editorELRTE">
											<tr>
												<td><form:label path="categoryName">Category Name</form:label></td>
												<td><form:input path="categoryName" /></td> 
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

