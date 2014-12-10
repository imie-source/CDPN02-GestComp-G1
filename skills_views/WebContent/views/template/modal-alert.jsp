<%
	String jAlert = (String) session.getAttribute( "jAlert" );
	session.removeAttribute( "jAlert" );
%>
<div id="modal-alert" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title"><i class="fa fa-info-circle"></i> Information</h4>
      </div>
      <div class="modal-body">
        <p><%= jAlert %></p>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
	$('#modal-alert').modal('show');
</script>");