<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Students</title>
</head>
<body>
<h2>Student List</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Roll No</th>
        <th>Branch</th>
    </tr>

    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/> </td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.roll_no}"/></td>
            <td><c:out value="${student.branch}"/></td>
            <td>
            <form action="updateStudentButton" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${student.id}"/>
                                <input type="submit" value="Update"/>
                            </form>

                            <form action="deleteStudentButton" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${student.id}"/>
                                <input type="submit" value="Delete"/>
                            </form>
                            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
