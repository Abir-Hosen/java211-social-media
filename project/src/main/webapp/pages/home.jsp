
<div class="col col-lg-8">
	<c:forEach var="p" items="${allPosts}">
		<div class="card">
			<h6 class="card-header">User Name : ${p.user.name }</h6>
			<div class="card-body">
				<div class="card-title">Location : ${p.location.name }</div>
				<p class="card-text"><b>Posts : </b>${p.text }</p>
			</div>
		</div><br>
	</c:forEach>
</div>
