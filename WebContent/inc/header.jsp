<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Forum - 
		<c:choose>
			<c:when test="${ param.subjectName != null }">Discussions sur "${ param.subjectName }"</c:when>
			<c:when test="${ param.discussionName != null }">${ param.discussionName }</c:when>
			<c:otherwise>Accueil</c:otherwise>
		</c:choose>
	</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value='/inc/style.css'/>" />
	<link rel="stylesheet" href="<c:url value='/inc/open-iconic-bootstrap.min.css'/>" />
</head>
<body>
<div class="container-fluid">