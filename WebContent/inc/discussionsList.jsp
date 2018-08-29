<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="discussions">
	<ul class="list-group">
		<c:forEach var="item" items="${ discussions }">
			<li class="list-group-item">
				<a href="/TP_Groupe1/Message?idDiscussion=<c:out value='${ item.id }' />">
				<c:out value="${ item.titre }" />
				</a> 
				par <c:out value="${ item.auteur.nom }" />
				le <c:out value="${ item.dateCreation }" />
				- <c:out value="${ fn:length(discussions) }" /> messages
			<c:if test="${ item.statut != 'true' }"> 
<div class="float-right"><span class="oi oi-lock-locked"></span></div>
</c:if>
			</li>
		</c:forEach>
	</ul>
</div>