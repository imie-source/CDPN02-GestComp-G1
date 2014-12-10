<% String curPage = (String) session.getAttribute( "curPage" ); %>
<!-- Static navbar -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard" title="Dashboard">Gestion des compétences</a>
	    </div>
		<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
	        <li class="<%= curPage == "dashboard" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/dashboard" title="Dashboard">Dashboard</a></li>
	        <li class="<%= curPage == "task" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/task-list" title="Tâches">Tâches</a></li>
	        <li class="<%= curPage == "project" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/project-list" title="Projets">Projets</a></li>
			<li class="<%= curPage == "member" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/member-list" title="Membres">Membres</a></li>
			<li class="<%= curPage == "skills" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/skill-list" title="Compétences">Compétences</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form class="navbar-form" role="search" method="get" id="search_form" name="search_form">
			        <div class="input-group">
			            <input type="text" class="form-control" placeholder="Recherche..." id="search_value" name="search_value" value="">
				        <div class="input-group-btn">
				            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
				    	</div>
			        </div>
		        </form>
			</li>
			<li class="dropdown <%= curPage == "account" ? "active" : "" %>">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-cog"></i>&nbsp;</a>
              <ul class="dropdown-menu" role="menu">
                <li class="<%= curPage == "account" ? "active" : "" %>"><a href="${pageContext.request.contextPath}/account">Mon compte</a></li>
                <li><a href="${pageContext.request.contextPath}/account">Mes tâches</a></li>
                <li><a href="${pageContext.request.contextPath}/account">Mes projets</a></li>
              </ul>
            </li>
		</ul>
	    </div><!--/.nav-collapse -->
	</div><!--/.container-fluid -->
</nav>