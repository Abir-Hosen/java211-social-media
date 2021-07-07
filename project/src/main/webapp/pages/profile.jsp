<div class="col col-lg-3">
	<div class="card">
		<div class="card-header">Name : ${user.name }</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Email : ${user.email }</li>
		</ul>
	</div>
</div>

<div class="col col-lg-5">


	<div class="card">
		<div class="card-header">Create a Post</div>
		<div class="card-title message">
			<c:if test="${message!=null }">
				${message }
			</c:if>
		</div>
		<form class="form-signin" method="post" action="${contextRoot}/profile">
			<input type="hidden" name="user" value="${user.id }" />
			<div class="mb-3">
				<select class="form-select" aria-label="Default select example" name="location">
					<option selected>Select Location</option>
					<c:forEach var="i" items="${locations}">
						<option value="${i.id}">${i.name}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Write your post...</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"	rows="3" name="text" ></textarea>
			</div>
	
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1" name="isPublicPost">
				<label class="form-check-label" for="exampleCheck1">agree to public post...</label>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<br>
		</form>
	</div>


	<br> <br>
	<c:forEach var="p" items="${userPosts}">
		<div class="card">
			<h6 class="card-header">User Name : ${p.user.name }</h6>
			<div class="card-body">
				<div class="card-title">Location : ${p.location.name }</div>
				<p class="card-text"><b>Posts : </b>${p.text }</p>
			</div>
			<a href="${contextRoot}/edit?id=${p.id }" class="btn btn-link">Edit</a>
		</div>
		<br>
	</c:forEach>
</div>
