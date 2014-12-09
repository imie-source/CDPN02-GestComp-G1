<%@ page import="fr.skills.serviceEJB.impl.PersonDTO" %>
<%@ page import="java.util.List" %>

<% List<PersonDTO> memberList = (List<PersonDTO>) session.getAttribute("memberList"); %>

<table class="table table-striped table-hover table-condensed">
	<% for(PersonDTO member : memberList){ %>
		<tr>
			<td><%= member.getName() %></td>
			<td><%= member.getDescription() %></td>
			<td><%= member.getStatus() %></td>
		</tr>
	<% } %>
</table>