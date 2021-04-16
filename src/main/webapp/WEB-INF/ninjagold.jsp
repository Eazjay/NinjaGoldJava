<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>Ninja Gold</title>
</head>
<body>
	<div class="container mt-2">
        <div class="d-flex justify-content-between">
            <h4 class="bg-dark border rounded text-white mt-2 p-2 ms-3">Your Gold: <p class="text-warning">${totalGold}</p></h4>
            <form action="/reset" method="POST">
                <input type="submit" class="btn btn-info btn-lg me-3 mt-2" value="Play Again">
            </form>
        </div>
        <div class="container mt-3 d-flex justify-content-between">
            <div class="form-group">
                <form action="/processGold" method="post" class="border rounded text-center p-5 bg-secondary">
                    <div>
                        <h4 class="text-default">Farm<br>10-20 GOLD</h4>
                        <br><br>
                        <input type="hidden" name="place" value="farm">
                        <input type="submit" class="btn btn-warning btn-lg text-dark" value="Find Gold">
                    </div>
                </form>
            </div>
            <div class="form-group">
                <form action="/processGold" method="post" class="border rounded text-center p-5 bg-secondary">
                    <div>
                        <h4 class="text-default">Cave<br>5-10 GOLD</h4>
                        <br><br>
                        <input type="hidden" name="place" value="cave">
                        <input type="submit" class="btn btn-warning btn-lg text-dark" value="Find Gold">
                    </div>
                </form>
            </div>
            <form action="/processGold" method="post" class="border rounded text-center p-5 bg-secondary">
                <div>
                    <h4 class="text-default">House<br>2-5 GOLD</h4>
                    <br><br>
                    <input type="hidden" name="place" value="house">
                    <input type="submit" class="btn btn-warning btn-lg text-dark" value="Find Gold">
                </div>
            </form>
            <div class="form-group">
                <form action="/processGold" method="post" class="border rounded text-center p-5 bg-secondary">
                    <div>
                        <h4 class="text-default">Casino<br>(Earn/Lose)<br>0-50 GOLD</h4>
                        <br><br>
                        <input type="hidden" name="place" value="casino">
                        <input type="submit" class="btn btn-warning btn-lg" value="Find Gold">
                    </div>
                </form>
            </div>
        </div><!--form-container ends-->
        <br>
        <div class="row">
	         <h3 class="text-default ms-3">Activities:</h3>
	         <div class="log border border-primary p-2 ms-2">
	         	 <c:forEach items="${activities}" var="activity" varStatus="loop">
	   				<p class="text-success">${activity}</p>
	             </c:forEach>
	         </div>
        </div>
    </div>
</body>
</html>