
<div class="col col-lg-8">

	<div class="card">
		<div class="card-header">Update a Post</div>
		<div class="card-title message">
			<c:if test="${message!=null }">
				${message }
			</c:if>
		</div>
		<form class="form-signin" method="post" action="${contextRoot}/profile">
			<input type="hidden" name="user" value="${user.id }" />
			<input type="hidden" name="id" value="${postEdit.id }" />
			<input type="hidden" name="location" value="${postEdit.location.id }" />
			
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Write your post...</label>
				<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="text" >${postEdit.text }</textarea>
			</div>
	
			<div class="mb-3 form-check">
				<input checked="${postEdit.isPublicPost }" type="checkbox" class="form-check-input" id="exampleCheck1" name="isPublicPost">
				<label class="form-check-label" for="exampleCheck1">agree to public post...</label>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<br>
		</form>
	</div>
</div>
