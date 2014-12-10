<%-- <%@ page import="fr.skills.serviceEJB.impl.PersonDTO" %> --%>
<%-- <%@ page import="java.util.List" %> --%>

<%-- <% List<PersonDTO> memberList = (List<PersonDTO>) session.getAttribute("memberList"); %> --%>
<h1>Liste des membres <small>Espace de gestion</small></h1>

<form role="form" action="" method="POST">
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
			<tr>
				<td class="select"><input type="checkbox" name="" /></td>
				<td class="name">Arthur LORENT</td>
				<td class="desc">Description</td>
				<td class="dispo"><i class="fa fa-angellist text-success"></i></td>
				<td class="edit"><a href="#" title="Modifier"><i class="fa fa-wrench"></i></a></td>
				<td class="delete"><a href="#" title="Supprimer"><i class="fa fa-times"></i></a></td>
			</tr>
			<tr>
				<td class="select"><input type="checkbox" name="" /></td>
				<td class="name">Arthur LORENT</td>
				<td class="desc">Description</td>
				<td class="dispo"><i class="fa fa-ban text-warning"></i></td>
				<td class="edit"><a href="#" title="Modifier"><i class="fa fa-wrench"></i></a></td>
				<td class="delete"><a href="#" title="Supprimer"><i class="fa fa-times"></i></a></td>
			</tr>
		</tbody>
	</table>
</form>