<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
               <c:if  test="${!empty payCheckList}">
	                <div class="content_context" id="paycheck_view">
	                	<div class="poster">
	                		<div class="channel_cat"><a href="newpaycheck.html" style="text-decoration: none; color:#F90;">Add Paycheck</a></div>
	                 		<a href="#">Paycheck Statement</a>
								<div id="middle-poster">
									<table id="mytable" cellspacing="0">
										<caption>Paycheck Statment at MagnetStreet</caption>
										<tr>
										  <th scope="col" abbr="Bi-weekly Statement" class="nobg">Bi-weekly Statement</th>
										  <th scope="col" abbr="Net Pay">Net Pay</th>
										  <th scope="col" abbr="Salary">Salary</th>
										  <th scope="col" abbr="Taxes">Taxes</th>
										  <th scope="col" abbr="Federal Withhold">Federal Withhold</th>
										  <th scope="col" abbr="Social Security">Social Security</th>
										  <th scope="col" abbr="State Withhold">State Withhold</th>	
										  <th scope="col" abbr="Medicare">Medi-</br>care</th>
										  <th scope="col" abbr="Deduction">Deduc-</br>tion</th>	
										  <th scope="col" abbr="Date">Date</th>											  								  										  										  
										</tr>	                 		
						                <c:forEach items="${payCheckList}" var="payCheck">							
											<tr>
											  <th scope="row" class="spec">${payCheck.title}</th>
											  <td>${payCheck.netPay}</td>
											  <td>${payCheck.salary}</td>
											  <td>${payCheck.taxes}</td>
											  <td>${payCheck.ferderalWithhold}</td>
											  <td>${payCheck.socialSecurity}</td>
											  <td>${payCheck.stateWithhold}</td>
											  <td>${payCheck.medicare}</td>											  			
											  <td>${payCheck.deduction}</td>	
											  <td>${payCheck.pubDate.getTime()}</td>											  											  								  
											</tr>
										</c:forEach>
										<tr>
										  <th scope="row" class="spec">Total</th>
										  <td>${netPay}</td>
										  <td>${salary}</td>
										  <td>${taxes}</td>
										  <td>${ferderalWithhold}</td>
										  <td>${socialSecurity}</td>
										  <td>${stateWithhold}</td>	
										  <td>${medicare}</td>										  		
										  <td>${deduction}</td>	
										  <td>___________</td>											  											  								  
										</tr>																				
									</table>
								</div>				
																
						</div>					
					</div>
				</c:if>
				<c:if  test="${payCheckNew == '1'}">
					<div class="content_context" id="paycheck_new">	                
	                		<div class="poster">
								<a href="#"><spring:message code="label.paychecknew"/></a>
								<div id="middle-poster">
									
									<form:form method="post" action="addpaycheck.html" commandName="paycheck">
									
										<table>
											<tr>
												<td><form:label path="title"><spring:message code="label.paychecktitle"/></form:label></td>
												<td><form:input path="title" /></td> 
											</tr>										
											<tr>
												<td><form:label path="salary"><spring:message code="label.salary"/></form:label></td>
												<td><form:input path="salary" /></td> 
											</tr>
											<tr>
												<td><form:label path="ferderalWithhold"><spring:message code="label.ferderalWithhold"/></form:label></td>
												<td><form:input path="ferderalWithhold" /></td>
											</tr>
											<tr>
												<td><form:label path="socialSecurity"><spring:message code="label.socialSecurity"/></form:label></td>
												<td><form:input path="socialSecurity" /></td>
											</tr>
											<tr>
												<td><form:label path="medicare"><spring:message code="label.medicare"/></form:label></td>
												<td><form:input path="medicare" /></td>
											</tr>
											<tr>
												<td><form:label path="stateWithhold"><spring:message code="label.stateWithhold"/></form:label></td>
												<td><form:input path="stateWithhold" /></td>
											</tr>
											<tr>
												<td><form:label path="deduction"><spring:message code="label.deduction"/></form:label></td>
												<td><form:input path="deduction" /></td>
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
				</c:if>				                  
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

