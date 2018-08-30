<div id="subjects">
	<ul class="list-group">
		<c:forEach var="item" items="${ sujets }">
			<li class="list-group-item">
				<a href="<c:url value="/Discussion?idSujet=${ item.id }" />">
				<c:out value="${ item.titre }" />
				</a>
			</li>
		</c:forEach>
	</ul>
</div>