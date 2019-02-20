<%@ include file="./common/header.jspf" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="text-center">
				<h1>Todo Service</h1>
				<h2>Login Page</h2>
				<br />
				<form action="/login" method="post">
					<p style="color:red">${errorMessage}</p>
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="form-group">
								<input type="text" name="username" class="form-control" placeholder="Username" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="form-group">
								<input type="password" name="password" class="form-control" placeholder="Password" />
							</div>
						</div>
					</div>
					<br />
					<input type="submit" value="Login" class="btn btn-success btn-lg" />
				</form>
			</div>
		</div>
	</div>
</div>
	
<%@ include file="./common/footer.jspf" %>
