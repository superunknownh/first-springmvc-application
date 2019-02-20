<%@ include file="../common/header.jspf" %>
<div class="container-fluid">
	<%@ include file="../common/navigation.jspf" %>
	<div class="row">
		<div class="col-md-12">
			<h2><spring:message code="list.todos.caption" /></h2>
			<div class="text-right">
				<a href="/first-springmvc-application/add-todo" class="btn btn-success">Add a new Todo</a>
			</div>
			<br />
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Completed?</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.getDescription()}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.getTargetDate()}" /></td>
							<td>${todo.isDone()? "Yes" : "No"}</td>
							<td>
								<a class="btn btn-warning" href="/first-springmvc-application/update-todo?id=${todo.getId()}">Update</a>
								<a class="btn btn-danger" href="/first-springmvc-application/delete-todo?id=${todo.getId()}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jspf" %>
