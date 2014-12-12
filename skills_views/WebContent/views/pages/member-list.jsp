<%@ page import="fr.skills.serviceEJB.impl.PersonDTO" %>
<%@ page import="java.util.List" %>
<% List<PersonDTO> memberList = (List<PersonDTO>) session.getAttribute( "memberList" ); %>

<%-- <% List<PersonDTO> memberList = (List<PersonDTO>) session.getAttribute("memberList"); %> --%>
<h1>Liste des membres <small>Espace de gestion</small></h1>

<form role="form" action="${pageContext.request.contextPath}/member-list" method="POST">
	<table class="table table-striped table-hover table-condensed">
		<thead>
			<tr>
				<td class="select"></td>
				<td class="name">Nom</td>
				<td class="desc">Description</td>
				<td class="dispo">Disponibilité</td>
				<td class="actions" colspan="2">Actions</td>
			</tr>
		</thead>
		<tbody>
			<% for(PersonDTO member : memberList){
				String status = member.getStatus() ? "fa-angellist text-success" : "fa-ban text-warning"; %>
				<tr>
					<td class="select"><input type="checkbox" name="member_id" value="<%= member.getId() %>" /></td>
					<td class="name"><%= member.getName() %></td>
					<td class="desc"><%= member.getDescription() %></td>
					<td class="dispo"><i class="fa <%= status %>"></i></td>
					<td class="edit"><a href="#" title="Modifier"><i class="fa fa-wrench"></i></a></td>
					<td class="delete"><a href="#" title="Supprimer"><input type="hidden" value="<%= member.getId() %>"><i class="fa fa-times"></i></a></td>
				</tr>	
			<% } %>
		</tbody>
	</table>
	<button id="member_delete" type="submit" class="btn btn-danger"><i class="fa fa-arrow-up"></i> Supprimer les lignes selectionnées</button>
</form>

<!-- Button trigger modal -->
<button id="member_add" type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
  <i class="fa fa-plus-square"></i> Ajouter un membre
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
      		<div id="member-add_form">
				<form class="form-signin" role="form">
					<h2 class="form-signin-heading">Ajouter un membre</h2>
					
					<label for="inputLogin" class="sr-only">Login</label>
					<input type="text" id="inputLogin" class="form-control" placeholder="Login" title="Login" required autofocus>
					
					<label for="inputEmail" class="sr-only">Adresse email</label>
					<input type="email" id="inputEmail" class="form-control" placeholder="Adresse email" title="Adresse email" required autofocus>
					
					<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" id="inputPassword" class="form-control" placeholder="Password" title="Password" required>
					<div class="checkbox">
					  <label>
					  	<input type="checkbox" value="remember_me"> Se souvenir de moi
					  </label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
				</form>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">	
	<!--
	$(".delete a").click(function(e){
		e.preventDefault();
		var id = $(this).children('input').attr('value');
		$.ajax({
			type: 'POST',
			url: '${pageContext.request.contextPath}/member-list',
			data : {
				'id': id,
				'order': "delete"
			},
			success: function(data){
				location.reload();
            }
		});
	});
	-->
</script>