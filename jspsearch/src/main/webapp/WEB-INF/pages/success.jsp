<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>

        body{
            background: url("../../images/pinapple.jpg");
            background-repeat: no-repeat;
            background-size: 100% 8211%;


        }
        .container{
            position: absolute;
            top: -5%;
            left: 25%;
            color: #484242;
            font-size: 24px;
        }

        .container-re{

            position: absolute;
            top: 19%;
            left: 13%;
            color: #484242;
            font-size: 24px;

        }
        .btn:hover{
            background: #0393fa;
        }
        .btn{
            background: none;


            font-size: 24px;
          
        }
        .heading{
            color: #91c708;
        }

    </style>
</head>
<body>
<div class="container">
    <h1 class="heading"> Hello ${name}</h1>
    <H2 class="heading">Here is your Search Result for ${str} </H2>
</div>

<div class="container-re">
<ol>
    <c:forEach var="li" items="${list}">

       <a> <li>${li}</li> </a>
        <br>

    </c:forEach>
</ol>
    <form action="search">
        <button class="btn"> Search again </button>
    </form>
    </div>


</div>
</body>
</html>