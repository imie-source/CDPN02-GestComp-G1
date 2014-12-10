<%
	String jAlert = (String) session.getAttribute( "jAlert" );
	session.removeAttribute( "jAlert" );
%>
<div id="modal-alert" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      	<%= jAlert %>
    </div>
  </div>
</div>

<script type="text/javascript">
	$('#modal-alert').modal('show');
</script>");