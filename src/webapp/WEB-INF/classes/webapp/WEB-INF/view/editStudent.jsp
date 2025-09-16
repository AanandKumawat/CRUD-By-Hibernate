<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>
<form action="updateStudent"method="post">
<input type="hidden" name="id" value="${student.id}"/>
 Name: <input type="text" name="name" value="${student.name}"/><br><br>
    Roll No: <input type="text" name="roll_no" value="${student.roll_no}"/><br><br>
    Branch: <input type="text" name="branch" value="${student.branch}"/><br><br>
    <input type="submit" value="Update"/>
</body>
</html>