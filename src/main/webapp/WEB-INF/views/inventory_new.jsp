<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
					<div class="content_context" id="paycheck_new">	                
	                		<div class="poster">
								<a href="#">New Inventory</a>
								<div id="middle-poster">
									
									<form:form method="post" action="addinventory.html" commandName="inventory">
									
										  <table id="editorELRTE">
											<tr>
												<td><form:label path="itemName">Name</form:label></td>
												<td><form:input path="itemName" /></td> 
											</tr>										
											<tr>
												<td><form:label path="itemDescription">Description</form:label></td>
												<td><form:textarea path="itemDescription" class="editor" /></td> 
											</tr>	
											<tr>
												<td><form:label path="itemLocation">Location</form:label></td>
												<td><form:input path="itemLocation" /></td> 
											</tr>		
											<tr>
												<td><form:label path="itemUnitprice">Unit Price</form:label></td>
												<td><form:input path="itemUnitprice" /></td> 
											</tr>
											<tr>
												<td><form:label path="itemCost">Cost</form:label></td>
												<td><form:input path="itemCost" /></td> 
											</tr>
											<tr>
												<td><form:label path="itemQuantity">Quantity</form:label></td>
												<td><form:input path="itemQuantity" /></td> 
											</tr>																																																								
											<tr>
												<td>Category</td>
												<td>
												  <c:if  test="${!empty catList}">
													  <select name="catId">
													  	<c:forEach items="${catList}" var="category">
													  	  	<option value="${category.categoryId}">${category.getCategoryName()}</option>
													  	</c:forEach>
													  </select>
												  </c:if>
												   
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

