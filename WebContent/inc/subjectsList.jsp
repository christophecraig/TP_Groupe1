<div id="subjects">
	<ul class="list-group">
		<c:forEach var="item" items="${ sujets }">
			<li class="list-group-item">
				<a href="/TP_Groupe1/Discussion?idSujet=<c:out value='${ item.id }' />">
				<c:out value="${ item.titre }" />
				</a>
			</li>
		</c:forEach>
	</ul>
</div>