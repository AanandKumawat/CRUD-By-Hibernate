<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My JSP Page</title>
</head>
<body>

   <form action="submit_form" method="post">
         <input type="text" name="id" placeholder="Enter student id" ><br><br>
         <input type="text" name="name" placeholder="Enter student name" ><br><br>
         <input type="text" name="roll_no" placeholder="Enter student roll_no" ><br><br>
         <input type="text" name="branch" placeholder="Enter student branch" ><br><br>


         <input type="submit" value="submit">
         <input type="submit" value="viewAllStudent" formaction="getAllStudents" formmethod="get">
     </form>
</body>
</html>
