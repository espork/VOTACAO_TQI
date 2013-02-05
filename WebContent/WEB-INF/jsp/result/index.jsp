<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="THEME_DIR" value="${pageContext.request.contextPath}/resources/css"/>
<c:set var="IMG_DIR" value="${pageContext.request.contextPath}/resources/img"/>

<html lang="pt" >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><fmt:message key="title" /></title>
		<link rel="stylesheet" type="text/css" href="${THEME_DIR}/bootstrap.min.css"/>	
		
	</head>
	
	<body>
	
	<div class="navbar">
      <div class="navbar-inner">
        <div class="container">
          
          <a href="#" class="brand"><img src="${IMG_DIR}/mascote.jpg" class="img-rounded"/></a>
          <p style="font-size: 26px;line-height: 90px;" ><fmt:message key="title" /></p>
			
        </div>
      </div>
    </div>
	
	<div class="container">
	
			
			<c:if test="${not empty message }">
				    <div class="alert alert-success">
    					<fmt:message key="${message}" />
    				</div>
			</c:if>
		

		
	
		<div class="row">
			<div class="span6">
			
				<fieldset >
					<legend><fmt:message key="result.legend" /></legend>
					
					<c:forEach items="${result.items}" var="item">
					
						<div class="row">
						
							<div class="span2">
								${item.name}
							</div>
							
							<div class="span3">
								${item.value}%
							</div>
							
						</div>
						<div class="row">&nbsp;</div>
					
					</c:forEach>
					
				</fieldset>
				
			</div>
			
		</div>
       	
	</div>
		
		
	</body>
</html>