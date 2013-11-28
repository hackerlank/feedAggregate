<%@ include file="header.jsp" %>

<body>  
    <div id="header">    
		<%@ include file="top_nav.jsp" %>       
        <div id="body_section">
			<%@ include file="content.jsp" %>
				<c:if  test="${!empty taskList}">
	                <div class="content_context" id="task_view">					                 	
			                <c:forEach items="${taskList}" var="task">
								<div class="poster">
									<div class="channel_cat">
										<form:form action="deletetask.html" method="POST" commandName="task">
										   <input type="hidden" value="${task.taskId}" name="taskId" />
										   <input type="submit" value="X" />
										</form:form>
									</div>
									<div class="pub_date">${task.getEffectiveDate().getTime()}</div>
									<c:set var="length" value="${fn:length(task.title)}" />
									
									<c:choose>
										<c:when test="${length > 40}">
											<c:set var="substring" value="${fn:substring(task.title,0,70)}" />
											<a href="#"><c:out value="${substring}" />...</a>	
										</c:when>
										<c:otherwise>
											<a href="#">${task.title}</a>
										</c:otherwise>
									</c:choose>
									</br><div id="middle-poster">${task.description}</div>				
										
								</div>
							</c:forEach>											 								
	                </div>  
					<div class="content_context" id="task_new">	                
	                		<div class="poster">
								<a href="#">New Task</a>
								<div id="middle-poster">
									
									<form:form method="post" action="addtask.html" commandName="task">
										<table style="position:relative; top:-10px">
											<tr>										
												<td><form:label path="title"><spring:message code="label.tasktitle"/></form:label></td>
												<td><form:input path="title" />	</td>									
												<td><form:label path="description"><spring:message code="label.taskdescription"/></form:label></td>
												<td><form:input path="description" size="80"/></td>
											</tr>
											<tr>
												<td><form:label path="effectiveDate"><spring:message code="label.effectiveDate"/></form:label></td>
												<td><input name="eDate" path="effectiveDate" type="text" class="datepicker" />	</td>																											
												<td><input type="submit" value="<spring:message code="label.tasksubmit"/>"/></td>
											</tr>
										</table>
									</form:form>
									
								</div>
									
							</div>	
					</div>
                </c:if>
                <button id="closebutton">X</button>
        </div> 
   	</div>
   	
<%@ include file="footer.jsp" %>  

