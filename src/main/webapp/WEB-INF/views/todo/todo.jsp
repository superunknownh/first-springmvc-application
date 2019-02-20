<%@ include file="../common/header.jspf" %>
<div class="container-fluid">
	<%@ include file="../common/navigation.jspf" %>
	<div class="row">
		<div class="col-md-12">
			<h2>Todo</h2>
			<form:form method="post" commandName="todo">
				<form:hidden path="id" />
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<form:label path="description">Description:</form:label>
							<form:input path="description" type="text" class="form-control" required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</div>
						<div class="form-group">
							<form:label path="targetDate">Target Date:</form:label>
							<form:input path="targetDate" type="text" class="form-control" required="required" />
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-12">
						<input type="submit" class="btn btn-success" value="Submit Todo" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
	
<%@ include file="../common/footer.jspf" %>
