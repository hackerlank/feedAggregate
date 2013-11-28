<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
                <c:if  test="${!empty iclListOfList}">
                	<c:set var="index" value="0" />
	                <div class="content_context" id="feed_view"> 
           				<div class="poster">
           					<a href="#">My Inventory</a>
           					<div id="middle-poster">
				                <c:forEach items="${iclListOfList}" var="iclList">
				                	<c:if  test="${!empty iclList}">
					                	<c:set var="index" value="${index+1}" />	                
					                	<ul class="nice-menu"><li class="red"><a class="slide-toggle-link" href="#" name="slide-inventory<c:out value="${index}"/>">${iclList.get(0).inventoryCategory.categoryName}</a></li></ul>
										<table id="mytable" class="inventory" name="slide-table-inventory<c:out value="${index}"/>" cellspacing="0">
											<tr>
		<%-- 									  <th scope="col" class="nobg">${iclList.get(0).inventoryCategory.categoryName}</th> --%>
											  <th scope="col" >Name</th>
											  <th scope="col" >Description</th>
											  <th scope="col" >Location</th>
											  <th scope="col" >Unit Price</th>
											  <th scope="col" >Cost</th>
											  <th scope="col" >Quantity</th>
											  								  										  										  
											</tr>	                 		
							               <c:forEach items="${iclList}" var="icl">						
												<tr>
												  <th scope="row" class="spec"><a href="editinventory/${icl.inventory.itemId}/edit.html">${icl.inventory.itemName}</a></th>
												  <td>${icl.inventory.itemDescription}</td>
												  <td>${icl.inventory.itemLocation}</td>
												  <td>${icl.inventory.itemUnitprice}</td>
												  <td>${icl.inventory.itemCost}</td>
												  <td>${icl.inventory.itemQuantity}</td>	
												  <td>
													<form action="disableinventory.html" method="POST">
													   <input type="hidden" value="${icl.inventory.itemId}" name="iId" />
													   <input type="submit" value="X" />
													</form>											  
												  </td>									  											  								  
												</tr>										
											</c:forEach>																				
										</table>
									</c:if>		
								</c:forEach>
							</div>
							
						</div>					
					</div>
				</c:if>  
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

