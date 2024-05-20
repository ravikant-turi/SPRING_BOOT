<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<link  href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="styleSheet">
<title>jsp</title>
<style>

</style>
</head>
<body>
<%@ include file="common/navigation.jspf"   %>
<div class="container">
	
	<div><h1>Welcome to todo Application</h1></div>


	<table class="table" >
		<thead>

			<tr>
				
				<th>Description</th>
				<th>Target Date</th>
				<th>is Done?</th>
                 <th>Delete</th> 
                 <th>Update</th>

			</tr>
		</thead>
      <tbody>

	

	<c:forEach items="${todos}" var="todo">
     <tr>
          
          <th>${todo.description}</th>
           <th>${todo.targetData}</th>
          <th>${todo.done}</th>
          <th><a href="delete-todo?id=${todo.id}" class="btn btn-warning"> DELETE ${todo.id}</a></th>
           <th><a href="update-todo?id=${todo.id}" class="btn btn-success">Update ${todo.id}</a></th>
           
     </tr>
</c:forEach>
</tbody>
</table>

<a href="add-todo" class="btn btn-success">Add Todo</a>

</div>
 <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
 
</body>
</html>