<%@ page language="java"%>
	<c:import url="/inc/header.jsp" />
	<c:import url="/inc/menu.jsp" />
<div><h1><c:out value="${ messages[0].discussion }"/></h1></div>

	<c:import url="/inc/messagesList.jsp" />
	<c:if test="${statut==true}">
		<br>
		<form method="post" action="<c:url value = "/NewMessage"/>">
			<div class="card border-primary">
				<div class="card-header text-white bg-primary mb-3">Ajouter un nouveau message</div>
		  		<div class="card-body">
		  			<div class="row">
		  				<label for="message">Message :</label>
						<textarea class="form-control" required rows="5" id="message" name="message"></textarea>			
					</div>
					<div class="row">
						<label for="login">Login :</label>
						<input type="text" required class="form-control" id="login" name="login">
					</div>
					<div class="row">
						<label for="mail">Email :</label>
						<input type="email" required class="form-control" id="mail" name="mail">	
					</div>
					<div class="row">
						<input type="submit" class="btn btn-success" value="valider">
					</div>
				</div>
			</div>
		</form>
	</c:if>
</body>
</html>