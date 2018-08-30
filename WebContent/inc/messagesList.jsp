<div id="discussions">
	<ul class="list-group">
		<c:forEach var="item" items="${ messages }">
			<li class="list-group-item">
			<div class="row">
				<div class="col-2 auteur card">
					<h4>Auteur</h4>
					<p> 
						<c:out value="${ item.auteur.login }"/>
					</p> 
					<p>post� le 
					<c:out value="${ item.date }" /></p>
				</div>
				<div class="col-10 card-text">
					<p><c:out value="${ item.texte }" /></p>
				</div>
			</div>
			</li>
		</c:forEach>
	</ul>
</div>