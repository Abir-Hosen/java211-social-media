
<div class="col col-lg-5">
	<div class="card">
		<div class="card-header">Login Here</div>
		<div class="card-title message">
			<c:if test="${message!=null }">
				${message }
			</c:if>
		</div>

		<form class="form-signin" method="post" action="${contextRoot}/login">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input name="email" type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input name="password" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</div>
