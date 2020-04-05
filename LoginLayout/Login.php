<?php
	$con=mysqli_connect("localhost", skawns27, "skawnstjq27!, skawns27);
	$userID=$_POST["userID];
	$userPassword=$_POST["userPassword"];

	$statement=mysqli_prepare($con, "SELECT * FROM USER WHERE userID=? AND userPassword=?");
	mysqli_stmt_bind_param($statement, "ss", $userId, $userPassword);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statment, $userID, $userPasswrod, $userName,
	$userAge);

	$response=array();
	$response["success"]=false;

	while(mysqli_stmt_fetch($statement)){
		$response["success"]= true;
		$response["userID"]=$userID;
		$response["userPassword"]=$userPassword;
		$response["userName"]=$userName;
		$response["sex"]=$userSex
	}

	echo json_encode($response);
?>