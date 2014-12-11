<%
if(session.getAttribute("jConfirm") != null){
	String jConfirm = (String) session.getAttribute( "jConfirm" );
	session.removeAttribute( "jConfirm" );
	%>
	<div id="modal-confirm" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title"><i class="fa fa-exclamation-triangle"></i> Attention</h4>
	      </div>
	      <div class="modal-body">
	        <p><%= jConfirm %></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary">Confirmer</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<script type="text/javascript">
		<!--
			$('#modal-confirm').modal('show');
		-->
	</script>
<% } %>