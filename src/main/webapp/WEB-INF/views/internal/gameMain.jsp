<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<link href='<c:url value="/css/gamemain.css"/>' rel="stylesheet">
<title>Backgyammon Game</title>
</head>
<body>
<div id="whole">
<div class="dice" id="dice-pl2">
<svg xmlns="http://www.w3.org/2000/svg" id="${dice1SvgId}" width="${dice1SvgWidth}px" height="${dice1SvgHeight}px"
	viewbox="${dice1SvgOrigin[0]} ${dice1SvgOrigin[1]} ${dice1SvgSize[0]} ${dice1SvgSize[1]}">
	<c:forEach var="imageObject" items="${dice1SvgContext}">
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key == 'type'}">
				<${eachAttribute.value}
			</c:if>
		</c:forEach>
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key != 'type'}">
				${eachAttribute.key}="${eachAttribute.value}"
			</c:if>
		</c:forEach>
		/>
	</c:forEach>
</svg>
</div>
<div class="board">
<svg xmlns="http://www.w3.org/2000/svg" id="${boardSvgId}" width="${boardSvgWidth}px" height="${boardSvgHeight}px"
	viewbox="${boardSvgOrigin[0]} ${boardSvgOrigin[1]} ${boardSvgSize[0]} ${boardSvgSize[1]}">
	<c:forEach var="imageObject" items="${boardSvgContext}">
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key == 'type'}">
				<${eachAttribute.value}
			</c:if>
		</c:forEach>
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key != 'type'}">
				${eachAttribute.key}="${eachAttribute.value}"
			</c:if>
		</c:forEach>
		/>
	</c:forEach>
</svg>
</div>
<div class="dice">
<svg xmlns="http://www.w3.org/2000/svg" id="${dice2SvgId}" width="${dice2SvgWidth}px" height="${dice2SvgHeight}px"
	viewbox="${dice2SvgOrigin[0]} ${dice2SvgOrigin[1]} ${dice2SvgSize[0]} ${dice2SvgSize[1]}">
	<c:forEach var="imageObject" items="${dice2SvgContext}">
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key == 'type'}">
				<${eachAttribute.value}
			</c:if>
		</c:forEach>
		<c:forEach var="eachAttribute" items="${imageObject}">
			<c:if test="${eachAttribute.key != 'type'}">
				${eachAttribute.key}="${eachAttribute.value}"
			</c:if>
		</c:forEach>
		/>
	</c:forEach>
</svg>
</div>
</div>
</body>
</html>