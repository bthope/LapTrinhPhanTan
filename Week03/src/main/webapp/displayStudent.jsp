<%--
  Created by IntelliJ IDEA.
  User: BANG
  Date: 9/12/2024
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
<h2>Student Information</h2>
<table>
    <tr>
        <th>First Name</th>
        <td>${student.firstName}</td>
    </tr>
    <tr>
        <th>Last Name</th>
        <td>${student.lastName}</td>
    </tr>
    <tr>
        <th>Date of Birth</th>
        <td>${student.dob}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${student.email}</td>
    </tr>
    <tr>
        <th>Mobile Number</th>
        <td>${student.mobileNumber}</td>
    </tr>
    <tr>
        <th>Gender</th>
        <td>${student.gender}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${student.address}</td>
    </tr>
    <tr>
        <th>City</th>
        <td>${student.city}</td>
    </tr>
    <tr>
        <th>Pin Code</th>
        <td>${student.pinCode}</td>
    </tr>
    <tr>
        <th>State</th>
        <td>${student.state}</td>
    </tr>
    <tr>
        <th>Country</th>
        <td>${student.country}</td>
    </tr>
    <tr>
        <th>Hobbies</th>
        <td>
            <c:forEach items="${student.hobbies}" var="hobby">
                ${hobby}<br/>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <th>Course Applied For</th>
        <td>${student.courseApplies}</td>
    </tr>
</table>

<h2>Qualifications</h2>
<table>
    <tr>
        <th>Examination</th>
        <th>Board</th>
        <th>Percentage</th>
        <th>Year of Passing</th>
    </tr>
    <c:forEach var="qualification" items="${student.qualifications}">
        <tr>
            <td>${qualification[0]}</td>
            <td>${qualification[1]}</td>
            <td>${qualification[2]}</td>
            <td>${qualification[3]}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

