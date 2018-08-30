<nav id="menu" class="navbar navbar-expand-lg">
	<ul class="navbar-nav">
		<li class="nav-item navbar-text"><a class="nav-link"  href="<c:url value="/Sujet"/>"><span class="oi oi-home"></span> Accueil</a></li>
		<c:if test="${ messages != null }">
			<li class="nav-item navbar-text"><a class="nav-link" href="<c:url value="/Discussion?idSujet=${ messages[0].idSujet }" />">
			Retour à la liste de discussions</a></li>
			<li class="nav-item navbar-text">
				<a class="nav-link" href="<c:url value="/Post"/>">Poster un nouveau message</a>
			</li>
		</c:if>
	</ul>
</nav>