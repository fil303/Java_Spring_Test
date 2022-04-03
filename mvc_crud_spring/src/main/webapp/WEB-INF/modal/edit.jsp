<%@ page language="java" contentType="text/html; charset=UTF-8"
   isELIgnored="false" pageEncoding="UTF-8" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form:form action="edit" method="POST" modelAttribute="emp2">
				<div class="modal-header">
					<h4 class="modal-title">Edit Employee</h4>
					<button type="button" class="dismiss close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<form:hidden path="id" value="${row.id}" />
				<div class="modal-body">
					<div class="form-group">
						<label>Name</label>
						<form:input type="text" path="name" value="${row.name}" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<form:input type="email" path="email" value="${row.email}" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label>Address</label>
						<form:textarea path="address" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label>Phone</label>
						<form:input type="text" path="phone" value="${row.phone}" cssClass="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="dismiss btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-info" value="Save">
				</div>
			</form:form>
		</div>
	</div>
</div>
<script>
    document.querySelectorAll(".dismiss").forEach(item=>{
        item.addEventListener("click",function(){
             document.getElementById("editEmployeeModal").remove();
        });
    });
</script>