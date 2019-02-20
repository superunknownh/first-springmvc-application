<%@ include file="./common/header.jspf" %>
<div class="container-fluid">
	<%@ include file="./common/navigation.jspf" %>
	<div class="row">
		<div class="col-md-12">
			<h2>Dashboard</h2>
			<p>Welcome back <strong>${username}</strong>!</p>
			<div class="row">
				<div class="col-md-3" style="background-color:lime;height:100px;text-align:center;line-height:100px;margin:15px">
					<a href="/first-springmvc-application/list-todos" style="display: block">Manage my Todos</a>
				</div>
			</div>
		</div>
	</div>
</div>
	
<%@ include file="./common/footer.jspf" %>
